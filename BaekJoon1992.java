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
		// array가 int[1][1] 이면, 그수를 그냥 리턴
		if(length == 1) return String.valueOf(check);
		
		// 만약 모든 수가 같은 수라면, 그 수를 리턴
		if(allInOne(array)) {
			return String.valueOf(check);
		}
		
		// 만약 같은 수가 아니라면, 4등분 한 array 값을 다시 붙여, 재귀
		// 1. 먼저 4개의 배열을 다시 생성
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
