package divideAndConquer;

import java.util.Scanner;

// ��Ÿ�� ���� �߻�..
// ��Ȯ�� ������ �𸣰�����, �� �޸� ���� ���� �߻��ε�

public class BaekJoon1074 {

	// ���� ���� ����
	static int size;
	static int xNumber;
	static int yNumber;
	static int[][] zNumber;
	static int[] xArray = {0, 0, 1, 1};
	static int[] yArray = {0, 1, 0, 1};
;	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp = 0;

		Scanner sc = new Scanner(System.in);
		temp = sc.nextInt();
		size = TwoPower(temp);
		zNumber = new int[size][size];
		xNumber = sc.nextInt();
		yNumber = sc.nextInt();
		
		finalScore(temp, 0, 0, 0);
		System.out.println(zNumber[xNumber][yNumber]);
		
	}

	static void finalScore(int size, int x, int y, int start) {

		
		
		// n ũ�Ⱑ 1�� ���� �ٷ� ���ڸ� �Է��ϸ� ��
		if(size == 1) {
			for( int i=0; i<4; i++) {
				zNumber[x+xArray[i]][y+yArray[i]] = start+i;
			}
		}
		
		// n >= 2�� ��� 4���� ���� ������ ��� ȣ��
		// size n-1
		if(size >= 2) {
			
			finalScore(size-1, x, y, start);
			finalScore(size-1, x, TwoPower(size-1)+y, (TwoPower(2*size)/4)+start);
			finalScore(size-1, TwoPower(size-1)+x, y, ((TwoPower(2*size)*2)/4)+start);
			finalScore(size-1, TwoPower(size-1)+x, TwoPower(size-1)+y, ((TwoPower(2*size)*3)/4)+start);
		}
	}
	
	
	
	static int TwoPower(int number) {
		
		int temp = 1;
		for(int i=0; i<number; i++ ) {
			temp = temp*2;
		}
		return temp;
	}
	
}
