import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
    /*
    * 1. 2차배열 세팅
    * 2. BFS로 최대 넓이와 넓이 갯수를 구한다.
	* 3. 넓이는 Q에 들어간 만큼을 뜻한다.
	* 4. 넓이 갯수는 q가 완전히 비워지고 다시 큐가 들어간 횟수를 뜻한다.
    */

public class Main {
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int [][]map = new int[r][c];
		max = 0;
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//bfs로 최대 넒이와 넓이 갯수를 구한다.
		int []ans= bfs(map, r, c);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}
	static int[] bfs(int [][]map, int r, int c) {
		int []di = {0,1,0,-1};
		int []dj = {1,0,-1,0};
		int []res = new int[2];
		Queue<Pair> q = new LinkedList<Pair>();
		
		for(int i = 0; i < r; i++) {
			for(int j = 0 ; j < c; j++) {
				if(map[i][j] == 0)continue;
				res[0]++; // 넓이 갯수 카운트
				map[i][j] = 0;
				int tmax = 1;
				
				q.add(new Pair(i, j));
				while(!q.isEmpty()) {
					Pair p = q.poll();
					for(int x = 0; x < 4; x++) {
						int dy = p.y + di[x];
						int dx = p.x + dj[x];
						if(dx < 0 || dy < 0 || dx >= c || dy >= r || map[dy][dx] == 0)continue;
						map[dy][dx] = 0;
						tmax++;
						q.add(new Pair(dy, dx));
					}
				}
				res[1] = Math.max(tmax, res[1]); // 최대 넓이 구하기
			}
			
		}
			
		
		return res;
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
