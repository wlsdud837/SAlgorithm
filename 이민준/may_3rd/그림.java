package SAlgorithm.이민준.may_3rd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그림 {
    static int rMax = 0;
    static int cMax = 0;
    static int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        rMax = Integer.parseInt(tokens.nextToken());
        cMax = Integer.parseInt(tokens.nextToken());
        int map[][] = new int[rMax][cMax];
        int ansCnt = 0;
        int max = 0;

        for (int i = 0; i < rMax; i++) {
            tokens = new StringTokenizer(br.readLine());
            for (int j = 0; j < cMax; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        for (int i = 0; i < rMax; i++) {
            for (int j = 0; j < cMax; j++) {
                if (map[i][j] == 1) {
                    max = Math.max(bfs(map, i, j), max);
                    ansCnt++;
                }
            }
        }

        System.out.println(ansCnt);
        System.out.println(max);
    }

    private static int bfs(int[][] map, int r, int c) {
        final int multi = 501;
        Queue<Integer> posQ = new LinkedList<>();
        int size = 0;
        int curr = 0;
        int tmpR, tmpC;
        int cnt = 1;

        posQ.offer(r * multi + c);
        map[r][c] = 0;

        while (!posQ.isEmpty()) {
            size = posQ.size();
            for (int i = 0; i < size; i++) {
                curr = posQ.poll();
                r = curr / multi;
                c = curr % multi;
                for (int d = 0; d < 4; d++) {
                    tmpR = r + dir[d][0];
                    tmpC = c + dir[d][1];
                    if (isIn(tmpR, tmpC) && map[tmpR][tmpC] == 1) {
                        posQ.offer(tmpR * multi + tmpC);
                        map[tmpR][tmpC] = 0;
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    private static boolean isIn(int r, int c) {
        if (r >= 0 && r < rMax && c >= 0 && c < cMax) {
            return true;
        }

        return false;
    }
}
