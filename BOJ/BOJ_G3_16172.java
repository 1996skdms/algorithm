package boj;

import java.io.*;

public class BOJ_G3_16172 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String target = br.readLine();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if ('0' <= str.charAt(i) && str.charAt(i) <= '9') continue;
			sb.append(str.charAt(i));
		}

		int[] kmp = new int[200001];
		for (int i = 1, j = 0; i < target.length(); i++) {
			while (j > 0 && target.charAt(i) != target.charAt(j)) j = kmp[j - 1];
			if (target.charAt(i) == target.charAt(j)) kmp[i] = ++j;
		}

		for (int i = 0, j = 0; i < sb.length(); i++) {
			while (j > 0 && sb.charAt(i) != target.charAt(j)) j = kmp[j - 1];
			if (sb.charAt(i) == target.charAt(j)) {
				if (j == target.length() - 1) {
					System.out.println(1);
					return;
				} else j++;
			}
		}

		System.out.println(0);
	}

}
