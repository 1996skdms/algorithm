package programmers;

import java.util.*;

public class 체육복 {
	
	public static void main(String[] args) {

		int n = 3;
		int[] lost = { 3 };
		int[] reserve = { 1 };

		System.out.println(solution(n, lost, reserve));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		boolean[] student = new boolean[n + 1];
		boolean[] check = new boolean[n + 1];
		Arrays.fill(student, true);

		// 도난당한 학생들
		for (int i = 0; i < lost.length; i++) {
			student[lost[i]] = false;
		}

		// 여벌 체육복을 가져온 학생이 도난당했을 때
		for (int i = 0; i < reserve.length; i++) {
			if (student[reserve[i]] == false) {
				student[reserve[i]] = true;
				check[reserve[i]] = true;
			}
		}

		for (int i = 0; i < reserve.length; i++) {
			if (!check[reserve[i]]) {
				if (reserve[i] != 1 && student[reserve[i] - 1] == false) student[reserve[i] - 1] = true;
				else if (reserve[i] != n && student[reserve[i] + 1] == false) student[reserve[i] + 1] = true;
			}
		}

		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (student[i]) answer++;
		}

		return answer;
	}
}
