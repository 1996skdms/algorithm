// 맥주 마시면서 걸어가기

package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9205 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 편의점 개수
			int[][] pos = new int[N+2][2];
			int[][] dist = new int[N+2][N+2];
			boolean[][] visit = new boolean[N+2][N+2];
			
			for (int i = 0; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					dist[i][j] = Math.abs(pos[i][0]-pos[j][0]) + Math.abs(pos[i][1]-pos[j][1]);
					if(dist[i][j] <= 1000) visit[i][j] = true;
				}
			}
			
			for (int i = 0; i < N+2; i++) { // 경유지
				for (int j = 0; j < N+2; j++) { // 출발
					for (int k = 0; k < N+2; k++) { // 도착
						if(visit[j][i] && visit[i][k]) visit[j][k] = true;
					}
				}
			}
			
			if(visit[0][N+1]) System.out.println("happy");
			else System.out.println("sad");
		}
		
	}
}
