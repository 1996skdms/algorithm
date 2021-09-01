package programmers;

import java.util.*;

public class 표_편집2 {

	public static void main(String[] args) {
		int n = 8;
		int k = 2;
		String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C" };

		System.out.println(solution(n, k, cmd));
	}

	public static String solution(int n, int k, String[] cmd) {
		String answer = "";
		Stack<Integer> stack = new Stack<>();

		int size = n;
		for (int i = 0; i < cmd.length; i++) {
			char dir = cmd[i].charAt(0);

			if (dir == 'U') {
				k -= Integer.parseInt(cmd[i].substring(2));
			} else if (dir == 'D') {
				k += Integer.parseInt(cmd[i].substring(2));
			} else if (dir == 'C') {
				stack.push(k);

				if (k == size-1) k = size-2;
				size--;
			} else if (dir == 'Z') {
				int idx = stack.pop();

				if (idx <= k) k++;
				size++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++)
			sb.append('O');

		while (!stack.isEmpty())
			sb.insert(stack.pop().intValue(), 'X');

		answer = sb.toString();
		return answer;
	}
}
