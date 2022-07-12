package SAlgorithm.이민준.july_2nd;

import java.util.LinkedList;
import java.util.Queue;

public class PRG_게임맵최단거리 {
    public static void main(String[] args) {
        int[][] map = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(solution(map));
    }

    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int m;
    static int n;

    private static int solution(int[][] map) {
        return bfs(map);
    }

    private static int bfs(int[][] map) {
        final int max = 101;
        int answer = 0;
        m = map.length;
        n = map[0].length;
        int curr, r, c, tmpR, tmpC;

        Queue<Integer> posQ = new LinkedList<>();
        posQ.offer(0);
        map[0][0] = 0;
        int size;

        while (!posQ.isEmpty()) {
            size = posQ.size();
            answer++;
            for (int i = 0; i < size; i++) {
                curr = posQ.poll();
                r = curr / max;
                c = curr % max;
                for (int d = 0; d < 4; d++) {
                    tmpR = r + dir[d][0];
                    tmpC = c + dir[d][1];
                    if (tmpR == m - 1 && tmpC == n - 1) {
                        return answer + 1;
                    }
                    if (isIn(tmpR, tmpC, map)) {
                        posQ.offer(tmpR * max + tmpC);
                        map[tmpR][tmpC] = 0;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isIn(int r, int c, int[][] map) {
        if (r >= 0 && r < m && c >= 0 && c < n && map[r][c] == 1) {
            return true;
        }
        return false;
    }
}
