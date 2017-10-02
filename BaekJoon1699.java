package dynamicProgramming;

import java.util.Scanner;

public class BaekJoon1699 {

	static int[] dp;
	
	public static void main(String[] args) {
		dp = new int[1000];
		dp[0] =0;
		dp[1] =1;
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		// 초기값 선언
				

				System.out.println(finalScore(number));
				System.out.println(finalScore2(number));
	}

	// Top-down 방식
	static int finalScore(int number) {
		// for loop를 통한 점화식 구현
		// dp[N] = dp[N - i^2] + 1
		if(dp[number] != 0) {
			return dp[number];
		}else {
			dp[number] = Integer.MAX_VALUE;
			for(int i=1; (i*i)<= number; i++) {
				if(dp[number] > (finalScore(number-(i*i)) + 1)){
					dp[number] = (finalScore(number-(i*i)) + 1); 
				}
			}
			return dp[number];
		}
		
		
	}
	// bottom-up 방식
	static int finalScore2(int number) {
		
		for(int i=0; i<=number; i++) {
			dp[i] = i;
			for(int j=1; j*j<i; j++) {
				if(dp[i] > dp[i-(j*j)] +1) {
					dp[i] = dp[i-(j*j)] + 1;
				}
			}
		}
		
		return dp[number];
	}
}
