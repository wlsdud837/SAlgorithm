package SAlgorithm.이민준.july_4th;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2668_숫자고르기_v1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] list = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(br.readLine().trim());
        }

        boolean loop = true;
        boolean hit = true;

        while (loop) {
            loop = false;
            for (int i = 1; i <= N; i++) {
                hit = false;
                if (list[i] != 0) {
                    for (int j = 1; j <= N; j++) {
                        if (list[j] == i) {
                            hit = true;
                        }
                    }
                    if (!hit) {
                        list[i] = 0;
                        loop = true;
                    }
                }
            }
        }

        int size = 0;
        for (int i = 1; i <= N; i++) {
            if (list[i] != 0) {
                size++;
            }
        }

        System.out.println(size);
        for (int i = 1; i <= N; i++) {
            if (list[i] != 0) {
                System.out.println(i);
            }
        }
    }
}
