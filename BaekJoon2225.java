package dynamicProgramming;

import java.util.Scanner;

public class BaekJoon2225 {

	static int[][] caseNumber;
	
	public static void main(String[] args) {

		caseNumber = new int[201][201];
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int size = sc.nextInt();
		
		System.out.println(finalScore(number,size));
		
	}

	static int finalScore(int number, int size) {
		// �ʱⰪ ����
		for(int i=0; i<=number; i++) {
			caseNumber[i][1] = 1;
		}
		
		
		if(caseNumber[number][size] != 0) {
			return caseNumber[number][size];
		}else {
			
			// ù��° for �� -> 0~N������ ���� �κ� 
			// �ι�° for �� -> size. ���� k��(k����ŭ ���ؾ� ��)
			// ����° for �� -> l ��
			for(int i=0;i<=number;i++){
			    for(int j=1;j<=size;j++){
			        for(int l=0;l<=i;l++){
			        	caseNumber[i][j] += caseNumber[i-l][j-1];
			        	caseNumber[i][j] %= 1000000000;
			        }
			    }
			}
			return caseNumber[number][size];
		}
		
	}
	
}