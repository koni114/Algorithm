package divideAndConquer;

import java.util.Scanner;

public class BaekJoon1992 {

	static int size;
	static int[][] quadTree;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		sc.nextLine();
		
		
		quadTree = new int[size+1][size+1];
		
		for(int i=1; i<=size; i++) {
			String line = sc.nextLine();
			for(int j=1; j<=size; j++) {
				quadTree[i][j] = Integer.parseInt(line.substring(j-1, j));
			}
				}
		
		System.out.println(finalScore(quadTree));
		
	}

	static String finalScore(int[][] array) {
		
		int check = array[1][1];
		int length = array.length-1;
		// array�� int[1][1] �̸�, �׼��� �׳� ����
		if(length == 1) return String.valueOf(check);
		
		// ���� ��� ���� ���� �����, �� ���� ����
		if(allInOne(array)) {
			return String.valueOf(check);
		}
		
		// ���� ���� ���� �ƴ϶��, 4��� �� array ���� �ٽ� �ٿ�, ���
		// 1. ���� 4���� �迭�� �ٽ� ����
		// length
		int nextSize = length/2;
		int[][] array1 = new int[nextSize+1][nextSize+1];
		int[][] array2 = new int[nextSize+1][nextSize+1];
		int[][] array3 = new int[nextSize+1][nextSize+1];
		int[][] array4 = new int[nextSize+1][nextSize+1];
		
		for(int i = 1; i<=nextSize; i++){
			for(int j = 1; j<=nextSize; j++) {
				array1[i][j] = array[i][j];
				array2[i][j] = array[i][nextSize+j];
				array3[i][j] = array[nextSize+i][j];
				array4[i][j] = array[nextSize+i][nextSize+j];
			}
		}
		
		return "("+ finalScore(array1)+ finalScore(array2)+finalScore(array3)+finalScore(array4)+ ")";
		
		
	}
	
	static boolean allInOne(int[][] array) {
		
		boolean OK = true;
		int check = array[1][1];
		
		for(int i= 1; i<=array.length-1; i++) {
			for(int j=1; j<=array.length-1; j++) {
				if(check != array[i][j]) {
					OK = false;
				}
			}
		}
		
		return OK;
	}
	
}
