package SAlgorithm.이민준.july_4th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_5052_전화번호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int testcase = 0; testcase < T; testcase++) {
            System.out.println(isPossible(br));
        }
    }

    private static String isPossible(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(br.readLine().trim());
        }
        Collections.sort(numbers);
        for (int i = 0; i < n - 1; i++) {
            if (numbers.get(i + 1).startsWith(numbers.get(i))){
                return "NO";
            }
        }
        return "YES";
    }
}
