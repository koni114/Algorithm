package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ù° �ٿ� ����
		Scanner sc = new Scanner(System.in);
		int number =  sc.nextInt();
		int[] value = new int[number];
		
		// ���� �ٿ� ���� ���� �ش��ϴ� �迭
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
		// ����
		int[] dp = new int[length];
		dp[0] = value[0];
		// �ʱ�ȭ
		
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