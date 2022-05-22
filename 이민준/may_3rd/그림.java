package SAlgorithm.이민준.may_3rd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * section.1    : Test Case 입력
 * section.2    : map 을 서치하며 1인 좌표를 bfs 시작점으로 설정, 그림의 수 +1 증가
 * section.3-1  : 시작점으로부터 bfs 로 map 을 탐색하며 해당 그림을 완성
 * section.3-2  : 그림의 사이즈를 반환하며 최대 사이즈를 갱신
 */
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

        // Test Case 입력
        for (int i = 0; i < rMax; i++) {
            tokens = new StringTokenizer(br.readLine());
            for (int j = 0; j < cMax; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        /**
         *  - map 서치하면서 '1'을 만나면 bfs로 탐색하여 하나의 그림을 완성
         *  - 그림 사이즈를 기존 max 사이즈와 비교하며 갱신
         *  - 그림 하나를 발견할 때마다 ansCnt 1증가
         */
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

    /**
     * @param map   : Test Case 를 표기한 map
     * @param r     : 시작점의 row
     * @param c     : 시작점의 column
     * @return      :그림의 사이즈
     */
    private static int bfs(int[][] map, int r, int c) {
        final int multi = 501;
        Queue<Integer> posQ = new LinkedList<>();
        int size = 0;
        int curr = 0;
        int tmpR, tmpC;
        int cnt = 1;

        posQ.offer(r * multi + c);
        map[r][c] = 0;

        // 한번 방문한 좌표는 0으로 치환하여 다시 방문하는 것을 방지
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

    /**
     * 좌표가 map을 벗어나지 않는 지 체크
     */
    private static boolean isIn(int r, int c) {
        if (r >= 0 && r < rMax && c >= 0 && c < cMax) {
            return true;
        }

        return false;
    }
}
