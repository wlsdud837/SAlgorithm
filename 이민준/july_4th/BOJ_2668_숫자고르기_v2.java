package SAlgorithm.이민준.july_4th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_2668_숫자고르기_v2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int input;
        Map<Integer, Integer> numbCnt = new HashMap<>();
        Map<Integer, Integer> numbMap = new HashMap<>();
        List<Integer> delList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            input = Integer.parseInt(br.readLine().trim());
            numbCnt.put(input, numbCnt.getOrDefault(input, 0) + 1);
            numbMap.put(i, input);
        }

        boolean hit = true;
        int curr;
        int val;

        while (hit) {
            hit = false;
            delList.clear();
            for (int out : numbMap.keySet()) {
                if (!numbCnt.containsKey(out)) {
                    delList.add(out);
                    hit = true;
                }
            }
            for (int out : delList) {
                val = numbMap.get(out);
                if (numbCnt.containsKey(val)) {
                    curr = numbCnt.get(val) - 1;
                    if (curr == 0) {
                        numbCnt.remove(val);
                    } else {
                        numbCnt.put(val, curr);
                    }
                }
                numbMap.remove(out);
            }
        }

        System.out.println(numbMap.size());
        for (int answer : numbMap.keySet()) {
            System.out.println(answer);
        }
    }
}
