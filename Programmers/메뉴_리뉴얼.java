package programmers;

import java.util.*;

public class 메뉴_리뉴얼 {

	static HashMap<String, Integer> map;
	static int max;

	public static void main(String[] args) {
		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		int[] course = { 2, 3, 4 };

		String[] answer = solution(orders, course);
		for (int i = 0; i < answer.length; i++)
			System.out.println(answer[i]);
	}

	public static String[] solution(String[] orders, int[] course) {
		PriorityQueue<String> pq = new PriorityQueue<>(); // 코스요리 메뉴의 구성을 오름차순 정렬

		// 코스 갯수만큼 조합
		for (int i = 0; i < course.length; i++) {
			map = new HashMap<>();
			max = 0;

			for (int j = 0; j < orders.length; j++) {
				find(0, course[i], 0, "", orders[j]);
			}

			for (String str : map.keySet())
				if (map.get(str) == max && map.get(str) > 1) // 최소 2명 이상의 손님에게서 주문된 구성만 코스요리 후보에 들어감
					pq.offer(str);
		}

		int idx = 0;
		String[] answer = new String[pq.size()];
		while (!pq.isEmpty()) answer[idx++] = pq.poll();

		return answer;
	}

	public static void find(int cnt, int target, int start, String str, String order) {
		if (cnt == target) {
			char[] c = str.toCharArray();
			Arrays.sort(c); // 배열의 각 원소에 저장된 문자열 또한 알파벳 오름차순으로 정렬

			String temp = "";
			for (int i = 0; i < c.length; i++) temp += c[i];

			map.put(temp, map.getOrDefault(temp, 0) + 1); // 단품메뉴 조합 갯수 갱신
			max = Integer.max(max, map.get(temp)); // 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성
			return;
		}

		for (int i = start; i < order.length(); i++) {
			char c = order.charAt(i);
			find(cnt + 1, target, i + 1, str + c, order);
		}
	}

}
