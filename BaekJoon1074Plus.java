package divideAndConquer;

import java.util.Scanner;

// ��Ÿ�� ���� �߻�..
// ��Ȯ�� ������ �𸣰�����, �� �޸� ���� ���� �߻��ε�

public class BaekJoon1074Plus {

	// ���� ���� ����
	static long size;
	static long xNumber;
	static long yNumber;
	static int[] xArray = {0, 0, 1, 1};
	static int[] yArray = {0, 1, 0, 1};
;	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp = 0;

		Scanner sc = new Scanner(System.in);
		temp = sc.nextInt();
		size = TwoPower(temp);
		xNumber = sc.nextLong();
		yNumber = sc.nextLong();
		
		System.out.println(finalScore(temp, xNumber, yNumber, 0));
		
	}

	static long finalScore( int size, long x, long y, long start) {

		if(size == 1) {
			for(int i=0; i<4; i++) {
				if( x == xArray[i] && y == yArray[i]) {
					return (start + i);
				}
			}
		}
			if( x <= TwoPower(size-1)-1 && y <= TwoPower(size-1)-1 ) {
				return finalScore(size-1, x, y, start);
			}
			else if( x <= TwoPower(size-1)-1 &&  y>=TwoPower(size-1)) {
				return finalScore(size-1, x, y-TwoPower(size-1), (TwoPower(2*size)/4)+start);
			}
			else if( x >= TwoPower(size-1) &&  y <=TwoPower(size-1)-1) {
				return finalScore(size-1, x-TwoPower(size-1), y, ((TwoPower(size*2)*2)/4)+start);
			}
			else {
				return finalScore(size-1, x-TwoPower(size-1), y-TwoPower(size-1), ((TwoPower(size*2)*3)/4)+start);
			}
	}
	
	
	static long TwoPower(int number) {
		
		long temp = 1;
		for(int i=0; i<number; i++ ) {
			temp = temp*2;
		}
		return temp;
	}
	
}
