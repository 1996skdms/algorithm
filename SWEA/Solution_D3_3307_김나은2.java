// 최장 증가 부분 수열

package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_3307_김나은2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] LIS = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int max = 0;
			int size = 0;

			LIS[size++] = arr[0];
			for (int i = 1; i < N; i++) {
				int temp = Math.abs(Arrays.binarySearch(LIS, 0, size, arr[i])) - 1;
				LIS[temp] = arr[i];
					
				if(temp == size) {
					++size;
				}
			}
			System.out.println("#" + tc + " " + size);
		}
	}

}
