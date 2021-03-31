// 파이프 옮기기 2

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_17069_김나은 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		long[][][] dp = new long[N+1][N+1][3]; // 0:가로, 1:세로, 2:대각선

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[1][2][0] = 1;
		for (int r = 1; r <= N; r++) {
			for (int c = 3; c <= N; c++) {
				if (map[r][c] == 1) continue;
				dp[r][c][0] = dp[r][c-1][0] + dp[r][c-1][2];
				dp[r][c][1] = dp[r-1][c][1] + dp[r-1][c][2];
				if(map[r][c-1] == 0 && map[r-1][c] == 0)
					dp[r][c][2] = dp[r-1][c-1][0] + dp[r-1][c-1][1] + dp[r-1][c-1][2];
			}
		}

		System.out.println(dp[N][N][0]+dp[N][N][1]+dp[N][N][2]);

	}
}
