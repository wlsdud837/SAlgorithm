package B2668숫자고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static boolean [] ch;
	static ArrayList<Integer> answer;
	static ArrayList<Integer> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		answer = new ArrayList<>();
		arr = new ArrayList<>();
		
		for(int i = 0 ; i < size; i++) {
			int num = Integer.parseInt(br.readLine());
			arr.add(num);
		}
		
		ch = new boolean[arr.size() + 1];
		for(int i = 0 ; i < arr.size(); i++) {
			ch[i + 1] = true;
			dfs(i + 1 , i + 1);
			ch[i + 1] = false;
		}
		int [] ans = answer.stream().mapToInt(num -> num).toArray();
		Arrays.sort(ans);
		StringBuilder sb = new StringBuilder();
		sb.append(ans.length).append("\n");
		
		for(int x: ans) {
			sb.append(x).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void dfs(int start, int next) {

		if(!ch[arr.get(next - 1)]) {
			ch[arr.get(next - 1)] = true;
			dfs(start, arr.get(next - 1));
			ch[arr.get(next - 1)] = false;
		}
		if(start == arr.get(next - 1)) {
			answer.add(start);
			//System.out.println(start);
		}
	}
}
