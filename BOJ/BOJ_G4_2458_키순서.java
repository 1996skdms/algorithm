package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_2458_키순서 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 학생들의 수
		int M = Integer.parseInt(st.nextToken()); // 두 학생 키를 비교한 횟수

		int[][] height = new int[N+1][N+1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(height[i], Integer.MAX_VALUE/2);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			height[a][b] = 1; // a인 학생이 b인 학생보다 키가 작음
		}

		for (int k = 1; k <= N; k++) // 경유지
			for (int i = 1; i <= N; i++) // 출발
				for (int j = 1; j <= N; j++) // 도착
					height[i][j] = Math.min(height[i][j], height[i][k] + height[k][j]); // Integer.MAX_VALUE + Integer.MAX_VALUE = -2

		int[] count = new int[N+1];
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				if (height[i][j] != Integer.MAX_VALUE/2) {
					count[i]++;
					count[j]++;
				}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if(count[i] == N-1)
				ans++;
		}
		
		System.out.println(ans);
	}

}
