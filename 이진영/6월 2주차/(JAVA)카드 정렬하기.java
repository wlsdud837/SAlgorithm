package B1715카드정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int ans = 0;
		st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i<size; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(Integer.parseInt(st.nextToken())); 
		}
		

		while(pq.size() > 1) {
			int one =pq.poll();
			int two =pq.poll();
			int num = one + two;
			ans+= num;
			pq.add(num);
		}
		System.out.println(ans);
	}
}
