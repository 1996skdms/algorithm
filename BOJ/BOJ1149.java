// RGB거리

package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] cost = new int[N+1][3];
		int[][] DP = new int[N+1][3];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		for (int i = 1; i <= N; i++) {
			DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2]) + cost[i][0]; // R
			DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2]) + cost[i][1]; // G
			DP[i][2] = Math.min(DP[i-1][0], DP[i-1][1]) + cost[i][2]; // B
		}
		
		System.out.println(Math.min(Math.min(DP[N][0], DP[N][1]),DP[N][2]));

	}
}
