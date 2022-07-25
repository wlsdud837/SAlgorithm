package SAlgorithm.이민준.july_4th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 첫 줄과 둘째 줄이 완벽한 쌍이 되게 하기 위해
 * 둘째 줄에는 없는 첫 줄의 요소들을 지워간다.
 * 첫 줄의 요소를 지울 때 이에 매칭되는 둘째 줄의 요소는 당연히 함께 지워짐.
 * 더 지워질 수 없을 때까지 이 작업을 반복한다.
 */
public class BOJ_2668_숫자고르기_v3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Map<Integer, Integer> numbMap = new HashMap<>();
        List<Integer> delList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            numbMap.put(i, Integer.parseInt(br.readLine().trim()));
        }

        boolean hit = true;

        while (hit) {
            hit = false;
            delList.clear();
            for (int key : numbMap.keySet()) {
                if (!numbMap.values().contains(key)) {
                    delList.add(key);
                    hit = true;
                }
            }
            for (int del : delList) {
                numbMap.remove(del);
            }
        }

        System.out.println(numbMap.size());
        for (int answer : numbMap.keySet()) {
            System.out.println(answer);
        }
    }
}
