package sort;

import java.util.Arrays;

public class MergeSortExample {

	
	public static void main(String[] args) {

		// 머지 소트 연습하기
		// 10개의 랜덤 숫자(1~10)를 입력 받아 머지 소트를 이용하기
		int[] array = new int[10];
		
		for(int i=0; i<10; i++) {
			array[i] = (int)(Math.random()*10)+1;
		}
		
		// 머지 소트 함수 구현
		// 시작 값과 종료 값 인덱스 매개 변수로 입력
		
		System.out.println(Arrays.toString(array));
		mergeSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	
	}

	static void mergeSort(int[] array, int start, int end) {
		
		if(start == end ) return;
		int mid = (start + end) / 2 ;
		// 분할 과정
		mergeSort(array, start, mid);
		mergeSort(array, mid+1, end);
		
		// 병합 과정
		combine(array, start, mid, end);
		
	}
	
	static void combine(int[] array, int start, int mid, int end) {
		
		int i, j, k, t;
		i = start; 
		j = mid+1; 
		k = 0;     
		int[] sorted = new int[end-start+1];
		
		// 1단계
		// 두 부분의 배열의 가장 앞 인덱스를 서로 하나씩 비교
		while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
            	sorted[k] = array[i++];
            }else{
            	  sorted[k] = array[j++];
            }
            k++;
        }

		if (i > mid) {
            for (t = j; t <= end; t++, k++) {
            	 sorted[k] = array[t];
            }
        } else {
            for (t = i; t <= mid; t++, k++) {
            	sorted[k] = array[t];
            }
        }
 
        for (t = start; t <= end; t++)
        	array[t] = sorted[t-start];
	
	
	}
	}

