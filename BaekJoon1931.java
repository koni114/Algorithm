package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BaekJoon1931 {
	
	//�ڷ� ����
	// int[][] ������ �迭 �� Comparator�� �迭 ����
	// (x, y)���� ������, y���� ���� ���� �������� ������, y���� ������ x�� ���� �������� ���� ���� 	
	static int[][] confTime;
	static int confSize;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		confSize = sc.nextInt();
		
		confTime = new int[confSize+1][2];
		
		for(int i=1; i<=confSize; i++){
			
			confTime[i][0] = sc.nextInt();
			confTime[i][1] = sc.nextInt();
			
		}
		sc.close();
		sortArray(confTime);
		classAssignment();
	}

	static void sortArray(int[][] array ) {
		
		Arrays.sort(array, new Comparator<int[]>(){

			@Override
			public int compare(int[] array1, int[] array2) {
				// 1. [][1] ���� ���� ����
				if(((Comparable<Integer>)array1[1]).compareTo(array2[1]) > 0) return 1;
				else if(((Comparable<Integer>)array1[1]).compareTo(array2[1]) == 0) {
					if(((Comparable<Integer>)array1[0]).compareTo(array2[0]) > 0) return 1;
					else return -1;
				}
				else return -1;
			}
			
		});
		
	}
	
	
	static void classAssignment(){
		int cnt = 1;
		int checkTime = confTime[1][1];
		
		// 1. ���� ���� ������ ȸ�� �ð��� Ȯ��
		// 2. ���� ���� ������ ȸ�� �ð��� Ȯ���ؼ� �ռ� ȸ�� �ð��� ���� �ð��� ���۽ð��� �� �� 
		//    ���� �� ���� �ð��̶�� Ok, �ƴϸ� no
		for(int i=2; i<=confSize; i++){
			if( confTime[i][0] >= checkTime){
				checkTime = confTime[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
