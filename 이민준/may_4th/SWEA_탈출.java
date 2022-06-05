package SAlgorithm.이민준.may_4th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SWEA_7250_탈출
 *
 * 1. 앤트맨, 악당, 불에 대해 각각 입력을 받는다.
 * 2. 앤트맨, 악당, 불을 BFS 로 퍼뜨린다.
 * 3. 이때, 불 -> 악당 -> 앤트맨 순으로 각각 퍼뜨리는 것에 유의한다.
 * 4. 위 3가지 게임 요소는 제한 조건 안에서 퍼져나간다. (GameElement.canGo)
 * 5. 앤트맨 탈출 가능 여부에 따라 게임 끝.
 * key : 방문체크를 단순하게 생각해서는 안된다.
 *       ** 앤트맨이 A를 거점 삼아 W를 뚫는 카운트를 충전하고 왔던 길을 다시 되돌아갈 수 있기 때문이다.
 */
public class SWEA_탈출 {

    static int N, M, K;
    static int answer;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[][] map;
    static boolean[][] aVisited;
    static boolean[][] vVisited;
    static boolean[][] fVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int testcase = Integer.parseInt(tokens.nextToken());
        for (int caseNumb = 1; caseNumb <= testcase; caseNumb++) {
            tokens = new StringTokenizer(br.readLine());
            N = Integer.parseInt(tokens.nextToken());
            M = Integer.parseInt(tokens.nextToken());
            K = Integer.parseInt(tokens.nextToken());
            answer = 0;

            Queue<GameElement> antQ = new LinkedList<>();
            Queue<GameElement> villainQ = new LinkedList<>();
            Queue<GameElement> fireQ = new LinkedList<>();

            map = new char[N][M];
            aVisited = new boolean[N][M];
            vVisited = new boolean[N][M];
            fVisited = new boolean[N][M];

            for (int r = 0; r < N; r++) {
                map[r] = br.readLine().toCharArray();
            }

            /**
             * BFS 탐색을 위해 각각 Queue 에 추가
             */
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == 'S') {
                        antQ.offer(new GameElement(r, c, 0, 0, 0));
                        aVisited[r][c] = true;
                    }
                    if (map[r][c] == 'V') {
                        villainQ.offer(new GameElement(r, c, 1, 0, 0));
                        vVisited[r][c] = true;
                    }
                    if (map[r][c] == 'F') {
                        fireQ.offer(new GameElement(r, c, 2, 0, 0));
                        fVisited[r][c] = true;
                    }
                }
            }

            findEscape(antQ, villainQ, fireQ);
            System.out.println("#" + caseNumb + " " + answer);
        }

    }

    /**
     * 각 게임 요소를 BFS 로 퍼뜨린다.
     * 앤트맨이 더 이동할 수 없는 상황이 되면 Queue 가 빌 것. -> 탈출 불가 처리
     */
    private static void findEscape(Queue<GameElement> antQ, Queue<GameElement> villainQ, Queue<GameElement> fireQ) {
        while (!antQ.isEmpty()) {
            if (bfs(fireQ)) return;
            if (bfs(villainQ)) return;
            if (bfs(antQ)) return;
        }

        answer = -1;
        return;
    }

    /**
     * turnBack : 앤트맨이 A를 거점 삼아 돌아갔음을 체크하는 플래그. 거점 A가 여러 개여도 한번만 돌아가면 되므로 체크
     * 기존 bfs 와 큰 차이점은 없다. 단, 앤트맨의 현재 위치가 벽(W)일 때, 주변에 A가 있다면 거점 삼아 돌아온 경우를 queue 에 추가
     */
    private static boolean bfs(Queue<GameElement> queue) {
        boolean turnBack = false;
        int size = queue.size();
        GameElement newElement;
        for (int i = 0; i < size; i++) {
            turnBack = false;
            GameElement gameE = queue.poll();
            for (int d = 0; d < 4; d++) {
                newElement = new GameElement(gameE.r + dir[d][0], gameE.c + dir[d][1], gameE.kind, gameE.small, gameE.count + 1);
                if (newElement.canGo()) {
                    if (newElement.isEscaped()) {
                        return true;
                    }
                    if (!turnBack && gameE.kind == 0 && map[gameE.r][gameE.c] == 'W' && map[newElement.r][newElement.c] == 'A') {
                        queue.offer(new GameElement(gameE.r, gameE.c, gameE.kind, 1, newElement.count + 1));
                        turnBack = true;
                    }

                    queue.offer(newElement);
                    if (newElement.kind == 2) {
                        map[newElement.r][newElement.c] = 'F';
                    }
                }
            }
        }
        return false;
    }

    /**
     * kind : 0 - Ant, 1 - villain, 2 - fire
     * small : 벽을 지나온 횟수
     * count : 지금까지 움직인 횟수
     */
    private static class GameElement {
        int r;
        int c;
        int kind;
        int small;
        int count;

        public GameElement(int r, int c, int kind, int small, int count) {
            this.r = r;
            this.c = c;
            this.kind = kind;
            this.small = small;
            this.count = count;
        }

        /**
         * 각각의 게임 요소의 이동 가능 범위를 체크
         */
        public boolean canGo() {
            if (r < 0 || r >= N
                    || c < 0 || c >= M) {
                return false;
            }

            /**
             * 앤트맨의 이동 범위 체크
             * W 를 지나야하는 상황에는 small 이라는 카운트를 증가
             * 카운트가 최대 값을 넘기면 이동 제한
             */
            if (kind == 0 && !aVisited[r][c]) {
                if (map[r][c] == 'F'
                        || map[r][c] == 'X') {
                    return false;
                }
                if (map[r][c] == 'W') {
                    if (small < K)
                        small++;
                    else
                        return false;
                }
                if (map[r][c] == 'A') {
                    small = 0;
                }
                aVisited[r][c] = true;
                return true;
            }

            /**
             * 악당의 이동 범위 체크
             */
            if (kind == 1 && !vVisited[r][c]) {
                if (map[r][c] == 'W'
                        || map[r][c] == 'X') {
                    return false;
                }
                vVisited[r][c] = true;
                return true;
            }

            /**
             * 불의 이동 범위 체크
             * *출구에는 번지지 않는다.
             */
            if (kind == 2 && !fVisited[r][c]) {
                if (map[r][c] == 'W'
                        || map[r][c] == 'X'
                        || map[r][c] == 'E') {
                    return false;
                }
                fVisited[r][c] = true;
                return true;
            }
            return false;
        }

        /**
         * 탈출구까지 왔음을 체크
         * 불 : 관계 없음
         * 악당 : answer = -1 찍고 리턴
         * 앤트맨 : answer = count(해당 객체의 현재까지 이동 횟수) 찍고 리턴
         */
        public boolean isEscaped() {
            if (map[r][c] == 'E' && kind != 2) {
                if (kind == 1) answer = -1;
                else answer = count;
                return true;
            }
            return false;
        }
    }
}
