import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int [][]arr;
	static ArrayList<pair> wall;
	static ArrayList<pair> virus;
	static boolean []ch;
	static int []di = {0 , 0 , 1, -1};
	static int []dj = {1 , -1, 0, 0};
	static int r,c, result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
	
		wall = new ArrayList<>();
		virus =new ArrayList<>();
		arr = new int[r][c];
		
		for(int i =0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j =0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0)
					wall.add(new pair(i, j));
				else if(arr[i][j] == 2)
					virus.add(new pair(i, j));
			}
		}
		ch = new boolean[wall.size()];
		result = 0;
		DFS(0, 0);
		System.out.println(result);
	}
	static void DFS(int num, int t) {
		if(num == 3) {
			int [][]temp = new int[r][c];
			for(int i = 0; i < r; i ++) {
				for(int j = 0; j < c; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			int x = BFS();
			for(int i = 0; i < r; i ++) {
				for(int j = 0; j < c; j++) {
					 arr[i][j] = temp[i][j];
				}
			}
			if(x > result)result = x;
			return;
		}
		for(int i = t; i < wall.size(); i++) {
			if(ch[i])continue;
			
			ch[i] = true;
			pair ss= wall.get(i);
			arr[ss.x][ss.y] = 1;
			DFS(num + 1, i);
			arr[ss.x][ss.y] = 0;
			ch[i] = false;
		}
	}
	static int BFS() {
		Queue<pair> p = new LinkedList<pair>();
		for(int i = 0; i < virus.size(); i++) {
			p.add(virus.get(i));
		}
		while(!p.isEmpty()) {
			pair s = p.poll();
			
			for(int i = 0; i < 4; i++) {
				int x = s.x + di[i];
				int y = s.y + dj[i];	
				if(x < 0 || y < 0 || x >= r || y >=c || arr[x][y] != 0)continue;
				arr[x][y] = 2;
				p.add(new pair(x, y));
			}
		}
		int res = 0;
		for(int i = 0; i < r; i ++) {
			for(int j = 0; j < c; j++) {
				 if(arr[i][j]== 0) res++;
			}
		}
		return res;
	}
}


class pair {
	int x;
	int y;

	pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}