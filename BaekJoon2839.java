package etc;

import java.util.Scanner;

public class BaekJoon2839 {

	static int cnt;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int sugarSize = sc.nextInt();
		int fiveNumber = 0;
		// 1. 먼저 5로 나눈 몫을 저장
		if(sugarSize % 5 == 0){
			System.out.println(sugarSize / 5);
			return;
		}else {
			fiveNumber = sugarSize / 5;
		}
		// 2. for 문을 돌면서 . 5와 3으로 소인수 분해가 되는 경우 -> 두개의 제곱수를 더한 값을 출력 후 종료 
		for(int i = fiveNumber; i >= 0; i--) {
			int threeNumber = sugarSize - 5*i;
			if(threeNumber % 3 == 0){
				System.out.println(threeNumber/3 + i);
				return;
			};
		}
		
		System.out.println(-1);
	
	}
}
