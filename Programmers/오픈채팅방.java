package programmers;

import java.util.*;

public class 오픈채팅방 {

	public static void main(String[] args) {

		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };

		for (int i = 0; i < record.length; i++) {
			System.out.println(solution(record)[i]);
		}
	}

	public static String[] solution(String[] record) {
		HashMap<String, String> map = new HashMap<String, String>();
		Queue<String[]> queue = new LinkedList<>();

		int len = record.length;
		for (int i = 0; i < len; i++) {
			String[] split = record[i].split(" ");
			if (record[i].charAt(0) == 'E') {
				map.put(split[1], split[2]);
				queue.offer(new String[] { split[1], "E" });
			} else if (record[i].charAt(0) == 'L') {
				queue.offer(new String[] { split[1], "L" });
			} else {
				map.put(split[1], split[2]);
			}
		}

		int size = queue.size();
		String[] answer = new String[size];
		for (int i = 0; i < size; i++) {
			String[] cur = queue.poll();
			if (cur[1].equals("E")) answer[i] = map.get(cur[0]) + "님이 들어왔습니다.";
			else answer[i] = map.get(cur[0]) + "님이 나갔습니다.";
		}

		return answer;
	}
}
