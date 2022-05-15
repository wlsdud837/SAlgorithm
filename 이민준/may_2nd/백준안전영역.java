package SAlgorithm.이민준.may_2nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준안전영역 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens;
        int N = Integer.parseInt(br.readLine());
        int map[][] = new int[N][N];
        int min = Integer.MAX_VALUE >> 1;
        int max = 0;
        int input = 0;
        int answer = 1;

        for (int r = 0; r < N; r++) {
            tokens = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                input = Integer.parseInt(tokens.nextToken());
                min = Math.min(input, min);
                max = Math.max(input, max);
                map[r][c] = input;
            }
        }

        if (min != max) {
            for (int curr = min; curr <= max; curr++) {
                answer = Math.max(solve(N, map, curr), answer);
            }
        }

        System.out.println(answer);

    }

    private static int solve(int N, int[][] map, int curr) {
        Queue<Integer> positionQ = new LinkedList<>();
        boolean[][] chkMap = new boolean[N][N];
        int safeCnt = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] <= curr) {
                    chkMap[r][c] = true;
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!chkMap[r][c]) {
                    chkMap[r][c] = true;
                    positionQ.offer(r * 1000 + c);
                    bfs(N, chkMap, positionQ);
                    safeCnt++;
                }
            }
        }

        return safeCnt;
    }

    private static void bfs(int N, boolean[][] chkMap, Queue<Integer> positionQ) {
        int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int pos, r, c;
        int tmpR, tmpC;
        int size;

        while (!positionQ.isEmpty()) {
            size = positionQ.size();
            for (int i = 0; i < size; i++) {
                pos = positionQ.poll();
                r = pos / 1000;
                c = pos % 1000;
                for (int d = 0; d < 4; d++) {
                    tmpR = r + dir[d][0];
                    tmpC = c + dir[d][1];
                    if (isIn(N, tmpR, tmpC) && !chkMap[tmpR][tmpC]) {
                        chkMap[tmpR][tmpC] = true;
                        positionQ.offer(tmpR * 1000 + tmpC);
                    }
                }
            }
        }

        return;
    }

    private static boolean isIn(int N, int tmpR, int tmpC) {
        if (tmpR >= 0 && tmpR < N
                && tmpC >= 0 && tmpC < N) {
            return true;
        }

        return false;
    }
}
