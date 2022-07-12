import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        return bfs(maps);
    }
    static int bfs(int [][]map){
        int []di = {0,1,0,-1};
		int []dj = {1,0,-1,0};
        int yy = map.length;
        int xx = map[0].length;
		int cnt = 0;
        
        Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0, 0));
		while(!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for(int t = 0; t < size; t++){
                Pair p = q.poll();
                map[p.y][p.x] = 0;
                if(p.y == yy - 1 && p.x == xx - 1)return cnt;
		        for(int x = 0; x < 4; x++) {
			    int dy = p.y + di[x];
			    int dx = p.x + dj[x];
			    if(dx < 0 || dy < 0 || dx >= xx || dy >= yy || map[dy][dx] == 0)continue;
                   // System.out.println(dy + " " + dx + " " + cnt);
			        q.add(new Pair(dy, dx));
		        }
            }
	    }  
		return -1;
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