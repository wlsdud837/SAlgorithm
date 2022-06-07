import java.util.*;
/*
* 1. 곱셈, 더하기 , 나누기 우선 순위 경우 수 6가지를 모두 계산한다.
* 2. 스택 또는 Deque를 활용하여 우선 순위를 구현한다.
* 3. 절대값을 최대값 갱신
*
*
*/
class Solution {
    static long answer;
    public long solution(String exp) {
        answer = 0;
        StringBuilder sb = new StringBuilder();
        Deque<Long> q = new LinkedList<>();
        Deque<Character> sq = new LinkedList<>();
        char [] str = exp.toCharArray();
        
        for(char a : str){
            if(a >= '0' && a <= '9' ){
                sb.append(a);
            }else {
                sq.add(a);
                q.add(Long.parseLong(sb.toString()));
                sb.delete(0, sb.length());
            }
        }
        
        q.add(Long.parseLong(sb.toString()));
        dfs(q, sq, 0, 'x');
        return answer;
    }
    static void dfs(Deque<Long> q,  Deque<Character> sq, int depth, char pre){
        if(depth == 2){
             while(!sq.isEmpty()){
                    char a = sq.poll();
                    long number = q.poll();
                    long t  = q.poll();
                    q.addFirst(cal(number, t, a));
            }
            Long res = q.poll();
            if(res < 0)res *= - 1;
            answer = Math.max(answer, res);
            return;
        }else {
            char []  s = {'*','+','-'};
            for(int i = 0; i < 3; i++){
                if(s[i] == pre)continue;
                Deque<Long> copynums = new LinkedList<>(q);
                Deque<Character> copychars = new LinkedList<>(sq);
                Deque<Long> nums = new LinkedList<>();
                Deque<Character> chars = new LinkedList<>();
                
                while(!copychars.isEmpty()){
                    char a = copychars.poll();
                    long number = copynums.poll();
                    
                    if(s[i] == a){
                        long t = copynums.poll();
                        copynums.addFirst(cal(number, t, a));
                    }else {
                        nums.add(number);
                        chars.add(a);
                    }
                }
                while(!copynums.isEmpty())nums.add(copynums.poll());
                
                dfs(nums, chars, depth + 1,s[i] );
            }
        }
    }
    static long cal(long a, long b, char c){
        if(c == '*')return a* b;
        if(c == '+')return a + b;
        return a - b;
    }
}