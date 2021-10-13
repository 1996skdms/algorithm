package boj;

import java.io.*;
import java.util.*;

public class BOJ_S1_14888 {

	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] number;
	static int[] op;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		op = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		solve(0, number[0]);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void solve(int depth, int res) {
		if (depth == N-1) {
			max = Integer.max(max, res);
			min = Integer.min(min, res);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (op[i] == 0) continue;
			op[i]--;
			solve(depth+1, calc(i, depth+1, res));
			op[i]++;
		}

	}

	private static int calc(int op, int depth, int res) {
		if (op == 0) res += number[depth];
		else if (op == 1) res -= number[depth];
		else if (op == 2) res *= number[depth];
		else res /= number[depth];
		return res;
	}
}
