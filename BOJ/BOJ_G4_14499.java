package boj;

import java.io.*;
import java.util.*;

public class BOJ_G4_14499 {

	static int N, M, x, y;
	static int[][] map;
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };
	static int[] dice;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dice = new int[7];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			move(dir);
		}
		
	}

	private static void move(int dir) {
		int nr = x + dr[dir];
		int nc = y + dc[dir];
		if (nr < 0 || nr >= N || nc < 0 || nc >= M) return;

		if (dir == 1) { // 동쪽
			dice[0] = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = dice[0];
		} else if (dir == 2) { // 서쪽
			dice[0] = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = dice[0];
		} else if (dir == 3) { // 북쪽
			dice[0] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = dice[0];
		} else { // 남쪽
			dice[0] = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = dice[0];
		}

		x = nr;
		y = nc;
		if (map[x][y] == 0)
			map[x][y] = dice[6]; // 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 복사된다.
		else {
			dice[6] = map[x][y]; // 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며
			map[x][y] = 0; // 칸에 쓰여 있는 수는 0이 된다
		}

		System.out.println(dice[1]);
	}
}
