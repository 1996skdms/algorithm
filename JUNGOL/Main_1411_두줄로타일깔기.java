// 두 줄로 타일 깔기

package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1411_두줄로타일깔기 {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		int[] memo = new int[N+1];
		memo[0] = 1;
		memo[1] = 1;

		for (int i = 2; i <= N; i++) {
			memo[i] = (memo[i-1] + 2*memo[i-2]) % 20100529;
		}

		System.out.println(memo[N]);

	}
}
