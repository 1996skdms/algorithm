/**
* 메모리: 14236 KB, 시간: 128 ms
* 풀이 시간: 00:00:00
* 2021.12.15
* by Alub
*/
import java.io.*;
import java.util.*;

public class Main {

	public static char[][] board = new char[6][6];
	public static int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 };// 상, 하, 좌, 우, 좌상, 우하, 우상, 좌하
	public static int[] dc = { 0, 0, -1, 1, -1, 1, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		// 게임판 초기화
		for (int i = 0; i < 6; i++) {
			Arrays.fill(board[i], '.');
		}
		board[2][2] = board[3][3] = 'W';
		board[2][3] = board[3][2] = 'B';

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken()) - 1;
			if (i % 2 == 0) changeStone(R, C, 'B'); // 흑돌이 선을 잡는다
			else changeStone(R, C, 'W');
		}

		int black = 0; int white = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (board[i][j] == 'B') black++;
				else if (board[i][j] == 'W') white++;
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.print(black > white ? "Black" : "White");
	}

	private static void changeStone(int R, int C, char stone) {
		board[R][C] = stone;

		Stack<int[]> stack = new Stack<>();
		for(int d = 0; d < 8; d++) {
			boolean flag = false;
			for (int j = 1; ; j++) {
				int nr = R + dr[d] * j;
				int nc = C + dc[d] * j;
				if (nr < 0 || nr >= 6 || nc < 0 || nc >= 6 || board[nr][nc] == '.') {
					stack.clear();
					break;
				}
				if (board[nr][nc] == stone) {
					flag = true;
					break;
				}
				stack.push(new int[] {nr, nc});
			}
			
			if(flag) {				
				while(!stack.isEmpty())
				{
					int cur[] = stack.pop();
					board[cur[0]][cur[1]] = stone;
				}
			}
		}
	}

}