package programmers;

public class 큰_수_만들기2 {

	public static void main(String[] args) {

		String number = "1231234";
		int k = 3;

		System.out.println(solution(number, k));
	}

	public static String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		int erase = k;

		while (sb.length() < number.length() - k) {
			int max = 0;
			int start = idx; // 시작 인덱스 갱신
			for (int i = start; i <= start + erase; i++) // 범위 조심
			{
				if (number.charAt(i) - '0' > max) {
					max = number.charAt(i) - '0';
					idx = i;
				}
			}
			sb.append(number.charAt(idx));
			erase -= (idx - start);
			idx++; // 최댓값 다음 인덱스로 갱신
		}

		String answer = sb.toString();
		return answer;
	}

}
