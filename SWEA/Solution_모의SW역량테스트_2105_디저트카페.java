package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_모의SW역량테스트_2105_디저트카페 {

	static int N, ans, startR, startC;
	static int[][] map;
	static int[] dr = { 1, 1, -1, -1 }; // 우하, 좌하, 좌상, 우상
	static int[] dc = { 1, -1, -1, 1 };
	static boolean[] desert;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			desert = new boolean[101]; // 디저트 종류는 1 이상 100 이하의 정수

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = -1;
			for (int i = 0; i < N-1; i++) { // 가장 
				for (int j = 1; j < N-1; j++) { // 가장 왼쪽과 오른쪽은 제외
					startR = i;
					startC = j;
					desert[map[i][j]] = true;
					dfs(i, j, 1, 0);
					desert[map[i][j]] = false;
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void dfs(int r, int c, int cnt, int d) {

		int nr = r + dr[d];
		int nc = c + dc[d];

		if (nr == startR && nc == startC && d == 3) {
			ans = Math.max(ans, cnt);
			return;
		}

		if (0 <= nr && nr < N && 0 <= nc && nc < N && !desert[map[nr][nc]]) {
			desert[map[nr][nc]] = true;
			dfs(nr, nc, cnt + 1, d);
			if (d != 3) dfs(nr, nc, cnt + 1, d + 1);
			desert[map[nr][nc]] = false;
		}
	}
	
}
