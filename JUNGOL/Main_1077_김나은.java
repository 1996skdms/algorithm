package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1077_김나은 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		int[][] results = new int[N+1][W+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}

		int cw = 0, value = 0;
		for (int item = 1; item <= N; item++) {
			cw = weights[item];
			value = profits[item];

			for (int w = 1; w <= W; w++) {
				if (cw <= w) {
					results[item][w] = Math.max(results[item-1][w], results[item][w-cw] + value);
				} else {
					results[item][w] = results[item-1][w];
				}
			}
		}
		System.out.println(results[N][W]);

	}

}
