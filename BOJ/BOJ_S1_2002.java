package boj;

import java.io.*;
import java.util.*;

public class BOJ_S1_2002 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), i);
		}

		String[] exit = new String[N];
		for (int i = 0; i < N; i++) {
			exit[i] = br.readLine();
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (map.get(exit[i]) > map.get(exit[j])) {
					ans++;
					break;
				}
			}
		}

		System.out.println(ans);
	}

}
