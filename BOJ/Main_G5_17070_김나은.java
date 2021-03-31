// 파이프 옮기기 1

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_17070_김나은 {

	static class Pos {
		int r, c, dir;

		public Pos(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}

	static int[][] move = { { 0, 1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		ArrayList<Pos> queue = new ArrayList();
		queue.add(new Pos(0, 1, 0));
		while (!queue.isEmpty()) {
			Pos cur = queue.remove(queue.size()-1);
			int r = cur.r;
			int c = cur.c;
			int dir = cur.dir;

			if (r == N-1 && c == N-1) cnt++;
			else {
				int nr = 0, nc = 0;
				switch (dir) {
				case 0: // 가로
					nr = r;
					nc = c+1;
					if(nr < N && nc < N && map[nr][nc] != 1)
						queue.add(new Pos(nr, nc, 0));
					break;
				case 1: // 세로
					nr = r+1;
					nc = c;
					if(nr < N && nc < N && map[nr][nc] != 1)
						queue.add(new Pos(nr, nc, 1));
					break;
				case 2: // 대각선
					nr = r;
					nc = c+1;
					if(nr < N && nc < N && map[nr][nc] != 1)
						queue.add(new Pos(nr, nc, 0));
					nr = r+1;
					nc = c;
					if(nr < N && nc < N && map[nr][nc] != 1)
						queue.add(new Pos(nr, nc, 1));
					break;
				}
				nr = r+1;
				nc = c+1;
				if(nr < N && nc < N && map[nr][nc] != 1 && map[r][nc] != 1 && map[nr][c] != 1)
					queue.add(new Pos(nr, nc, 2));
			}
		}

		System.out.println(cnt);

	}
}
