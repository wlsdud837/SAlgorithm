import java.util.*;

class Solution {
    /*
    * 1.해쉬 맵을 통해 종류의 갯수를 구한다.
    * 2. 각 종류의 갯수 구하기 
    * 3. 경우의 수 = (각 종류의 갯수 + 안 고른 경우들) - 1(모두 안 고른 경우 제외) 
    */
    public int solution(String[][] c) {
        int answer = 1; 
        //1.해쉬 맵을 통해 종류의 갯수를 구한다.
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < c.length; i++){
            //2. 각 종류의 갯수 구하기 
            if(map.get(c[i][1]) == null)map.put(c[i][1], 1);
            else map.put(c[i][1], map.get(c[i][1]) + 1);
        }
        
        // 3.경우의 수 = (각 종류의 갯수 + 안 고른 경우들) - (모두 안 고른 경우 제외)
        for(String s : map.keySet())answer *= map.get(s) + 1;
        
        return answer - 1;
    }
}