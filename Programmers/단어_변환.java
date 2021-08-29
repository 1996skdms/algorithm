package programmers;

public class 단어_변환 {

	static int answer;
	static boolean[] visited;

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

		System.out.println(solution(begin, target, words));
	}

	public static int solution(String begin, String target, String[] words) {
		boolean check = false;
		for (String word : words) {
			if (target.equals(word))
				check = true;
		}
		if (!check) return 0;

		answer = Integer.MAX_VALUE;
		visited = new boolean[words.length];
		dfs(begin, target, words, 0);

		return answer;
	}

	public static void dfs(String cur, String target, String[] words, int count) {
		if (count > answer) return;

		if (cur.equals(target)) {
			answer = Math.min(answer, count);
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (visited[i]) continue;
			
			int cnt = 0;
			for (int j = 0; j < cur.length(); j++) {
				if (cur.charAt(j) == words[i].charAt(j)) continue;
				else cnt++;
			}
			
			if (cnt == 1) // 한 번에 한 개의 알파벳만 변환 가능
			{
				visited[i] = true;
				dfs(words[i], target, words, count+1);
				visited[i] = false;
			}
		}
	}

}
