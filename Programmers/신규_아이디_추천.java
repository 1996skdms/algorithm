package programmers;

public class 신규_아이디_추천 {

	public static void main(String[] args) {

		String new_id = "=.=";
		System.out.println(solution(new_id));
	}

	public static String solution(String new_id) {
		String answer = "";
		StringBuilder temp = new StringBuilder();
		StringBuilder temp2 = new StringBuilder();

		// 1단계
		temp.append(new_id.toLowerCase());

		// 2단계
		for (int i = 0; i < temp.length(); i++) {
			char c = temp.charAt(i);
			if (('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || c == '-' || c == '_' || c == '.')
				temp2.append(c);
		}
		temp.setLength(0);

		// 3단계
		for (int i = 0; i < temp2.length(); i++) {
			char c = temp2.charAt(i);
			temp.append(c);
			if (i >= 1 && c == '.' && temp2.charAt(i - 1) == '.')
				temp.setLength(temp.length() - 1);
		}
		temp2.setLength(0);

		// 4단계
		answer = temp.toString();
		if (answer.charAt(0) == '.') answer = answer.substring(1);
		if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.')
			answer = answer.substring(0, answer.length() - 1);

		// 5단계
		if (answer.isEmpty()) answer = "a";

		// 6단계
		if (answer.length() >= 16) answer = answer.substring(0, 15);
		if (answer.charAt(answer.length() - 1) == '.') answer = answer.substring(0, answer.length() - 1);

		// 7단계
		while (answer.length() <= 2) {
			answer += answer.charAt(answer.length() - 1);
		}

		return answer;
	}

}
