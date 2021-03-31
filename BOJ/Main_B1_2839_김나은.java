// 설탕 배달

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1_2839_김나은 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] memo = new int[N+1];

		memo[0] = 0;
		for (int i = 1; i <= N; i++) {
			int min = 5000; // Integer.MAX_VALUE 값으로 하면  +1 하는 과정에서 음수로 바뀜
			if (i>=3 && memo[i-3] + 1 < min) min = memo[i-3] + 1;
			if (i>=5 && memo[i-5] + 1 < min) min = memo[i-5] + 1;
			memo[i] = min;
		}
		if (memo[N] == 5000)
			System.out.println(-1);
		else
			System.out.println(memo[N]);
	}
}
