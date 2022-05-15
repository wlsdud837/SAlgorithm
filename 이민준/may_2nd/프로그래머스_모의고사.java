package SAlgorithm.이민준.may_2nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
    Case.1
    1 2 3 4 5
    Case.2
    1 3 2 4 2
 */
public class 프로그래머스_모의고사 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int N = tokens.countTokens();
        int answers[] = new int[N];
        for (int i = 0; i < N; i++) {
            answers[i] = Integer.parseInt(tokens.nextToken());
        }

        System.out.println(Arrays.toString(solution(answers)));
    }

    private static int[] solution(int[] answers) {
        final int size[] = {5, 8, 10};
        final int check[][] = {{1, 2, 3, 4, 5, 0, 0, 0, 0, 0}
                             , {2, 1, 2, 3, 2, 4, 2, 5, 0, 0}
                             , {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int idx[] = new int[3];
        int store[] = new int[3];
        int ansLen = answers.length;
        int max = 0;

        for (int i = 0; i < ansLen; i++) {
            for (int j = 0; j < 3; j++) {
                idx[j] %= size[j];
                if (answers[i] == check[j][idx[j]]) {
                    store[j]++;
                    max = Math.max(store[j], max);
                }
                idx[j]++;
            }
        }

        return sortAns(store, max);
    }

    private static int[] sortAns(int[] store, int max) {
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (store[i] == max){
                ansList.add(i);
            }
        }

        int size = ansList.size();
        int rtnArr[] = new int[size];
        for (int i = 0; i < size; i++) {
            rtnArr[i] = ansList.get(i) + 1;
        }

        return rtnArr;
    }
}

