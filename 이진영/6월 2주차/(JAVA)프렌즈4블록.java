import java.util.*;

class Solution {
    static int answer;
    static boolean flag;
    public int solution(int m, int n, String[] b) {
        answer = 0;
        flag = true;
        char [][] map = new char[m][n];
        int y =0;
        int x =0;
        for(String s : b){
            x=0;
            for(char a : s.toCharArray()){
                map[y][x] = a;
                    x++;
            }
            y++;
        }
       // System.out.println(map[1][1]);
        while(flag){
           if(answer != 0){
                map = gravity(map,m,n);
               //System.out.println("확인");
            }
            map = clear(map,m - 1,n - 1);
        }
        return answer;
    }
    static char [][] clear(char[][] m, int y, int x){
        boolean [][]check = new boolean[y + 1][x + 1];
        boolean temp = false;
        for(int i = 0; i < y; i ++){
            for(int j = 0; j < x; j++){
                if(m[i][j] >= 'A' && m[i][j] == m[i + 1][j] && m[i][j] == m[i][j + 1] && m[i][j] == m[i + 1][j + 1] ){
                    check[i][j] = true;
                    check[i + 1][j] = true;
                    check[i][j + 1] = true;
                    check[i+1][j+1] = true;
                    temp = true;
                }
            }
        }
        int ans = 0;
         for(int i = 0; i < y + 1; i ++){
            for(int j = 0; j < x + 1; j++){
                if(check[i][j]){
                    m[i][j] = 0;
                    ans++;
                }
            }
        }
        flag = temp;
        answer += ans;
        return m;
    }
	static char[][] gravity(char [][]map, int r, int c) {
		Queue<Character> q = new LinkedList<>();
		char [][] res = new char[r][c];
		
		for(int i = 0; i < c; i ++) {
			int t = r - 1; 
			
			for(int j = r - 1; j >= 0; j--) {
				if(map[j][i] == 0)continue;
				q.add(map[j][i]);
			}
			while(!q.isEmpty())res[t--][i] = q.poll();
		}
		return res;
	}
}