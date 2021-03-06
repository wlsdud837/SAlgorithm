import java.util.*;
/*
* 1. replace 로 풀기
* 2.  0 ~ 9 또는 3글자 확인하여 숫자 이어 붙이기
*/
class Solution {
    public int solution(String s) {
        int a = 0;
        String str = s + "***";
        HashMap<String, Integer> m = new HashMap();
        HashMap<String, Integer> mm= new HashMap();
        
	    m.put("zer",0);mm.put("zer",4);
	    m.put("one",1);mm.put("one",3);
	    m.put("two",2);mm.put("two",3);
	    m.put("thr",3);mm.put("thr",5);
	    m.put("fou",4);mm.put("fou",4);
	    m.put("fiv",5);mm.put("fiv",4);
	    m.put("six",6);mm.put("six",3);
	    m.put("sev",7);mm.put("sev",5);
	    m.put("eig",8);mm.put("eig",5);
	    m.put("nin",9);mm.put("nin",4);
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '*')break;
            if(c >= '0' && c <= '9'){
                a = a * 10 + c - '0';
                continue;
            }
            String temp = str.substring(i, i+3);
            int num = m.get(temp);
            a = a * 10 + num;
            i = i + mm.get(temp) - 1;
        }
        return a;
    }
}



import java.util.*;

class Solution {
    public int solution(String s) {
        int a = 0;
        String str1 = s;
        str1 = str1.replaceAll("zero", "0").replaceAll("one", "1").replaceAll("two", "2").replaceAll("three", "3").replaceAll("four", "4").replaceAll("five", "5").replaceAll("six", "6").replaceAll("seven", "7").replaceAll("eight", "8").replaceAll("nine", "9");
        return Integer.parseInt(str1);
    }
}