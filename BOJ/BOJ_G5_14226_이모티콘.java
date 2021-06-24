package algo;

import java.io.*;
import java.util.*;

public class BOJ_G5_14226_이모티콘 {

	private static int S;
	private static boolean[][] visited;

	private static class emoticon {
		int display, clipboard, time;

		public emoticon(int display, int clipboard, int time) {
			super();
			this.display = display;
			this.clipboard = clipboard;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		visited = new boolean[9000][9000]; // [8000][8000]은 ArrayIndexOutOfBounds

		bfs();
	}

	private static void bfs() {
		Queue<emoticon> queue = new LinkedList<>();
		queue.offer(new emoticon(1, 0, 0));

		while (!queue.isEmpty()) {
			emoticon cur = queue.poll();

			if (cur.display == S) {
				System.out.println(cur.time);
				return;
			}

			int ctrlC = cur.display;
			if (!visited[ctrlC][ctrlC]) {
				queue.offer(new emoticon(ctrlC, ctrlC, cur.time + 1));
				visited[ctrlC][ctrlC] = true;
			}

			int ctrlV = cur.display + cur.clipboard;
			if (!visited[ctrlV][cur.clipboard] && ctrlV < 9000) {
				queue.offer(new emoticon(ctrlV, cur.clipboard, cur.time + 1));
				visited[ctrlV][cur.display] = true;
			}

			int delete = cur.display - 1;
			if (delete >= 0 && !visited[delete][cur.clipboard]) {
				queue.offer(new emoticon(delete, cur.clipboard, cur.time + 1));
				visited[delete][cur.clipboard] = true;
			}
		}
	}

}
