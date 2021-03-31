// 1로 만들기

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S3_1463_김나은 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int[] D = new int[X+1];
		
		D[1] = 0;
		for (int i = 2; i <=X; i++) {
			int min = Integer.MAX_VALUE;
			if(i%3==0 && D[i/3]+1 < min) min = D[i/3]+1;
			if(i%2==0 && D[i/2]+1 < min) min = D[i/2]+1;
			if(D[i-1]+1 < min) min = D[i-1]+1;
			D[i] = min;
		}
		System.out.println(D[X]);
	}

}
