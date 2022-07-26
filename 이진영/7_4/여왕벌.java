package B10836여왕벌;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int size = Integer.parseInt(st.nextToken());
		int input = Integer.parseInt(st.nextToken());
		int []line = new int [size * 2 - 1];
		int [][]temp = new int[size][size];
		int good = 0;
		
		for(int ii = 0; ii < input; ii++) {
			st = new StringTokenizer(br.readLine(), " ");
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			int num = zero + one;
			int num2 = zero + one + two;
			for(int j = zero ; j < num; j++) line[j]++;
			for(int j = num ; j < num2; j++) line[j] += 2;
		}
		
		
		
		for(int i = size - 1; i >= 0; i--) temp[i][0] += line[good++];
		
		for(int i = 1; i < size; i++) temp[0][i] += line[good++];
		
		for(int i = 1; i < size; i++) 
			for(int j = 1; j < size; j++) 
				temp[i][j] = Math.max(temp[i - 1][j - 1], Math.max(temp[i - 1][j], temp[i][j - 1]));

		StringBuilder sb = new StringBuilder();
		for(int [] xx : temp) {
			
			for(int x : xx) sb.append(x + 1).append(" ");
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
