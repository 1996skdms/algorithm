package programmers;

import java.util.*;

public class 기능개발 {

	public static void main(String[] args) {
		int[] progresses = { 95, 90, 99, 99, 80, 99 };
		int[] speeds = { 1, 1, 1, 1, 1, 1 };

		int[] ans = solution(progresses, speeds);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int len = progresses.length;
		int[] days = new int[len];
		int day = 0;
		for (int i = 0; i < len; i++) {
			day = (100 - progresses[i]) / speeds[i];
			if ((100 - progresses[i]) % speeds[i] != 0) day += 1;
			
			days[i] = day;
		}

		ArrayList<Integer> list = new ArrayList<>();
		int cnt = 1;
		day = days[0];
		for (int i = 1; i < len; i++) {
			if (days[i] > day) {
				list.add(cnt);
				cnt = 1;
				day = days[i];
			} else {
				cnt++;
			}
		}
		list.add(cnt);

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}
