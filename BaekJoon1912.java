package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 첫째 줄에 정수
		Scanner sc = new Scanner(System.in);
		int number =  sc.nextInt();
		int[] value = new int[number];
		
		// 둘재 줄에 정수 값에 해당하는 배열
		sc.nextLine();
		String temp = sc.nextLine();
		String[] stringValue = temp.split(" ");
		
		
		for(int i=0; i<number; i++) {
			value[i] = Integer.parseInt(stringValue[i]);
		}
		finalScore(value);
	}

	static void finalScore(int[] value)
	{
		int length = value.length;
		// 선언
		int[] dp = new int[length];
		dp[0] = value[0];
		// 초기화
		
		for(int i=1; i<length; i++) {
			if( dp[i-1] + value[i] > value[i]) {
				dp[i] = dp[i-1] + value[i];
			}else {
				dp[i] = value[i];
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[length-1]);
	}
}