import java.util.*;
/*
* 1. dfs를 사용하여 user_id, banner_id를 연결 될 수 있는 조합들을 만든다.
* 2. 매칭되는 제제 아이디를 모은다. 
* 3. Set를 활옹하여 중복되는 제제아이디 리스트를 제거한다.
*/
class Solution {
    static int answer;
    static Set<String> set;
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        set = new HashSet<String>();
        int []user = new int[user_id.length];
        int []ban = new int[banned_id.length];
        
        make_sol(user_id, banned_id, user, ban, user_id.length, banned_id.length);
        return set.size();
    }
    void make_sol(String [] u ,String []b, int []user, int[]ban, int userlen, int banlen){
        boolean []banlist = new boolean[userlen];
        dfs1(u, b, user, ban, userlen, banlen, 0, banlist); // 조합 생성
    }
    void dfs1(String [] u ,String []b, int []user, int[]ban, int userlen, int banlen, int s, boolean[] banlist){
        if(s == banlen){
            String[] str = new String[banlen];
            for(int i = 0; i < banlen; i++){
                if(isEq(b[i],u[ban[i]])){ // 제제아이디와 일치하는지 확인
                    return;
                }
                str[i] = u[ban[i]];
            }
            Arrays.sort(str); 
            StringBuilder answer = new StringBuilder();
            for(int i = 0; i < banlen; i++){
                answer.append(str[i]);
            }
            set.add(answer.toString()); // 제제 아이디 누적하기
        }else {
            for(int i = 0; i < userlen; i++){
                if(banlist[i])continue;
                ban[s] = i;
                banlist[i] = true;
                dfs1(u, b, user, ban, userlen, banlen, s + 1, banlist); 
                banlist[i] = false;
                ban[s] = 0;
            }
        }
    }
    boolean isEq(String s, String r){
        if(s.length() != r.length())return true;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '*')continue;
            if(s.charAt(i) != r.charAt(i))return true;
        }
        return false;
    }
}