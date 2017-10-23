package dynamicProgramming;

import java.util.Scanner;

public class BaekJoon9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �׽�Ʈ ���̽� �Է�
		Scanner scanner = new Scanner(System.in);
		int testScore = scanner.nextInt();
		int[] finalNumber = new int[testScore];
		// �׽�Ʈ ���̽� ��ŭ for loop�� �� parameter�� �Է�
		for(int i=0; i<testScore; i++) {
			int number = scanner.nextInt();
			finalNumber[i] = finalScore(number);
		}
		
		for(int i=0; i<testScore; i++) {
			System.out.println(finalNumber[i]);
		}
	}

	
	static int finalScore(int number) {
		// ���� ����. 
		int[] dp = new int[12]; // dp[i] -> i�� 1,2,3�� ������ ��Ÿ���� ����� ��
		// �ʱ� �� ����
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		// ���� dp �迭�� 0�� �ƴ� ��(����� ���� ��� �ִ� ���)�� ������ �� ���� �ٷ� ����
		// �ƴ� ���, ��� �Լ� �̿�
		if( dp[number] != 0) {
			return dp[number];
		}else {
			dp[number] = finalScore(number - 1) +finalScore(number -2) + finalScore(number -3);
			return dp[number];
		}
		
	}
}