package programmers;

import java.util.*;

public class 위장 {

	public static void main(String[] args) {
		String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};

		System.out.println(solution(clothes));
	}

	public static int solution(String[][] clothes) {
		int answer = 1;

		HashMap<String, Integer> map = new HashMap<>();

		for (String[] cloth : clothes) {
			if (map.get(cloth[1]) == null) map.put(cloth[1], 1); // Object get(Object key) : key의 value를 반환
			else map.put(cloth[1], map.get(cloth[1]) + 1); // 갱신
		}

		for (String key : map.keySet()) { // map.keySet() : map의 key들을 모아서 set 형태로 반환
			answer *= (map.get(key) + 1); // +1 : 각 의상의 종류마다 입지 않았을 때
		}

		return answer - 1; // 아무것도 안 입었을 때 제외
	}

}
