package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_2846_오르막길 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[] height = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0, start = height[0], cur = 0, prev = 0, temp=0;
		for (int i = 1; i < N; i++) {
			prev = height[i-1];
			cur = height[i];
			if(prev < cur) continue;
			else {
				temp = prev-start;
				ans = Math.max(ans, temp);
				start = cur;
			}
		}
		
		// 맨 마지막도 포함
		ans = Math.max(ans, cur-start);

		System.out.println(ans);
	}

}
