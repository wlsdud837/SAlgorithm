
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
* 1. 불 넓어지는 것 BFS 로 표현
* 2. 주인공이 현재 위치에서 이동할 수 잇는 방법 이동
* 3. 주인공은 벽을 통과할 때 밖으로 나올지 장담할 수 없다. 
* 4. 이를 위해 벽을 통과하는 동안은 여러 시도를 허용한다.
* 3. 악당에 조건에 맞게 이동 
*/
class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T =  Integer.parseInt(st.nextToken());
		int [][]map = new int[1000][1000];
		boolean [][]vmap = new boolean[1000][1000];
		boolean [][]smap = new boolean[1000][1000];

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int r =  Integer.parseInt(st.nextToken());
			int c =  Integer.parseInt(st.nextToken());
			int K =  Integer.parseInt(st.nextToken());
			int []di = {0,1,0,-1};
			int []dj = {1,0,-1,0};
			Queue<Pair> qf = new LinkedList<Pair>();
			Queue<Pair> qv = new LinkedList<Pair>();
			Queue<Pair2> qs = new LinkedList<Pair2>();
            for(int i = 0 ; i < r; i++){
                for(int j = 0; j < c; j++){
                    map[i][j] = 0;
                    vmap[i][j] = false;
                    smap[i][j] = false;
                }
            }
			int res = 0;
			boolean flag = true;
			
			for(int i = 0; i < c; i++) {
				st = new StringTokenizer(br.readLine());
				char[] clist = st.nextToken().toCharArray();
				for(int j = 0; j < r; j++) {
					char a = clist[j];
					map[i][j] = a;
					if(a == 'S') {
						qs.add(new Pair2(i, j, K));
						smap[i][j] = true;
						map[i][j] = 'A';
					}
					else if(a == 'F') {
						qf.add(new Pair(i, j));
					}
					else if(a == 'V') {
						qv.add(new Pair(i, j));
						vmap[i][j] = true;
						map[i][j] = 'A';
					}
				}
			}
			
			while(flag) {
				res++;
				// 불
				Queue<Pair> tempqf = new LinkedList<Pair>();
				Queue<Pair> tempqv = new LinkedList<Pair>();
				Queue<Pair2> tempqs = new LinkedList<Pair2>();
				while(!qf.isEmpty()) {
					Pair p = qf.poll();
					for(int i = 0; i <4; i++) {
						int dy = p.y + di[i];
						int dx = p.x + dj[i];
						if(dx < 0 || dy < 0 || dx >= c || dy >= r || map[dy][dx] != 'A' || map[dy][dx] == 'F') continue;
						map[dy][dx] = 'F';
						tempqf.add(new Pair(dy, dx));
					}
				}
				qf.addAll(tempqf);
				//System.out.println(res);
				// 주인공
				while(!qs.isEmpty()) {
					Pair2 p = qs.poll();
					for(int i = 0; i <4; i++) {
						int dy = p.y + di[i];
						int dx = p.x + dj[i];
						int dk = p.k;
						if(dx < 0 || dy < 0 || dx >= c || dy >= r || smap[dy][dx] || map[dy][dx] == 'X') continue;
						if(map[dy][dx] == 'A') {
							smap[dy][dx] = true;
							tempqs.add(new Pair2(dy, dx,K));
						}else if(map[dy][dx] == 'W' && dk > 0) {
							tempqs.add(new Pair2(dy, dx, dk - 1));
						}else if(map[dy][dx] == 'E') {
							flag = false;
                            break;
						}
					}
				}
				qs.addAll(tempqs);
				//System.out.println(res);
				if(qs.isEmpty() && flag) {
                    flag = false;
                    res =-1;
                    break;
                }
				// 악당
				while(!qv.isEmpty()) {
					Pair p = qv.poll();
					for(int i = 0; i <4; i++) {
						int dy = p.y + di[i];
						int dx = p.x + dj[i];
						if(dx < 0 || dy < 0 || dx >= c || dy >= r || vmap[dy][dx] || map[dy][dx] == 'X' ) continue;
						vmap[dy][dx] = true;
						if(map[dy][dx] == 'A') {
							tempqv.add(new Pair(dy, dx));
						}else if(map[dy][dx] == 'F') {
							tempqv.add(new Pair(dy, dx));
						}else if(map[dy][dx] == 'E') {
							flag = false;
                            res = -1;
                            break;
						}
						
					}
				}
				qv.addAll(tempqv);
			}
			System.out.println("#"+test_case+" "+res);
		}
		
		
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

class Pair2{
	int y;
	int x;
	int k;
	public Pair2(int y, int x, int k) {
		this.y = y;
		this.x = x;
		this.k = k;
	}
}