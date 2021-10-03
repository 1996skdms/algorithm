package boj;

import java.io.*;
import java.util.*;

public class BOJ_G4_16236 {

	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, fish, ans;
	static Shark shark;

	public static class Shark {
		int r, c, size;

		public Shark(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Shark(i, j, 2);
					map[i][j] = 0;
				}
			}
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(calcDist(o1[0], o1[1], shark.r, shark.c) < calcDist(o2[0], o2[1], shark.r, shark.c)) return -1; 
				else if(calcDist(o1[0], o1[1], shark.r, shark.c) == calcDist(o2[0], o2[1], shark.r, shark.c)) {
					if(o1[0] < o2[0]) return -1;
					else if(o1[0] == o2[0]) {
						if(o1[1] < o2[1]) return -1;
						else return 1;
					}
					return 1;
				}
				return 1;
			}
		});

		while (true) {
			findFish(pq);
			
			if (pq.isEmpty()) break;

			move(pq);
		}

		System.out.println(ans);
	}

	private static int calcDist(int r1, int c1, int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][N];

		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		
		int dist = 0;
		boolean target = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				
				int[] cur = queue.poll();
				if(r1 == cur[0] && c1 == cur[1]) {
					target = true;
					break;
				}
				
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] > shark.size) continue;
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}	
			}
			
			if(target) break;
			dist++;
		}
		
		if(!target) dist = 0;
		return dist;
	}

	private static void move(PriorityQueue<int[]> pq) {
		int[] target = pq.poll();		
		
		ans += calcDist(target[0], target[1], shark.r, shark.c);		
		fish++;
		if (shark.size == fish) {
			shark = new Shark(target[0], target[1], shark.size + 1);
			fish = 0;
		} else {
			shark = new Shark(target[0], target[1], shark.size);
		}
		
		map[target[0]][target[1]] = 0;
	}

	private static void findFish(PriorityQueue<int[]> pq) {
		pq.clear();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0 && map[i][j] < shark.size && calcDist(i, j, shark.r, shark.c) > 0) pq.add(new int[] {i,j});
			}
		}
	}
	
}
