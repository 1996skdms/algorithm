package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Professional_5604_구간합 {

	static long ans;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());

			ans = 0;
			long mul = 1;
			while (A <= B) {
				while (A % 10 != 0 && A <= B) {
					check(A, mul);
					A++;
				}
				if (A > B || (A == 0 && B == 0)) break;
				while (B % 10 != 9 && A <= B) {
					check(B, mul);
					B--;
				}
				A /= 10;
				B /= 10;
				long m = (B - A + 1) * mul;
				for (int i = 0; i < 10; i++)
					ans += m * i;
				mul *= 10;
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	static void check(long n, long mul) {
		while (n > 0) {
			ans += (n % 10) * mul;
			n /= 10;
		}
	}

}
