package dynamicProgramming;

import java.util.Scanner;

public class BaekJoon9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 테스트 케이스 입력
		Scanner scanner = new Scanner(System.in);
		int testScore = scanner.nextInt();
		int[] finalNumber = new int[testScore];
		// 테스트 케이스 만큼 for loop로 값 parameter로 입력
		for(int i=0; i<testScore; i++) {
			int number = scanner.nextInt();
			finalNumber[i] = finalScore(number);
		}
		
		for(int i=0; i<testScore; i++) {
			System.out.println(finalNumber[i]);
		}
	}

	
	static int finalScore(int number) {
		// 변수 선언. 
		int[] dp = new int[12]; // dp[i] -> i를 1,2,3의 합으로 나타내는 방법의 수
		// 초기 값 선언
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		// 만약 dp 배열에 0이 아닌 값(경우의 수가 들어 있는 경우)이 있으면 그 값을 바로 리턴
		// 아닌 경우, 재귀 함수 이용
		if( dp[number] != 0) {
			return dp[number];
		}else {
			dp[number] = finalScore(number - 1) +finalScore(number -2) + finalScore(number -3);
			return dp[number];
		}
		
	}
}