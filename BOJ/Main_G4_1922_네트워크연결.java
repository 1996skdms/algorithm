package BOJ;

import java.io.*;
import java.util.*;

public class Main_G4_1922_네트워크연결 {

	private static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	private static int N, M;
	private static int[] parents;
	private static Edge[] edgeList;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		edgeList = new Edge[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}

		Arrays.sort(edgeList);

		make();

		int count = 0, ans = 0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				ans += edge.weight;
				if (++count == N-1) break;
			}
		}
		System.out.println(ans);

	}

	private static int findSet(int a) {
		if (parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;

		parents[bRoot] = aRoot;
		return true;
	}

	private static void make() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
}
