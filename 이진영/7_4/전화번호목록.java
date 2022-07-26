package B5052전화번호목록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tot = Integer.parseInt(br.readLine());
		
		for(int t = 0 ; t < tot; t++) {
			 int word = Integer.parseInt(br.readLine());
			 String[] arr = new String[word];
			 boolean flag = true;
			 
			 for(int k = 0 ; k < word; k++) arr[k] = br.readLine();
			 
			 Arrays.sort(arr);
			 
			 String init = arr[0];
			 for(int k = 1; k < word; k++) {
				 String next = arr[k];
				 if(init.length() < next.length()) {
					 if(init.equals(next.substring(0, init.length()))) {
						 System.out.println("NO");
						 flag = false;
						 break;
					 }
				 }
				 init = next;
			 }
			 if(flag)System.out.println("YES");
		}
	}
}
