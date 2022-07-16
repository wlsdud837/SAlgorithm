package B2225합분해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int sum = Integer.parseInt(st.nextToken());

		int cnt = Integer.parseInt(st.nextToken());
		int max = Math.max(sum, cnt);
		int [][]dp = new int[max + 1][max + 1];
		for(int i = 1; i <=max; i++)dp[0][i] = 1;
		
		for(int i = 1; i <= sum; i++) {
			for(int j = 1; j <= cnt; j++) {
				dp[i][j] = (dp[i][j - 1] + dp[i - 1][j])  % 1000000000;
			}
		}
		System.out.println(dp[sum][cnt]);
	}
}
