import java.util.*;

class Solution {
    static int []ans;
    static int max;
    static boolean flag;
    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        ans = new int[11];
        max = -1;
        flag = true;
        dfs(n, info, answer, 0);
        if(flag){
            ans = new int[1];
            ans[0] = -1;
        }
        return ans;
    }
    void dfs(int n, int[] info, int []answer, int num){
        if(num == 10){
            if(num == 10)answer[10] = n;
            int sum = 0;
            int in = 0;
            for(int j = 0; j < 10; j++){
                if(info[j] == answer[j]) continue;
                if(info[j] < answer[j]){
                    sum += 10 - j;
                }
                if(info[j] > answer[j]){
                    in += 10 - j;
                }
            }
            int diff = sum - in;
            
            if(sum > in && max <= diff){
                flag = false;  
                int i = 0;
                if(max < diff){
                    max = diff;
                    for(int a : answer)ans[i++] = a;
                  
                    return;
                }
                else if(max == diff && check(ans, answer)){
                    for(int a : answer)ans[i++] = a;
                    return;
                }
            }
            return;
        }else if(num <= 10){
            
            dfs(n , info, answer, num + 1);    
            
            if(n - info[num] - 1 >= 0){
                int x = answer[num];
                answer[num] = info[num] + 1;
                dfs(n - info[num] - 1, info, answer, num + 1);
                answer[num] = x;
            }
        }
    }
    boolean check(int[] a, int [] b){
        for(int i = 10; i >= 0; i--){
            if((a[i] == 0 && b[i] == 0) || a[i] == b[i])continue;
            if(a[i] < b[i]) return true;
            if(a[i] > b[i]) return false;
        }
        return true;
    }
}