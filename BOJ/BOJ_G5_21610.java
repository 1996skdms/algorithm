package boj;

import java.io.*;
import java.util.*;

public class BOJ_G5_21610 {

	static int[] dr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int N, M;
	static int[][] map;
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		queue = new LinkedList<int[]>();
		queue.offer(new int[] { N - 2, 0 });
		queue.offer(new int[] { N - 2, 1 });
		queue.offer(new int[] { N - 1, 0 });
		queue.offer(new int[] { N - 1, 1 });

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			cloud_move(d, s);
			water_copy();
			make_cloud();
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += map[i][j];
			}
		}
		System.out.println(ans);

	}

	private static void make_cloud() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] < o2[0]) return -1;
				else if(o1[0] == o2[0]){
					if(o1[1] < o2[1]) return -1;
					else return 1;
				}
				else return 1;
			}
		});

		while (!queue.isEmpty()) {
			pq.offer(queue.poll());
		}

		int size = pq.size();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (size > 0 && r == pq.peek()[0] && c == pq.peek()[1]) {
					pq.poll();
					size--;
				} else if (map[r][c] >= 2) {
					map[r][c] -= 2;
					queue.offer(new int[] { r, c });
				}
			}
		}
	}

	private static void water_copy() {
		int size = queue.size();
		while (size > 0) {
			int r = queue.peek()[0];
			int c = queue.peek()[1];
			queue.poll();

			int cnt = 0;
			for (int d = 2; d <= 8; d += 2) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (map[nr][nc] > 0) cnt++;
			}
			map[r][c] += cnt;

			size--;
			queue.offer(new int[] { r, c });
		}
	}

	private static void cloud_move(int d, int s) {
		int size = queue.size();
		while (size > 0) {
			int r = queue.peek()[0];
			int c = queue.peek()[1];
			queue.poll();

			int nr = r + dr[d] * (s % N);
			int nc = c + dc[d] * (s % N);

			if (nr < 0)
				nr += N;
			else if (nr >= N)
				nr -= N;

			if (nc < 0)
				nc += N;
			else if (nc >= N)
				nc -= N;
			map[nr][nc] += 1; // 모든 구름이 이동 후 물의 양 1 증가

			size--;
			queue.offer(new int[] { nr, nc });
		}

	}

}
