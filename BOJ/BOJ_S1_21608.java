package boj;

import java.io.*;
import java.util.*;

public class BOJ_S1_21608 {

	static int N, ans;
	static int[][] map, pos;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<Student> list;

	public static class Student {
		int me, f1, f2, f3, f4;

		public Student(int me, int f1, int f2, int f3, int f4) {
			this.me = me;
			this.f1 = f1;
			this.f2 = f2;
			this.f3 = f3;
			this.f4 = f4;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		pos = new int[N*N+1][2];

		list = new ArrayList<>();
		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			int me = Integer.parseInt(st.nextToken());
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			int f3 = Integer.parseInt(st.nextToken());
			int f4 = Integer.parseInt(st.nextToken());
			list.add(new Student(me, f1, f2, f3, f4));

//			if (i == 0) { // 첫번째 사람은 무조건 정중앙 자리
//				map[N / 2][N / 2] = me;
//				pos[me][0] = N/2;
//				pos[me][1] = N/2;
//				continue;
//			}
			position(list.get(i));
		}

		for (int i = 0; i < N * N; i++) {
			satisfy(list.get(i), list.get(i).me);
		}

		System.out.println(ans);
	}

	private static void satisfy(Student student, int me) {
		int cnt = 0, r = pos[me][0], c = pos[me][1];

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if (map[nr][nc] == student.f1 || map[nr][nc] == student.f2 || map[nr][nc] == student.f3 || map[nr][nc] == student.f4) cnt++;
		}

		if (cnt == 1) ans += 1;
		else if (cnt == 2) ans += 10;
		else if (cnt == 3) ans += 100;
		else if (cnt == 4) ans += 1000;
	}

	private static void position(Student student) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (condition1(student, o1) > condition1(student, o2)) return -1;
				else if (condition1(student, o1) == condition1(student, o2)) {
					if (condition2(o1) > condition2(o2)) return -1;
					else if (condition2(o1) == condition2(o2)) {
						if (o1[0] < o2[0]) return -1;
						else if (o1[0] == o2[0]) {
							if (o1[1] < o2[1]) return -1;
							else return 1;
						}
					}
					return 1;
				}
				return 1;
			}

			private int condition2(int[] o1) {
				int r = o1[0], c = o1[1], cnt = 0;

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					if (map[nr][nc] == 0) cnt++;
				}

				return cnt;
			}

			private int condition1(Student student, int[] o1) {
				int r = o1[0], c = o1[1], cnt = 0;

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					if (map[nr][nc] == student.f1 || map[nr][nc] == student.f2 || map[nr][nc] == student.f3 || map[nr][nc] == student.f4) cnt++;
				}

				return cnt;
			}
		});

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 0) pq.add(new int[] { r, c });
			}
		}

		map[pq.peek()[0]][pq.peek()[1]] = student.me;
		pos[student.me][0] = pq.peek()[0];
		pos[student.me][1] = pq.peek()[1];
	}

}
