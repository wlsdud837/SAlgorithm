import java.util.*;

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
        //조합 생성
        boolean []banlist = new boolean[userlen];
        dfs1(u, b, user, ban, userlen, banlen, 0, banlist);
    }
    void dfs1(String [] u ,String []b, int []user, int[]ban, int userlen, int banlen, int s, boolean[] banlist){
        if(s == banlen){
            //dfs2();
            String[] str = new String[banlen];
            for(int i = 0; i < banlen; i++){
                if(isEq(b[i],u[ban[i]])){
                    return;
                }
                str[i] = u[ban[i]];
            }
            Arrays.sort(str);
            StringBuilder answer = new StringBuilder();
            for(int i = 0; i < banlen; i++){
                answer.append(str[i]);
            }
            set.add(answer.toString());
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