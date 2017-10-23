package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BaekJoon1931 {
	
	//자료 구조
	// int[][] 이차원 배열 후 Comparator로 배열 정의
	// (x, y)값이 있을때, y값을 먼저 오름 차순으로 정렬후, y값이 같으면 x값 오름 차순으로 정렬 구현 	
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
				// 1. [][1] 값은 오름 차순
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
		
		// 1. 제일 빨리 끝나는 회의 시간을 확인
		// 2. 다음 빨리 끝나는 회의 시간을 확인해서 앞선 회의 시간의 종료 시간과 시작시간을 비교 후 
		//    끝난 후 시작 시간이라면 Ok, 아니면 no
		for(int i=2; i<=confSize; i++){
			if( confTime[i][0] >= checkTime){
				checkTime = confTime[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
