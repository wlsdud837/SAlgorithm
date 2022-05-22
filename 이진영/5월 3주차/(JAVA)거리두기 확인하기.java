import java.util.*;

class Solution {
    /*
    * 1. 2차배열 세팅
    * 2. BFS를 통해 확인
    * 3. 시작점 벽으로 전환
    * 4. 일정 거리, 외부, 벽 확인
    * 5. 조건에 만족 못하면 0 리턴
    */
    public int[] solution(String[][] p) {
        int[] answer = new int [5];
        for(int i = 0; i < 5; i++){
            char [][]map1 = new char[5][5];
            for(int j = 0; j < 5; j++){
                String str = p[i][j];
                for(int k = 0; k < 5; k++){
                    map1[j][k] = str.charAt(k);
                }
            }
            // 각각 거리 두기 확인
            answer[i] = bfs(map1);    
        }
        return answer;
    }
    
    static int bfs(char [][]map){
        int []di = {0,1,0,-1};
		int []dj = {1,0,-1,0};
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0 ; j < 5; j++) {
				if(map[i][j] != 'P')continue;
                // 시작점 벽으로 전환
				map[i][j] = 'X';
				int cnt = 0;
                Queue<Pair> q = new LinkedList<Pair>();
				q.add(new Pair(i, j));
				while(!q.isEmpty()) {
                    int size = q.size();
                    cnt++;
                    for(int ss = 0; ss< size; ss++){
                        Pair p = q.poll();
					    for(int x = 0; x < 4; x++) {
						    int dy = p.y + di[x];
						    int dx = p.x + dj[x];
                            // 외부 또는 벽 만나면 제외
						    if(dx < 0 || dy < 0 || dx >= 5 || dy >= 5 || map[dy][dx] == 'X')continue;
                            //5. 조건에 만족 못하면 0 리턴
                            if(map[dy][dx] == 'P')return 0;
						    q.add(new Pair(dy, dx));
					    }
                    }
                    // 거리 확인
                    if(cnt == 2)break;
				}
                
			}
		}
		return 1;
    }
}

class Pair{
	int y;
	int x;
	public Pair(int y, int x) {
		this.y = y;
		this.x = x;
	}
}