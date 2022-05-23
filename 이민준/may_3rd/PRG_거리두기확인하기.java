package SAlgorithm.이민준.may_3rd;

/**
 * section.1 : places 배열로 map 입력
 * section.2 : map 탐색, P 를 찾으면 dfs 로 탐색
 * section.3 : 거리 2까지 탐색 중 P 를 찾으면 리턴
 *
 * mistake : 방문했던 좌표는 표기하여 재방문을 막아야 한다.
 */
public class PRG_거리두기확인하기 {
    public static void main(String[] args) {
        int[][] answer = new int[2][6];
        System.out.println(answer.length);
        System.out.println(answer[0].length);
    }

    static boolean check;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        char[][] map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            check = false;
            for (int j = 0; j < 5; j++) {
                map[j] = places[i][j].toCharArray();
            }
            solve(map);
            if (!check) {
                answer[i] = 1;
            }
        }

        return answer;
    }

    private void solve(char[][] map) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 'P') {
                    map[i][j] = 'X';
                    dfs(map, i, j, 0);
                    if (check) return;
                }
            }
        }
    }

    private void dfs(char[][] map, int r, int c, int cnt) {

        if (check || cnt == 2) {
            return;
        }

        for (int d = 0; d < 4; d++) {
            int tmpR = r + dir[d][0];
            int tmpC = c + dir[d][1];
            if (tmpR >= 0 && tmpR < 5 && tmpC >= 0 && tmpC < 5
                    && map[tmpR][tmpC] != 'X') {
                if (map[tmpR][tmpC] == 'P') {
                    map[tmpR][tmpC] = 'X';
                    check = true;
                    return;
                }
                map[tmpR][tmpC] = 'X';
                dfs(map, tmpR, tmpC, cnt + 1);
                map[tmpR][tmpC] = 'O';
            }
        }
    }
}
