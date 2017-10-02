package dynamicProgramming;

import java.util.Scanner;

public class BaekJoon2133 {

	static int[] dp = new int[31];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		dp[0] = 1;
		dp[1] = 0;
		finalScore(number);
		
	}

	static void finalScore(int number) {
		
		if(dp[number] != 0) {
			 System.out.println(dp[number]);
		}else {
		for(int i=2; i<=number; i++) {
				dp[i] += 3*dp[i-2];
				for(int j=i-4; j>=0; j=j-2) {
					dp[i] += 2*dp[j];
				}
		}
		System.out.println(dp[number]);	
		}
	}
}
