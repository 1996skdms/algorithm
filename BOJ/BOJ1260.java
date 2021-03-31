// DFS와 BFS

package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {

	static int N, M, V;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호
		
		adjList = new ArrayList[N+1]; // 정점 1부터 시작
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		for (int i = 1; i <=N; i++) {
			Collections.sort(adjList[i]);
		}
		
		dfs(V);
		System.out.println();
		bfs(V);
	}

	private static void dfs(int cur) {
		visited[cur] = true;
		System.out.print(cur+" ");
		for (int temp : adjList[cur]) {
			if(!visited[temp]) {
				dfs(temp);
			}
		}
	}

	private static void bfs(int cur) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(cur);
		visited[cur] = true;
		
		while(!queue.isEmpty()) {
			cur = queue.poll();
			System.out.print(cur+" ");
			for (int temp : adjList[cur]) {
				if(!visited[temp]) {
					queue.offer(temp);
					visited[temp] = true;
				}
			}
		}
	}
}
