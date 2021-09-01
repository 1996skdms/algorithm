package programmers;

import java.util.*;

public class 표_편집 {

	public static class Pos {
		int Row;
		int Name;

		public Pos(int row, int name) {
			Row = row;
			Name = name;
		}

		public int getRow() {
			return Row;
		}

		public void setRow(int row) {
			Row = row;
		}

		public int getName() {
			return Name;
		}

		public void setName(int name) {
			Name = name;
		}
	}

	public static void main(String[] args) {
		int n = 8;
		int k = 2;
		String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C" };

		System.out.println(solution(n, k, cmd));
	}

	public static String solution(int n, int k, String[] cmd) {
		String answer = "";
		LinkedList<Pos> list = new LinkedList<>();
		Stack<Pos> stack = new Stack<>();

		for (int i = 0; i < n; i++)
			list.add(i, new Pos(i, i));

		int cur = k;
		for (int i = 0; i < cmd.length; i++) {
			String op = cmd[i];

			if (op.charAt(0) == 'U') {
				cur -= Integer.parseInt(op.substring(2));
			} else if (op.charAt(0) == 'D') {
				cur += Integer.parseInt(op.substring(2));
			} else if (op.charAt(0) == 'C') {
				Pos p = list.get(cur);
				p.setRow(list.indexOf(p));
				stack.push(p);

				if (cur == list.size() - 1)
					cur = list.size() - 2;
				list.remove(p);
			} else if (op.charAt(0) == 'Z') {
				Pos idx = list.get(cur);

				Pos p = stack.pop();
				list.add(p.getRow(), p);

				cur = list.indexOf(idx); // 선택된 행은 바뀌지 않음
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append('O');

		while (!stack.isEmpty())
			sb.setCharAt(stack.pop().getName(), 'X');

		answer = sb.toString();
		return answer;
	}
}
