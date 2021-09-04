package programmers;

public class 모음_사전 {

	static int cnt, ans;
	static char[] alpabet = { 'A', 'E', 'I', 'O', 'U' };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		String word = "EIO";

		System.out.println(solution(word));
	}

	public static int solution(String word) {
		int answer = 0;

		dfs("", word);

		answer = ans;
		return answer;
	}

	public static void dfs(String current, String word) {
		if (current.length() > 5) return;

		if (current.equals(word)) {
			ans = cnt;
			return;
		}

		cnt++;

		for (int i = 0; i < 5; i++) {
			sb.append(alpabet[i]);
			dfs(sb.toString(), word);

			sb.setLength(sb.length() - 1);
		}
	}

}
