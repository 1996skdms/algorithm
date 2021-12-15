/**
* 메모리: 309512 KB, 시간: 1532 ms
* 풀이 시간: 00:00:00
* 2021.12.15
* by Alub
*/
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		List<int[]>[] list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			list[p].add(new int[] { q, r });
			list[q].add(new int[] { p, r });
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			Queue<Integer> queue = new LinkedList<Integer>();
			boolean[] visited = new boolean[N+1];

			queue.offer(v);
			visited[v] = true;

			int cnt = 0;
			while (!queue.isEmpty()) {
				int cur = queue.poll();

				for (int[] idx : list[cur]) {
					if (!visited[idx[0]] && idx[1] >= k) {
						queue.offer(idx[0]);
						visited[idx[0]] = true;
						cnt++;
					}
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
	}
}
