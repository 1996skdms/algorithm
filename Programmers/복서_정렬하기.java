package programmers;

import java.util.*;

public class 복서_정렬하기 {

	public static class Info{
		int idx;
		double rate;
		int count;
		int weight;
		
		public Info(int idx, double rate, int count, int weight) {
			this.idx = idx;
			this.rate = rate;
			this.count = count;
			this.weight = weight;
		}
	}
	
	static class Sort implements Comparator<Info>{
		@Override
		public int compare(Info o1, Info o2) {
			if(o1.rate > o2.rate) return -1;
			else if(o1.rate < o2.rate) return 1;
			else {
				if(o1.count > o2.count) return -1;
				else if(o1.count < o2.count) return 1;
				else {
					if(o1.weight > o2.weight) return -1;
					else if(o1.weight < o2.weight) return 1;
					else return 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] weights = { 50, 82, 75, 120 };
		String[] head2head = { "NLWL", "WNLL", "LWNW", "WWLN" };

		int[] answer = solution(weights, head2head);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public static int[] solution(int[] weights, String[] head2head) {
		List<Info> player = new ArrayList<>();

		for (int i = 0; i < weights.length; i++) {
			String str = head2head[i];
			int win = 0, cnt = 0, round = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'N' ) round++;
				if (str.charAt(j) == 'W') {
					win++;
					if (weights[i] < weights[j]) cnt++;
				}
			}

			double rate = (win * 100 / (double)(weights.length - round));
			int count = cnt;
			int weight = weights[i];
			player.add(new Info(i+1, rate, count, weight));
		}
		
		Collections.sort(player, new Sort());

		int[] answer = new int[weights.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = player.get(i).idx;
		}
		return answer;
	}
}
