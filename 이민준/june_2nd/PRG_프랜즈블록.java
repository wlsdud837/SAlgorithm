package SAlgorithm.이민준.june_2nd;

import java.util.HashSet;
import java.util.Set;

/**
 * 1. map 에 Friends 셋팅
 * 2. 4개 match 확인, Set 에 좌표 추가
 * 3. 4개 match 확인을 위해 삭제는 한번에 한다. 삭제하면서 answer 에 갯수 더하기
 * 4. 빈자리에 Friends 내리기
 * 5. 더 이상 블록을 없앨 수 없을 때까지 2, 3, 4 반복
 */
public class PRG_프랜즈블록 {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        System.out.println(solution(m, n, board));
    }

    static int answer = 0;
    static boolean check = false;

    private static int solution(int m, int n, String[] board) {
        final int max = 31;
        char[][] map = new char[m][n];
        Set<Integer> checkSet = new HashSet<>();

        /**
         * 1. map 에 Friends 셋팅
         */
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        /**
         * 2. 4개 match 확인, Set 에 좌표 추가
         * 3. 4개 match 확인을 위해 삭제는 한번에 한다. 삭제하면서 answer 에 갯수 더하기
         * 4. 빈자리에 Friends 내리기
         * 5. 더 이상 블록을 없앨 수 없을 때까지 2, 3, 4 반복
         */
        while (!check) {
            friendsPopOut(m, n, max, map, checkSet);
            friendsFallDown(m, n, map);
//            printMap(m, n, map);
        }

        return answer;
    }

    private static void printMap(int m, int n, char[][] map) {
        System.out.println("========= print start ===========");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("========== print end ============");
    }

    private static void friendsFallDown(int m, int n, char[][] map) {
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '0') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (map[k][j] != '0') {
                            map[i][j] = map[k][j];
                            map[k][j] = '0';
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void friendsPopOut(int m, int n, int max, char[][] map, Set<Integer> checkSet) {
        int r;
        int c;
        check = true;
        checkSet.clear();
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] != '0' && isMatched(i, j, map)) {
                    checkSet.add(i * max + j);
                    checkSet.add((i + 1) * max + j);
                    checkSet.add(i * max + (j + 1));
                    checkSet.add((i + 1) * max + (j + 1));
                    check = false;
                }
            }
        }

        answer += checkSet.size();
        for (int delValue : checkSet) {
            r = delValue / max;
            c = delValue % max;
            map[r][c] = '0';
        }
    }

    private static boolean isMatched(int i, int j, char[][] map) {
        if (map[i][j] == map[i + 1][j]
                && map[i][j] == map[i][j + 1]
                && map[i][j] == map[i + 1][j + 1]) {
            return true;
        }
        return false;
    }
}
