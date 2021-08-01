package programmers;

import java.util.*;

public class 거리두기_확인하기 {

	public static void main(String[] args) {

		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };

		for (int i = 0; i < places.length; i++) {
			System.out.print(solution(places)[i]);
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static int[] solution(String[][] places) {
		int[] answer = new int[5];

		char[][] map = new char[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[j] = places[i][j].toCharArray();
			}
			answer[i] = check(map);
		}

		return answer;
	}

	private static int check(char[][] map) {
		boolean flag = false;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == 'P') {
					if (bfs(map, i, j)) return 0;
				}
			}
		}
		return 1;
	}

	private static boolean bfs(char[][] map, int r, int c) {
		boolean[][] visited = new boolean[5][5];
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { r, c, 0, 0 }); // r, c, depth, partition
		visited[r][c] = true;

		while (!queue.isEmpty()) {

			int[] cur = queue.poll();
			if (map[cur[0]][cur[1]] == 'P' && cur[2] != 0) {
				if (cur[3] == 0) return true;
			}

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || visited[nr][nc] || cur[2] >= 2) continue;

				if (map[nr][nc] == 'X') queue.offer(new int[] { nr, nc, cur[2] + 1, cur[3] + 1 });
				else queue.offer(new int[] { nr, nc, cur[2] + 1, cur[3] });
				visited[nr][nc] = true;
			}
		}

		return false;
	}

}
