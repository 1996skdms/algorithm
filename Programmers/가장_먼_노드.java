package programmers;

import java.util.*;

public class 가장_먼_노드 {

	static int depth;

	public static void main(String[] args) {
		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

		System.out.println(solution(n, edge));
	}

	public static int solution(int n, int[][] edge) {
		int answer = 0;

		boolean[][] adjMatrix = new boolean[n+1][n+1];
		for (int[] e : edge) {
			int from = e[0];
			int to = e[1];
			adjMatrix[to][from] = adjMatrix[from][to] = true;
		}

		int count[] = bfs(n, adjMatrix);
		for (int i = 1; i <= n; i++) {
			if (count[i] == depth) answer++;
		}

		return answer;
	}

	private static int[] bfs(int n, boolean[][] adjMatrix) {

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n+1];

		int start = 1; // 1번 노드로부터 시작
		queue.offer(start);
		visited[start] = true;
		depth = -1;
		int[] count = new int[n+1];

		while (!queue.isEmpty()) {
			depth++;
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int current = queue.poll();
				count[current] = depth;

				for (int j = 1; j <= n; j++) {
					if (adjMatrix[current][j] && !visited[j]) {
						queue.offer(j);
						visited[j] = true;
					}
				}
			}
		}

		return count;
	}

}
