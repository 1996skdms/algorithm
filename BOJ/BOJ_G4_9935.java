package boj;

import java.io.*;
import java.util.*;

public class BOJ_G4_9935 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String target = br.readLine();

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			if (stack.size() >= target.length() && stack.peek() == target.charAt(target.length() - 1)) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < target.length(); j++) {
					sb.append(stack.peek());
					stack.pop();
				}
				if(!target.equals(sb.reverse().toString())) {
					for (int j = 0; j < sb.length(); j++) {
						stack.push(sb.charAt(j));
					}
				}
			}
		}

		if (stack.isEmpty())
			System.out.println("FRULA");
		else {
			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty())
				sb.append(stack.pop());
			sb.reverse();
			System.out.println(sb);
		}
	}

}
