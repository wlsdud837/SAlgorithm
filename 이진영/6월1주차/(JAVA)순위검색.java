import java.util.*;
class Solution {
    static int num;
    static int [] answers;
    public int[] solution(String[] info, String[] query) {

        int len = info.length;
        String [][] str = new String[len][5];        
        ArrayList<Integer> [] list = new ArrayList[24];
        for(int i =0; i < 24; i++){
            list[i] = new ArrayList<>();
        }
        HashMap<String, Integer>[] lang =  new HashMap[4];
        lang[0] =  new HashMap<>();
        lang[1] =  new HashMap<>();
        lang[2] =  new HashMap<>();
        lang[3] =  new HashMap<>();
        lang[0].put("java", 8);
        lang[0].put("cpp", 0);
        lang[0].put("python", 16);
        lang[1].put("backend",0);
        lang[1].put("frontend",4);
        lang[2].put("junior",0);
        lang[2].put("senior",2);
        lang[3].put("chicken",0);
        lang[3].put("pizza",1);
        
        for(int i = 0; i < len; i++){
            int size = 0;
            str[i] = info[i].split(" ");
            for(int j = 0; j < 4; j++)size += lang[j].get(str[i][j]); 
            list[size].add(Integer.parseInt(str[i][4]));
        }
        
        for(int i = 0; i < 24; i++){
            Collections.sort(list[i], Collections.reverseOrder());
        }
        
        int qlen = query.length;
        
        answers = new int[qlen];
        
        for(int i = 0; i < qlen; i++){
            String[] ans = query[i].split(" ");
            num = 0;
            dfs(ans, list,0,lang,0,Integer.parseInt(ans[7]), i);
            
        }
        return answers;
    }
    static void dfs(String []ans, ArrayList<Integer> [] list,int select,HashMap<String, Integer>[] m1,int depth, int answer, int ii){
        if(depth == 4){
            int num = 0;
            for(Integer s : list[select]){
                if(answer <= s){
                    num++;
                }else break;
            }
            answers[ii] += num;
            return;
        }else {
            if("-".equals(ans[depth * 2])){
                for(String ss : m1[depth].keySet()){
                    dfs(ans, list,select + m1[depth].get(ss),m1,depth + 1,answer,ii);
                }
            }else {
                dfs(ans, list,select + m1[depth].get(ans[depth * 2]),m1,depth + 1,answer,ii);
            }
        }
    }
}