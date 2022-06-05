package SAlgorithm.이민준.may_4th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  1. a, n, t, i, c 반드시 들어가는 문자이므로 예외처리 (K - 5)
 *  2. 그 외에 배워야 하는 문자들을 추려서 teachChar 에 수집
 *  3. 배워야 하는 문자들을 대상으로 남은 K 개 조합
 *  4. 읽을 수 있는 단어들을 카운트하여 최대 경우를 출력
 *  * 가르칠 수 있는 문자의 수가 가르쳐야 할 모든 문자의 수를 넘어선다면 N출력
 *  * 가르칠 수 있는 문자의 수가 5개(a, n, t, i, c)에도 못 미친다면 0 출력
 */
public class 백준_가르침 {
    static int N, K, len;
    static int answer;
    static LinkedList<String> words;
    static char[] teachChar;
    static int[] peeked;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken()) - 5;
        answer = 0;
        words = new LinkedList<>();
        HashSet<Character> charSet = new HashSet<>();
        char[] charArr;
        String word;
        if (K > 20) {
            System.out.println(N);
        } else if (K >= 0) {
            for (int i = 0; i < N; i++) {
                word = br.readLine().replaceAll("a", "")
                                    .replaceAll("n", "")
                                    .replaceAll("t", "")
                                    .replaceAll("i", "")
                                    .replaceAll("c", "")
                                    .trim();
                words.add(word);
                charArr = word.toCharArray();
                for (char input : charArr) {
                    charSet.add(input);
                }
            }
            StringBuilder teachSb = new StringBuilder();
            for (char input : charSet) {
                teachSb.append(input);
            }
            String teachStr = teachSb.toString();
            teachChar = teachStr.toCharArray();
            len = teachStr.length();
            peeked = new int[K];
            if (len <= K) {
                System.out.println(N);
            } else {
                combination(0, 0);
                System.out.println(answer);
            }
        } else {
            System.out.println(answer);
        }
    }

    private static void combination(int start, int cnt) {
        if (cnt == K) {
            StringBuilder combedSb = new StringBuilder();
            for (int idx : peeked) {
                combedSb.append(teachChar[idx]);
            }
            String combedStr = combedSb.toString();
            int count = 0;
            boolean check;
            for (String word : words) {
                check = true;
                for (int i = 0; i < word.length(); i++) {
                    if (!combedStr.contains(word.substring(i, i + 1))) {
                        check = false;
                        break;
                    }
                }
                if (check) count++;
            }
            answer = Math.max(answer, count);
            return;
        }

        for (int i = start; i < len; i++) {
            peeked[cnt] = i;
            combination(i + 1, cnt + 1);
        }
    }
}
