import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        HashMap<String, Integer> io = new HashMap<>();
        HashMap<String, Integer> res = new HashMap<>();
        for(String str :  records){
            String [] s = str.split(" ");
            if(io.get(s[1]) == null){
                io.put(s[1], time(s[0]));
            }else {
                int t = time(s[0]) - io.get(s[1]);
                if(res.get(s[1]) == null){
                    res.put(s[1], t);
                }else {
                    res.put(s[1], t + res.get(s[1]));
                }
                io.remove(s[1]);
            }
        }
        
        for(String s : io.keySet()){
            int t = 23 * 60 + 59 - io.get(s);
            
                if(res.get(s) == null){
                    res.put(s, t);
                }else {
                    res.put(s, t + res.get(s));
                }

        }
        List<String> ans = new ArrayList<>();
        for(String s : res.keySet()){
           res.put(s, cal(res.get(s), fees));
            ans.add(new StringBuilder(s).append(" ").append(res.get(s)).toString());
        }
        
        answer = new int[ans.size()];
        String []strans = new String[ans.size()];
        int n =0 ;
        for(String a : ans){
            strans[n++] = a;
        }
        Arrays.sort(strans);
        n = 0;
        for(String a : strans){
            answer[n++] = Integer.parseInt(a.split(" ")[1]);
        }
        return answer;
    }
    static int cal(int t, int [] fee){
        if(t <= fee[0]){
            return fee[1];
        }else{
            return fee[1] + (int)(Math.ceil((double)(t - fee[0]) / fee[2])*fee[3]);
        }
    }
    static int time(String as){
        String [] s = as.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]) ;
    }
}