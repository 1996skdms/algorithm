package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_D4_1868_파핑파핑지뢰찾기 {

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int N, ans;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상, 하, 좌, 우, 좌상, 우상, 좌하, 우하
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.' && findZero(i, j)) {
						bfs(new Pos(i, j));
						ans++;
					}
				}
			}

			count();

			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void count() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '.')
					ans++;
			}
		}
	}

	private static void bfs(Pos start) {
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.offer(start);
		map[start.r][start.c] = '0';

		while (!queue.isEmpty()) {
			Pos cur = queue.poll();

			for (int d = 0; d < 8; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if (0 <= nr && nr < N && 0 <= nc && nc < N && map[nr][nc] == '.') {
					if (findZero(nr, nc))
						queue.offer(new Pos(nr, nc));
					map[nr][nc] = mark(nr, nc);
				}
			}
		}
	}

	private static char mark(int r, int c) {
		int cnt = 0;
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (0 <= nr && nr < N && 0 <= nc && nc < N) {
				if (map[nr][nc] == '*')
					cnt++;
			}
		}
		return (char) (cnt + '0');
	}

	private static boolean findZero(int r, int c) {

		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (0 <= nr && nr < N && 0 <= nc && nc < N && map[nr][nc] == '*')
				return false;
		}
		return true;
	}

}

// 0인 곳을 찾아서 bfs 돌린 후 map 전체 검색해서 .인 곳 count