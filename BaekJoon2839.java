package etc;

import java.util.Scanner;

public class BaekJoon2839 {

	static int cnt;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int sugarSize = sc.nextInt();
		int fiveNumber = 0;
		// 1. ���� 5�� ���� ���� ����
		if(sugarSize % 5 == 0){
			System.out.println(sugarSize / 5);
			return;
		}else {
			fiveNumber = sugarSize / 5;
		}
		// 2. for ���� ���鼭 . 5�� 3���� ���μ� ���ذ� �Ǵ� ��� -> �ΰ��� �������� ���� ���� ��� �� ���� 
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
