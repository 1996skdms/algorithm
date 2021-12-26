/**
* 메모리: 48604 KB, 시간: 540 ms
* 2021.12.26
* by Alub
*/
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] log = new int[N];
			int[] arr = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				log[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(log);

			int start = 0, end = N - 1, idx = 0;
			while (start <= end) {
				arr[start] = log[idx++];
				start++;
				if (idx == N) break;
				arr[end] = log[idx++];
				end--;
				if (idx == N) break;
			}

			int ans = Math.abs(arr[0] - arr[N - 1]);
			for (int i = 1; i < N; i++) {
				ans = Math.max(ans, Math.abs(arr[i] - arr[i - 1]));
			}

			System.out.println(ans);
		}
	}

}
