package boj;

import java.io.*;

public class BOJ_S3_17212 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] money = new int[N+1];

		for (int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			if (money[i-1] + 1 < min) min = money[i-1] + 1;
			if (i>=2 && money[i-2] + 1 < min) min = money[i-2] + 1;
			if (i>=5 && money[i-5] + 1 < min) min = money[i-5] + 1;
			if (i>=7 && money[i-7] + 1 < min) min = money[i-7] + 1;
			money[i] = min;
		}

		System.out.println(money[N]);
	}

}
