package boj;

import java.io.*;
import java.util.*;

public class BOJ_G4_17140 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int k = Integer.parseInt(st.nextToken());

		int[][] arr = new int[100][100]; // 행 또는 열의 크기가 100을 넘어가는 경우에는 처음 100개를 제외한 나머지는 버린다.
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] < o2[1]) return -1;
				else if (o1[1] == o2[1]) {
					if (o1[0] < o2[0]) return -1;
					else return 1;
				}
				return 1;
			}
		});

		int rsize = 3, csize = 3, cnt = 0, max = 0;
		while (true) {
			if (arr[r][c] == k) break;
			if (cnt > 100) break;
			max = 0;

			if (rsize >= csize) {
				for (int i = 0; i < rsize; i++) {
					map.clear();
					pq.clear();

					for (int j = 0; j < csize; j++) {
						if (arr[i][j] == 0) continue;
						map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
						arr[i][j] = 0;
					}

					for (int key : map.keySet()) {
						pq.add(new int[] { key, map.get(key) });
					}

					max = Math.max(max, pq.size() * 2);
					if (max > 100) max = 100;

					for (int j = 0; j < 100 && !pq.isEmpty(); j++) {
						arr[i][j++] = pq.peek()[0];
						arr[i][j] = pq.peek()[1];
						pq.poll();
					}
				}
				csize = max;
			} else {
				for (int j = 0; j < csize; j++) {
					map.clear();
					pq.clear();

					for (int i = 0; i < rsize; i++) {
						if (arr[i][j] == 0) continue;
						map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
						arr[i][j] = 0;
					}

					for (int key : map.keySet()) {
						pq.add(new int[] { key, map.get(key) });
					}

					max = Math.max(max, pq.size() * 2);
					if (max > 100) max = 100;

					for (int i = 0; i < 100 && !pq.isEmpty(); i++) {
						arr[i++][j] = pq.peek()[0];
						arr[i][j] = pq.peek()[1];
						pq.poll();
					}
				}
				rsize = max;
			}
			
			cnt++;
		}

		cnt = cnt <= 100 ? cnt : -1;
		System.out.println(cnt);
	}

}
