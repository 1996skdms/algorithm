package programmers;

public class 숫자_문자열과_영단어 {

	public static void main(String[] args) {

		String s = "onetwothreefourfivesixseveneightninezero";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		int answer = 0;
		StringBuilder temp = new StringBuilder();

		int len = s.length();
		for (int i = 0; i < len; i++) {
			if ('0' <= s.charAt(i) && s.charAt(i) <= '9')
				temp.append(s.charAt(i));

			// one
			else if (s.charAt(i) == 'o') {
				temp.append(1);
				i += 2;
			}

			// two
			else if (s.charAt(i) == 't' && s.charAt(i + 1) == 'w') {
				temp.append(2);
				i += 2;
			}

			// three
			else if (s.charAt(i) == 't' && s.charAt(i + 1) == 'h') {
				temp.append(3);
				i += 4;
			}

			// four
			else if (s.charAt(i) == 'f' && s.charAt(i + 1) == 'o') {
				temp.append(4);
				i += 3;
			}

			// five
			else if (s.charAt(i) == 'f' && s.charAt(i + 1) == 'i') {
				temp.append(5);
				i += 3;
			}

			// six
			else if (s.charAt(i) == 's' && s.charAt(i + 1) == 'i') {
				temp.append(6);
				i += 2;
			}

			// seven
			else if (s.charAt(i) == 's' && s.charAt(i + 1) == 'e') {
				temp.append(7);
				i += 4;
			}

			// eight
			else if (s.charAt(i) == 'e') {
				temp.append(8);
				i += 4;
			}

			// nine
			else if (s.charAt(i) == 'n') {
				temp.append(9);
				i += 3;
			}

			// zero
			else {
				temp.append(0);
				i += 3;
			}

		}

		answer = Integer.parseInt(temp.toString());
		return answer;
	}

}
