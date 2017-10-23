package divideAndConquer;

import java.util.Scanner;

public class BaekJoon11728 {

	static int[] array1;
	static int[] array2;
	
	static int arraySize1;
	static int arraySize2;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		arraySize1 = sc.nextInt();
		arraySize2 = sc.nextInt();
		
		array1 = new int[arraySize1+1];
		array2 = new int[arraySize2+1];
		
		for(int i=1; i<=arraySize1; i++) {
			array1[i] = sc.nextInt();
		}
		
		for(int i=1; i<=arraySize2; i++) {
			array2[i] = sc.nextInt();
		}
		mergeSort();
	}

	
	static void mergeSort() {
		
		int[] array = new int[arraySize1 + arraySize2 + 1];
		int i =1;
		int j =1;
		int k =1;
		// i�� j ���� �� �߿� �ϳ��� ������ while �� ����
		while( i<= arraySize1 && j<= arraySize2) {
			if(array1[i] > array2[j]) {
				array[k] = array2[j];
				k++;
				j++;
			}else {
				array[k] = array1[i];
				i++;
				k++;
			}
			
		}
		
		// ������ ���� �ִ� ���� array �迭�� �� �־���.
		// �̶� �̹� ������ �Ǿ������Ƿ� ���ʴ�� �־���
		while( i <=arraySize1) {
			array[k] = array1[i];
			k++;
			i++;
		}
		
		while( j <= arraySize2) {
			array[k] = array2[j];
			k++;
			j++;
		}
		
		// array �� ���
		for(int n=1; n<=array.length-1; n++) {
			System.out.print(array[n]+ " ");
		}
		
		
	}
}
