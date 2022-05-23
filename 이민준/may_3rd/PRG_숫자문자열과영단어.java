package SAlgorithm.이민준.may_3rd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * section.1 : HashMap 에 영문 - 숫자 setting
 * section.2 : String s 를 하나씩 탐색
 * section.3 : 숫자면 답안에 추가. 영문으로 시작되면 하나씩 추가하여 HashMap 의
 *             key 값을 완성하여 숫자로 치환하여 답안에 추가.
 */
public class PRG_숫자문자열과영단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int answer = solution(s);
        System.out.println(answer);
    }

    public static int solution(String s) {
        int answer = 0;
        int strLen = s.length();
        char[] strArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Map<String, Character> numbMap = new HashMap<>();

        // map 에 영문 - 숫자 setting
        numbMap.put("zero", '0');
        numbMap.put("one", '1');
        numbMap.put("two", '2');
        numbMap.put("three", '3');
        numbMap.put("four", '4');
        numbMap.put("five", '5');
        numbMap.put("six", '6');
        numbMap.put("seven", '7');
        numbMap.put("eight", '8');
        numbMap.put("nine", '9');

        for (int i = 0; i < strLen; i++) {
            // 숫자가 아니면 StringBuffer 에 하나씩 append
            if (strArr[i] >= 'a') {
                sb.append(strArr[i]);
                // map 에 해당하는 String 이 있으면 꺼내서 answer 에 추가하고 clear
                if (numbMap.containsKey(sb.toString())) {
                    answer = answer * 10 + (numbMap.get(sb.toString()) - '0');
                    sb.setLength(0);
                }
            } else {
                // 숫자면 바로 answer 에 추가
                answer = answer * 10 + (strArr[i] - '0');
            }
        }
        return answer;
    }
}