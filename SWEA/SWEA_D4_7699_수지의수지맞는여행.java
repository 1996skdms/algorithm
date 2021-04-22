package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_7699_수지의수지맞는여행 {

	static int R, C, ans;
	static char[][] map;
	static boolean[] alphabet;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new char[R][C];
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
			}

			alphabet = new boolean[26];
			alphabet[map[0][0] - 'A'] = true;
			ans = 1;
			dfs(0, 0, 1);

			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void dfs(int r, int c, int cnt) {
//		if (ans == 26) return;
		if (ans < cnt) ans = cnt;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nr >= R || nc < 0 || nc >= C || alphabet[map[nr][nc] - 'A']) continue;
			alphabet[map[nr][nc] - 'A'] = true;
			dfs(nr, nc, cnt + 1);
			alphabet[map[nr][nc] - 'A'] = false;
		}
	}

}
