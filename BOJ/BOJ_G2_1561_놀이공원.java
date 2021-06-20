package algo;

import java.io.*;
import java.util.*;

public class BOJ_G2_1561_놀이공원 {

	static int N, M;
	static int[] rides;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		rides = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			rides[i] = Integer.parseInt(st.nextToken());
		}

		long left = 0, right = Long.MAX_VALUE;
		long a = 0, b = 0; // a분, b분(답)
		long num1 = 0, num2 = 0; // a분까지 num1명의 아이들 탑승, b분까지 num2명의 아이들 탑승

		while (left <= right) {
			long mid = (left + right) / 2;
			long res = calc(mid); // 이분탐색

			if (res < N) { // 이분탐색으로 구한 답 < 아이의 수
				left = mid + 1; // 분 증가
				a = mid;
				num1 = res;
			} else {
				right = mid - 1;
				b = mid;
				num2 = res;
			}
		}

		// 이분탐색 종료 => b분에 우리가 찾는 답
		// b분까지 탄 아이는 num1+1번 ~ num2번
		long ans = num1;
		int idx = 0;

		for (int i = 0; i < M; i++) {
			if (ans == N) break;
			if (b % rides[i] == 0) {
				ans++;
				idx = i + 1;
			}
		}

		System.out.println(idx);
	}

	private static long calc(long mid) {
		long sum = M;
		for (int i = 0; i < M; i++) {
			sum += mid / rides[i];
		}
		return sum;
	}

}
