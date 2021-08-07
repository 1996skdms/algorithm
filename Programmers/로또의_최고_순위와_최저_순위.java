package programmers;

public class 로또의_최고_순위와_최저_순위 {

	public static void main(String[] args) {

		int[] lottos = { 1, 2, 3, 4, 5, 6 };
		int[] win_nums = { 7, 8, 9, 10, 11, 12 };

		int[] ans = solution(lottos, win_nums);
		System.out.printf("%d, %d", ans[0], ans[1]);

	}

	public static int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];

		int ans = 0, zeroCnt = 0;
		for (int i = 0; i < 6; i++) {
			if (lottos[i] == 0) zeroCnt++;
			else {
				for (int j = 0; j < 6; j++) {
					if (lottos[i] == win_nums[j]) ans++;
				}
			}
		}

		answer[0] = 7 - (ans + zeroCnt) >= 7 ? 6 : 7 - (ans + zeroCnt);
		answer[1] = 7 - ans >= 7 ? 6 : 7 - ans;
		return answer;
	}
}
