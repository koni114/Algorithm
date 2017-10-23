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
		// 초기값 지정
		for(int i=0; i<=number; i++) {
			caseNumber[i][1] = 1;
		}
		
		
		if(caseNumber[number][size] != 0) {
			return caseNumber[number][size];
		}else {
			
			// 첫번째 for 문 -> 0~N까지의 정수 부분 
			// 두번째 for 문 -> size. 정수 k개(k개만큼 더해야 함)
			// 세번째 for 문 -> l 값
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