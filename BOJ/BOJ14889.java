// 스타트와 링크

package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {

	static int N, ans = Integer.MAX_VALUE;
	static int[][] S;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = new int[N][N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combination(0, 0);
		System.out.println(ans);

	}

	private static void combination(int cnt, int start) {
		if (cnt == N / 2) {
			int[] starts = new int[N / 2];
			int[] links = new int[N / 2];

			int idx = 0, index = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i])
					starts[idx++] = i;
				else
					links[index++] = i;
			}
			diff(starts, links);
			return;
		}

		for (int i = start; i < N; i++) {
			isSelected[i] = true;
			combination(cnt + 1, i + 1);
			isSelected[i] = false;
		}
	}

	private static void diff(int[] starts, int[] links) {
		int sumStarts = 0, sumLinks = 0;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				sumStarts += S[starts[i]][starts[j]];
				sumLinks += S[links[i]][links[j]];
			}
		}
		ans = Math.min(ans, Math.abs(sumStarts - sumLinks));
	}

}
