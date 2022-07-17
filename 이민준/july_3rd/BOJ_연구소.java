package SAlgorithm.이민준.july_3rd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_연구소 {
    static int row;
    static int col;
    static int emptySize;
    static int[][] map;
    static final int mulValue = 10;
    static List<Integer> empty;
    static Queue<Integer> virus;
    static int[] selected;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int answer;

    public static void main(String[] args) throws Exception {
        initValue();
        buildWall(0, 0);
        System.out.println(answer);
    }

    private static void buildWall(int start, int cnt) {
        if (cnt == 3) {
            int[][] mapExec = new int[row][col];
            mapCopy(mapExec, map);
            for (int i = 0; i < 3; i++) {
                mapExec[selected[i] / mulValue][selected[i] % mulValue] = 1;
            }
            //printMap(mapExec);
            answer = Math.max(answer, extendVirus(mapExec));
            return;
        }

        for (int i = start; i < emptySize; i++) {
            selected[cnt] = empty.get(i);
            buildWall(i + 1, cnt + 1);
        }

    }

    private static void printMap(int[][] mapExec) {
        for (int i = 0; i < row; i++) {
            System.out.println();
            for (int j = 0; j < col; j++) {
                System.out.print(mapExec[i][j] + " ");
            }
        }
        System.out.println();
        System.out.println();
    }

    private static int extendVirus(int[][] mapExec) {
        int size;
        int curr;
        int r, c, tmpR, tmpC;
        Queue<Integer> virusExec = new LinkedList<>(virus);

        while (!virusExec.isEmpty()) {
            size = virusExec.size();
            for (int i = 0; i < size; i++) {
                curr = virusExec.poll();
                r = curr / mulValue;
                c = curr % mulValue;
                for (int d = 0; d < 4; d++) {
                    tmpR = r + dir[d][0];
                    tmpC = c + dir[d][1];
                    if (isPossible(tmpR, tmpC, mapExec)) {
                        virusExec.offer(tmpR * mulValue + tmpC);
                        mapExec[tmpR][tmpC] = 2;
                    }
                }
            }
        }
        return calArea(mapExec);
    }

    private static int calArea(int[][] mapExec) {
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mapExec[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static boolean isPossible(int r, int c, int[][] map) {
        if (r >= 0 && r < row && c >= 0 && c < col && map[r][c] == 0) {
            return true;
        }
        return false;
    }

    private static void mapCopy(int[][] mapExec, int[][] map) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mapExec[i][j] = map[i][j];
            }
        }
    }

    private static void initValue() throws IOException {
        answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        row = Integer.parseInt(tokens.nextToken());
        col = Integer.parseInt(tokens.nextToken());
        emptySize = 0;
        map = new int[row][col];
        virus = new LinkedList<>();
        empty = new LinkedList<>();
        selected = new int[3];
        int input;
        for (int i = 0; i < row; i++) {
            tokens = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                input = Integer.parseInt(tokens.nextToken());
                map[i][j] = input;
                if (input == 0) {
                    empty.add(mulValue * i + j);
                    emptySize++;
                } else if (input == 2) {
                    virus.offer(mulValue * i + j);
                }
            }
        }
    }
}
