package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G1_1194_달이차오른다가자 {

	static class Pos {
		int r, c, key, dist;

		public Pos(int r, int c, int key, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.key = key;
			this.dist = dist;
		}
	}

	static int N, M, ans;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][1 << 6];

		Pos start = null;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '0') {
					start = new Pos(i, j, 0, 0);
					map[i][j] = '.';
				}
			}
		}

		ans = -1;
		bfs(start);
		System.out.println(ans);
	}

	private static void bfs(Pos start) {

		Queue<Pos> queue = new LinkedList<Pos>();
		queue.offer(start);
		visited[start.r][start.c][start.key] = true;

		while (!queue.isEmpty()) {
			Pos cur = queue.poll();

			if (map[cur.r][cur.c] == '1') {
				ans = cur.dist;
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '#' || visited[nr][nc][cur.key]) continue;

				if (map[nr][nc] == '.' || map[nr][nc] == '1') {
					visited[nr][nc][cur.key] = true;
					queue.offer(new Pos(nr, nc, cur.key, cur.dist + 1));
				}

				if ('a' <= map[nr][nc] && map[nr][nc] <= 'f') { // 열쇠
					char key = map[nr][nc];
					key -= 'a';
					int updateKey = cur.key | (1 << key);
					visited[nr][nc][updateKey] = true;
					queue.offer(new Pos(nr, nc, updateKey, cur.dist + 1));
				}
				
				if ('A' <= map[nr][nc] && map[nr][nc] <= 'F') { // 문
					char door = map[nr][nc];
					door -= 'A';
					if ((cur.key & (1 << door)) == 0) continue;
					visited[nr][nc][cur.key] = true;
					queue.offer(new Pos(nr, nc, cur.key, cur.dist + 1));
				}

			}
		}
	}

}
