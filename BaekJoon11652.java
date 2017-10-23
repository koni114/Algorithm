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

	// �迭�� �̿��� Ǫ�� ���
	static void finalScore(long[] cardNumber) {
		
		Arrays.sort(cardNumber);
		// ���� ����
		int currentCnt = 1; // ���� count�� ����
		int maxCnt = 1;     // ���� ������ ���� ���� ����
		long currentNumber = cardNumber[0]; // ���� ����ǰ� �ִ� ����
		long maxNumber = cardNumber[0];    // �ִ� ��
		
		for(int i=1; i<cardNumber.length; i++) {
			
			// i-1 �� i��° ���� ������� -> currentCnt ++
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
