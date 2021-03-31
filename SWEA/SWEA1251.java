// 하나로

package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA1251 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			double[][] adjMatrix = new double[N][N];
			double[][] pos = new double[N][2];
			boolean[] visited = new boolean[N];
			double[] minEdge = new double[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pos[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pos[i][1] = Integer.parseInt(st.nextToken());
			}
			double E = Double.parseDouble(br.readLine());

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					double dist = getDist(pos[i][0], pos[i][1], pos[j][0], pos[j][1]);
					adjMatrix[i][j] = dist;
					adjMatrix[j][i] = dist;
				}
			}

			Arrays.fill(minEdge, Double.MAX_VALUE);
			double result = 0;
			minEdge[0] = 0;

			for (int c = 0; c < N; c++) {
				double min = Double.MAX_VALUE;
				int minVertex = 0;

				for (int i = 0; i < N; i++) {
					if (!visited[i] && min > minEdge[i]) {
						min = minEdge[i];
						minVertex = i;
					}
				}
				
				result += min;
				visited[minVertex] = true;

				for (int j = 0; j < N; j++) {
					if (!visited[j] && adjMatrix[minVertex][j] != 0 && minEdge[j] > adjMatrix[minVertex][j]) {
						minEdge[j] = adjMatrix[minVertex][j];
					}
				}
			}

			System.out.println("#" + tc + " " + Math.round(result * E));
		}

	}

	private static double getDist(double X1, double Y1, double X2, double Y2) {
		return Math.pow(X1 - X2, 2) + Math.pow(Y1 - Y2, 2);
	}

}
