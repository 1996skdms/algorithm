package programmers;

public class 부족한_금액_계산하기 {

	public static void main(String[] args) {

		int price = 3, money = 20, count = 4;
		System.out.println(solution(price, money, count));
	}

	public static long solution(int price, int money, int count) {
		long answer = -1;

		long sum = (long) count * (long) (count + 1) / 2 * (long) price;
		if (money >= sum) answer = 0;
		else answer = sum - money;

		return answer;
	}

}
