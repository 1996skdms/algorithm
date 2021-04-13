package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_2564_경비원 {

	static int R, C;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		int storeCnt = Integer.parseInt(br.readLine());
		int[] distance = new int[storeCnt+1];
		for (int i = 0; i <= storeCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());
			distance[i] = calc(dir, pos);
		}
		
		int start = distance[storeCnt];
		int ans = 0;
		for (int i = 0; i < storeCnt; i++) {
			int clockwise = Math.abs(start-distance[i]);
			ans += Math.min(clockwise, C+R+C+R-clockwise);
		}
		
		System.out.println(ans);
	}

	private static int calc(int dir, int pos) {
		if(dir==1) return pos; // 북쪽
		else if(dir==2) return C+R+C-pos; // 남쪽
		else if(dir==3) return C+R+C+R-pos; // 서쪽
		else return C+pos; // 동쪽
	}
	
}
