// 해밀턴 순환회로

package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL1681 {

	static int N, ans = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0] = true; // 출발지(회사)
		dfs(0, 0, 0);

		System.out.println(ans);
	}

	private static void dfs(int cnt, int cur, int sum) {
		if (sum > ans) return;

		if (cnt == N - 1) {
			if (map[cur][0] == 0) return;

			sum += map[cur][0];
			ans = Math.min(ans, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i] && map[cur][i] != 0) {
				visited[i] = true;
				dfs(cnt + 1, i, sum + map[cur][i]);
				visited[i] = false;
			}
		}
	}

}
