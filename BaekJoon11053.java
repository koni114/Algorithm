package dynamicProgramming;
import java.util.Scanner;


public class BaekJoon11053 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int arraySize = scanner.nextInt();
		int[] arrayValue = new int[arraySize+1];
		for(int k = 1; k < arraySize + 1; k++){
			arrayValue[k] = scanner.nextInt();
		}
		scanner.close();

		int[] score = new int[arraySize+1];
		int max = 1;
		
		for(int i=1; i<arraySize+1; i++) {
			score[i] = 1;
			for(int j=1; j<i; j++) {
				if(arrayValue[i] > arrayValue[j] && score[i] < score[j]+1) {
					score[i] = score[j] + 1;
					if(max < score[i] ) max = score[i];
				}
			}
		}
		System.out.print(max);
	}
}