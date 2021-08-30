package programmers;

public class 타겟_넘버 {

	public static int cnt;

	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;

		System.out.println(solution(numbers, target));
	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;

		dfs(numbers, target, 0, 0);

		answer = cnt;
		return answer;
	}

	public static void dfs(int[] numbers, int target, int i, int sum) {
		if (i == numbers.length) {
			if (target == sum) cnt++;

			return;
		}
		
		dfs(numbers, target, i+1, sum-numbers[i]);
		dfs(numbers, target, i+1, sum+numbers[i]);		

	}
}
