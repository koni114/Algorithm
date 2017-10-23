package dynamicProgramming;
import java.util.Scanner;

public class BaekJoon11726 {

	static int[] dp = new int[1001];
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		System.out.println(finalScore(score));
		scanner.close();
		
	}

	
	static int finalScore(int number) {
		if(number < 2) return 1;
		if(dp[number] > 0) {
			return dp[number];
		}else {
			dp[number] =(finalScore(number-1)%10007 + finalScore(number -2)%10007)%10007;
			return dp[number];
		}
		
	}
}