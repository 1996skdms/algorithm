package programmers;

import java.util.*;

public class 문자열_압축 {

	public static void main(String[] args) {
		String s = "x";

		System.out.println(solution(s));
	}

	public static int solution(String s) {
		if (s.length() == 1) return 1;
		
		int answer = Integer.MAX_VALUE;
		StringBuilder sb = new StringBuilder();

		Stack<String> stack = new Stack<>();
		for (int i = 1; i <= s.length() / 2; i++) {
			for (int j = 0; j < s.length(); j += i) {

				if (j + i <= s.length() && (stack.isEmpty() || stack.peek().equals(s.substring(j, j + i))))
					stack.push(s.substring(j, j + i));
				else {
					if (stack.size() != 1) sb.append(stack.size());
					sb.append(stack.pop());
					while (!stack.isEmpty())
						stack.pop();
					if (j + i < s.length()) stack.push(s.substring(j, j + i));
					else stack.push(s.substring(j, s.length()));
				}
			}
			// stack에 남은 부분 처리
			if (stack.size() != 1) sb.append(stack.size());
			sb.append(stack.pop());
			stack.clear();

			answer = Math.min(answer, sb.length());
			sb.setLength(0);
		}
		return answer;
	}

}
