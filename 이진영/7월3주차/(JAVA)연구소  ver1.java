package B14502연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.math.*;

public class Main {
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int y = Integer.parseInt(st.nextToken());

		int x = Integer.parseInt(st.nextToken());
		int[][] map = new int[y][x];

		ArrayList<Pair> arr = new ArrayList<>();

		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < x; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					arr.add(new Pair(i, j));
				}
			}
		}
		max = 0;
		dfs(3, 0, map, y, x, arr);
		System.out.println(max);
	}

	static void dfs(int cnt, int num, int[][] map, int y, int x, ArrayList<Pair> arr) {
		if (cnt == 0) {
			int[][] copy = new int[y][x];
			for (int ci = 0; ci < y; ci++) {
				for (int cj = 0; cj < x; cj++) {
					copy[ci][cj] = map[ci][cj];
				}
			}
			/// System.out.println(num);
			int res = bfs(copy, arr, y, x);
			if (max < res) {
				max = res;
			}

		} else if (num < y * x) {
			int yy = num / x;
			int xx = num % x;

			if (map[yy][xx] == 0) {
				map[yy][xx] = 1;
				dfs(cnt - 1, num + 1, map, y, x, arr);
				map[yy][xx] = 0;
			}
			
			dfs(cnt, num + 1, map, y, x, arr);

		}
	}

	static int bfs(int[][] map, ArrayList<Pair> arr, int ysize, int xsize) {
		Queue<Pair> q = new LinkedList<Pair>();
		int[] di = { 0, 0, 1, -1 };
		int[] dj = { 1, -1, 0, 0 };
		for (Pair p : arr) {
			q.add(p);
		}
		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int dy = p.y + di[i];
				int dx = p.x + dj[i];
				if (dy < 0 || dx < 0 || dy >= ysize || dx >= xsize || map[dy][dx] == 2 || map[dy][dx] == 1)
					continue;
				map[dy][dx] = 2;
				q.add(new Pair(dy, dx));
			}
		}
		return checkmap(map);
	}

	static int checkmap(int[][] map) {
		int cnt = 0;
		for (int yy[] : map) {
			for (int xx : yy) {
				if (xx == 0)
					cnt++;
			}
		}

		return cnt;
	}

}

class Pair {
	int y;
	int x;

	Pair(int y, int x) {
		this.y = y;
		this.x = x;
	}
}