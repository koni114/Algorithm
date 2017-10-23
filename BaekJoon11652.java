package sort;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon11652 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		long[] cardNumber = new long[size];
		
		for(int i= 0; i< size ; i++) {
			cardNumber[i] = scanner.nextLong();
		}
		
		finalScore(cardNumber);
		
	}

	// 배열을 이용해 푸는 방법
	static void finalScore(long[] cardNumber) {
		
		Arrays.sort(cardNumber);
		// 변수 선언
		int currentCnt = 1; // 현재 count된 개수
		int maxCnt = 1;     // 가장 개수가 많은 값의 개수
		long currentNumber = cardNumber[0]; // 현재 진행되고 있는 개수
		long maxNumber = cardNumber[0];    // 최대 값
		
		for(int i=1; i<cardNumber.length; i++) {
			
			// i-1 와 i번째 값이 같은경우 -> currentCnt ++
			if( cardNumber[i-1] == cardNumber[i]) {
				currentCnt++;
			}else {
				if(currentCnt > maxCnt) {
					maxNumber = cardNumber[i-1];
					maxCnt = currentCnt;
				}
				currentCnt = 1;
				currentNumber = cardNumber[i];
			}
			
		}
		if(currentCnt > maxCnt) {
			maxNumber = cardNumber[cardNumber.length-1];
		}
		
		System.out.println(maxNumber);
		
	}
	
}
