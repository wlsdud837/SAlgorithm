package SAlgorithm.이민준.may_2nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    Case.1
    3
    1 1 1 1 1
    Case.2
    4
    4 1 2 1
 */
public class 프로그래머스_타겟넘버 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(tokens.nextToken());
        tokens = new StringTokenizer(br.readLine());
        int N = tokens.countTokens();
        int numbers[] = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(tokens.nextToken());
        }

        System.out.println(solution(numbers, target));
    }

    static int answer;

    private static int solution(int[] numbers, int target) {
        answer = 0;
        int N = numbers.length;
        int sum = Arrays.stream(numbers).sum();
        dfs(numbers, target, 0, N, sum);

        return answer;
    }

    private static void dfs(int[] numbers, int target, int curr, int N, int sum) {
        if (sum == target) {
            answer++;
            return;
        }

        for (int i = curr; i < N; i++) {
            if (sum - numbers[i] * 2 >= target) {
                dfs(numbers, target, i + 1, N, sum - numbers[i] * 2);
            }
        }

        return;
    }
}

