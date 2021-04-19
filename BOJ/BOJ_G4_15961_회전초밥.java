package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_15961_회전초밥 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 회전 초밥 벨트에 놓인 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		int[] sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		int[] variety = new int[d+1];
		int ans = 0;
		
		// 쿠폰 체크
		variety[c]++;
		int cnt = 1;
		
		// 초기값 설정 : 0번부터 k-1번까지(k개) 카운트
		for (int i = 0; i < k; i++) {
			if(variety[sushi[i]]++ == 0) cnt++;
//			variety[sushi[i]]++;
		}
		
		// k번째부터 맨 앞에꺼 하나 빼고, 맨 뒤에꺼 하나 넣고
		for (int i = 0; i < N; i++) {
			if(variety[sushi[(i+k) % N]]++ == 0) cnt++;
//			variety[sushi[(i+k) % N]]++;
			
//			variety[sushi[i]]--;
			if(--variety[sushi[i]] == 0) cnt--;
			
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
	}

}
