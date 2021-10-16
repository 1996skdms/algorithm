package boj;

import java.io.*;
import java.util.*;

public class BOJ_S1_20055 {

	static int N, K, stage, cnt;
	static int[] belt;
	static boolean[] robot;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2 * N + 1];
		robot = new boolean[2 * N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= 2 * N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		while (true) {
			stage++;
			rotate();
			moveRobot();
			if (cnt >= K) break;
		}

		System.out.println(stage);
	}

	private static void moveRobot() {
		if (robot[N]) robot[N] = false; // 언제든지 로봇이 내리는 위치에 도달하면 그 즉시 내린다

		for (int i = N - 1; i > 0; i--) {
			if (robot[i] && !robot[i + 1] && belt[i + 1] > 0) {
				robot[i] = false;
				robot[i + 1] = true;
				if (--belt[i + 1] == 0) cnt++; // 로봇이 어떤 칸으로 이동하면 그 칸의 내구도는 즉시 1만큼 감소한다
			}
		}
		if (robot[N]) robot[N] = false; // 언제든지 로봇이 내리는 위치에 도달하면 그 즉시 내린다

		if (!robot[1] && belt[1] > 0) {
			robot[1] = true; // 로봇을 올리는 위치에 올리고
			if (--belt[1] == 0) cnt++; // 그 칸의 내구도는 즉시 1만큼 감소한다
		}
	}

	private static void rotate() {
		belt[0] = belt[2 * N];
		for (int i = 2 * N; i > 0; i--) {
			belt[i] = belt[i - 1];
		}

		robot[0] = robot[2 * N];
		for (int i = 2 * N; i > 0; i--) {
			robot[i] = robot[i - 1];
		}
	}

}
