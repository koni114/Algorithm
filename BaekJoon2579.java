package dynamicProgramming;

import java.util.Collection;
import java.util.Scanner;

public class BaekJoon2579 {

	static int[] dp;
	
	public static void main(String[] args) {

		// 입력 값 받기
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arrayValue = new int[size]; 
		
		for(int i=0; i<size; i++) {
			arrayValue[i] = sc.nextInt();
		}
		
		finalScore(arrayValue);
		
	}

	
	static void finalScore(int[] arrayValue) {
		// 변수 선언
		int size = arrayValue.length;
		dp = new int[size];
		dp[0] = arrayValue[0];
		dp[1] = arrayValue[0] + arrayValue[1];
		
		if(arrayValue[1] > arrayValue[0] ) {
			dp[2] = arrayValue[2] + arrayValue[1];
		}else {
			dp[2] = arrayValue[2] + arrayValue[0];
		}
		// 
		for(int i=3; i<size; i++) {
			int number1 = arrayValue[i-1] + dp[i-3] + arrayValue[i];
			int number2 = dp[i-2] + arrayValue[i];
			if(number1 > number2) {
				dp[i] = number1;
			}else {
				dp[i] = number2;
			}
		}
		
		System.out.println(dp[size-1]);
		}
	}

