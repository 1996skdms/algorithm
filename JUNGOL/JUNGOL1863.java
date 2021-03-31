// 종교

package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL1863 {

	static int n;
	static int[] parents;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 학생 수
		int m = Integer.parseInt(st.nextToken()); // 쌍의 수

		parents = new int[n + 1];

		make();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (i == parents[i])
				cnt++;
		}

		System.out.println(cnt);

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
