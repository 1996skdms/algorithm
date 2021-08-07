package programmers;

public class 행렬_테두리_회전하기 {

	public static void main(String[] args) {

		int rows = 6;
		int columns = 6;
		int[][] queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };
		
		int[] ans = solution(rows, columns, queries);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

	public static int[] solution(int rows, int columns, int[][] queries) {
		int len = queries.length;
		int[] answer = new int[len];
		
		// 배열 셋팅
		int num = 1;
		int[][] map = new int[rows+1][columns+1];
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				map[i][j] = num++;
			}
		}
		
		// 행렬 테두리 회전
		for (int i = 0; i < len; i++) {
			int[] query = queries[i];
			
			int start = map[query[0]][query[1]];
			int min = start;
			// 왼쪽
			for (int j = query[0]; j < query[2]; j++) {
				map[j][query[1]] = map[j+1][query[1]];
				min = Math.min(min, map[j][query[1]]);
			}
			
			// 아래
			for (int j = query[1]; j < query[3]; j++) {
				map[query[2]][j] = map[query[2]][j+1];
				min = Math.min(min, map[query[2]][j]);
			}
			
			// 오른쪽
			for (int j = query[2]; j > query[0]; j--) {
				map[j][query[3]] = map[j-1][query[3]];
				min = Math.min(min, map[j][query[3]]);
			}

			// 위
			for (int j = query[3]; j > query[1]; j--) {
				map[query[0]][j] = map[query[0]][j-1];
				min = Math.min(min, map[query[0]][j]);
			}			
			map[query[0]][query[1]+1] = start;
			
			answer[i] = min;
		}
		
		return answer;
	}

}
