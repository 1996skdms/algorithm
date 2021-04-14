// 토마토

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_7576_토마토 {

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int M, N;
	static int[][] map;
	static Queue<Pos> queue;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		queue = new LinkedList<Pos>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0, k = 0; j < M; j++, k += 2) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					queue.offer(new Pos(i, j));
			}
		}

		int ans = bfs();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					ans = -1;
			}
		}

		System.out.println(ans);

	}

	private static int bfs() {
		int time = 0;

		while (!queue.isEmpty()) {
			for (int i = 0, size = queue.size(); i < size; i++) {
				Pos cur = queue.poll();

				for (int d = 0; d < 4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 0) {
						map[nr][nc] = 1;
						queue.offer(new Pos(nr, nc));
					}
				}
			}
			time++;
		}
		return time - 1;
	}

}
