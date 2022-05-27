package B11559PuyoPuyo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int max;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int [][]map = new int[12][6];
		
		max = 0;
		for(int i = 0; i < 12; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j = 0 ; j < 6; j++) {
				char a = str.charAt(j);
				if(a == '.')map[i][j] = 0;
				else  map[i][j] = a - 'A';
			}
		}
		
		map = bfs(map, 12, 6);
		if(flag)max++;
		while(flag) {
			map = g(map, 12, 6);
			map = bfs(map, 12, 6);
			if(flag)max++;
		}
		System.out.println(max);
	}
	
	static int[][] bfs(int [][]map, int r, int c) {
		int []di = {0,1,0,-1};
		int []dj = {1,0,-1,0};
		Queue<Pair> q = new LinkedList<Pair>();
		
		flag = false;
		for(int i = 0; i < r; i++) {
			for(int j = 0 ; j < c; j++) {
				if(map[i][j] == 0)continue;
				Queue<Pair> b = new LinkedList<Pair>();
				int num  = map[i][j];
				int cnt = 1;
				
				map[i][j] = 0;
				q.add(new Pair(i, j));
				b.add(new Pair(i, j));
				while(!q.isEmpty()) {
					Pair p = q.poll();
					for(int x = 0; x < 4; x++) {
						int dy = p.y + di[x];
						int dx = p.x + dj[x];
						if(dx < 0 || dy < 0 || dx >= c || dy >= r || map[dy][dx] != num) continue;
						map[dy][dx] = 0;
						cnt++;
						b.add(new Pair(dy, dx));
						q.add(new Pair(dy, dx));
					}
				}
				
				if(cnt >= 4) {
					while(!b.isEmpty()) {
						Pair p = b.poll();
						map[p.y][p.x] = 0;
					}
					flag = true;
				}else {
					while(!b.isEmpty()) {
						Pair p = b.poll();
						map[p.y][p.x] = num;
					}
				}
			}	
		}
		return map;
	}
	
	static int[][] g(int [][]map, int r, int c) {
		Queue<Integer> q = new LinkedList<>();
		int [][] res = new int[r][c];
		
		for(int i = 0; i < c; i ++) {
			int t = 11; 
			
			for(int j = 11; j >= 0; j--) {
				if(map[j][i] == 0)continue;
				q.add(map[j][i]);
			}
			while(!q.isEmpty())res[t--][i] = q.poll();
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