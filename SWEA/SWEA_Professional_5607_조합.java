package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Professional_5607_조합 {

	static int N, R, mod = 1234567891;
	static long[] fac;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		fac = new long[1000001];
		fac[0] = 1;
		for (int i = 1; i <= 1000000; i++) {
			fac[i] = i * fac[i - 1] % mod;
		}

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());

			System.out.println("#" + tc + " " + fermat() % mod);
		}
	}

	private static long fermat() {
		return (fac[N] * exp((fac[R] * fac[N-R]) % mod, mod-2));
	}

	private static long exp(long x, int y) {

		if (y == 1) return x;

		long half = exp(x, y / 2);
		long result = (half * half) % mod;

		if (y % 2 == 1) result *= x;

		return result % mod;
	}

}
