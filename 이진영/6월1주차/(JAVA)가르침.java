package B1062가르침;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
* 1. 알파뱃를 비트마스크에 맞게 세팅
* 2. DFS로 알려줄 알파벳 조합 생성
* 3. 읽을 수 있는 단어 세기
* 4. 최대값을 리턴
*
*/
public class Main {
	static int answer;
	public static void main(String[] args) throws IOException {
			BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			if(cnt <= 4) {
				System.out.println(0);
				return;
			}
			int arr = 0;
			arr = arr |  (1 << ('a' - 'a'));
			arr = arr |  (1 << ('n' - 'a'));
			arr = arr |  (1 << ('t' - 'a'));
			arr = arr |  (1 << ('i' - 'a'));
			arr = arr |  (1 << ('c' - 'a'));
			int []w = new int[size];
			for(int i = 0; i < size; i++) {
				String s  = br.readLine();
				char [] t = s.toCharArray();
				
				for(char ss : t) {
					w[i] = w[i] | (1 << (ss- 'a')); // 한번에 연산하기 위해 비트 세팅
				}
			}
			answer = 0;
			//System.out.println(Integer.toBinaryString(arr)); // 디버깅
			dfs(cnt - 5, 0, arr, w,0);
			System.out.println(answer);
	}
	static void dfs(int cnt, int depth, int arr,int [] w, int num) {
		if(num == cnt) {
			int number = check(arr, w);
			if(answer < number) {
				//System.out.println(Integer.toBinaryString(arr)); // 디버깅
				answer = number;
			}

			return;
		}else if(num < cnt && depth  < 26){   // 이진트리로 조합생성
			if((arr & (1 << depth)) == 0) {
				arr = arr |  (1 << depth);
				dfs(cnt , depth + 1, arr, w, num + 1);
				arr = arr -  (1 << depth);
			}
				dfs(cnt , depth + 1, arr, w, num);
		}
	}
	static int check(int arr , int []w) {
		int res = 0;
		for(int x : w) {
			if((x & arr) == x )res++; //비트마스트로 한번의 연산으로 세기
		}
		return res;
	}

}
