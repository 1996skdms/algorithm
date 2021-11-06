package boj;

import java.io.*;
import java.util.*;

public class BOJ_G5_1990 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		boolean[] num = new boolean[b + 1];

		// 에라토스테네스의 체
		for (int i = 2; i <= b; i++) {
			if (num[i]) continue;

			for (int j = i * 2; j <= b; j += i)
				num[j] = true;
		}

		// 팰린드롬
		StringBuilder sb = new StringBuilder();
		for (int i = a; i <= b; i++) {
			if (!num[i]) {
				String number = Integer.toString(i);
				int len = number.length();
				int left = 0, right = len-1;
				while(left<=right) {
					if (number.charAt(left) != number.charAt(right)) break;
					left++; right--;
				}
				if (left >= right) sb.append(i).append("\n"); 
			}
		}
		sb.append(-1);
		System.out.println(sb);

	}
}
