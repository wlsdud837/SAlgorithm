package SAlgorithm.이민준.may_3rd;

import java.util.HashMap;
import java.util.Map;

/**
 * section.1 : 각 category 별로 갯수를 센다.
 * section.2 : category 별 갯수를 곱하여 경우의 수를 구한다.
 * section.3 : 아무 것도 선택하지 않는 경우는 제외한다.
 */
public class PRG_위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> categoryMap = new HashMap<>();
        for (String category[] : clothes) {
            categoryMap.put(category[1], categoryMap.getOrDefault(category[1], 0) + 1);
        }
        for (String key : categoryMap.keySet()) {
            answer *= categoryMap.get(key) + 1;
        }
        return answer - 1;
    }
}
