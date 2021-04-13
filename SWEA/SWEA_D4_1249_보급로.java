// 보급로

package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_D4_1249_보급로 {

	static int N, min;
	static int[][] map, ans;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
			}

			ans = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(ans[i], Integer.MAX_VALUE);
			}

			min = Integer.MAX_VALUE;
			bfs(0, 0);

			System.out.println("#" + tc + " " + min);
		}
	}

	private static void bfs(int row, int col) {

		boolean[][] visited = new boolean[N][N];
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.offer(new Pos(row, col));
		visited[row][col] = true;
		ans[row][col] = 0;

		while (!queue.isEmpty()) {
			Pos cur = queue.poll();

			if (cur.r == N-1 && cur.c == N-1) {
				min = Math.min(min, ans[N-1][N-1]);
			}

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if (0 <= nr && nr < N && 0 <= nc && nc < N) {
					if (!visited[nr][nc] || ans[nr][nc] > ans[cur.r][cur.c] + map[nr][nc]) {
						ans[nr][nc] = ans[cur.r][cur.c] + map[nr][nc];
						queue.offer(new Pos(nr, nc));
						visited[nr][nc] = true;
					}
				}
			}
		}
		
	}
}
