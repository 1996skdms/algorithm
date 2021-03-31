// 치즈

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_2636_김나은 {

	static int N, M, time, cheese, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		time = 0;
		cheese = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheese++;
			}
		}

		while (cheese > 0) {
			findEdge();
			melt();
			time++;
			cheese -= cnt;
		}

		System.out.println(time);
		System.out.println(cnt);
		
	}

	private static void melt() {
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j]) {
					if(map[i][j] == 1) cnt++;
					map[i][j] = 0;
				}
			}
		}
	}

	private static void findEdge() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { 0, 0 });

		visited = new boolean[N][M];
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			if (map[r][c] == 1) continue; // 치즈가 아닌 외부 공기를 기준으로 bfs

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.offer(new int[] { nr, nc });
				}
			}
		}
	}

}
