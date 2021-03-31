// 서로소 집합

package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3289_김나은 {

	static int n;
	static int parents[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 연산의 개수
			int m = Integer.parseInt(st.nextToken()); // 연산

			parents = new int[n + 1];

			make();

			System.out.print("#" + tc + " ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (op == 0) {
					union(a, b); // 합집합
				}else if (op == 1) {
					if (findSet(a) == findSet(b)) // 같은 집합에 속해있다면
						System.out.print(1);
					else
						System.out.print(0);
				}
			}
			System.out.println();
		}
	}

	private static void make() {
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
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

}
