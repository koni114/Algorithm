package sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {

		// 머지 소트 정렬 코딩
		// 정렬 전 5개의 1~10사이의 수 값 받음
		int[] merge = new int[5];
		
		for(int i=0; i<5; i++) {
			merge[i] = (int)(Math.random()*10)+1;
		}
		// 정렬 전 숫자 출력
		System.out.println(Arrays.toString(merge));
		
		// 머지 소트 수행
		mergeSort(merge, 0, merge.length-1);
		System.out.println(Arrays.toString(merge));
		
		
	}
	
	static void mergeSort(int[] merge, int start, int end) {
		
		if(start == end) return;
		
		int mid = (start + end) / 2;
		mergeSort(merge, start, mid);
		mergeSort(merge, mid+1, end);
		mergeCombine(merge, start, mid, end);
		
	}
	
	static void mergeCombine(int[] merge, int start, int mid, int end) {

		int i, j, k, t;
		i = start; 
		j = mid+1; 
		k = 0;     
		int[] sorted = new int[end-start+1];
		
		// 1단계
		// 두 부분의 배열의 가장 앞 인덱스를 서로 하나씩 비교
		while (i <= mid && j <= end) {
            if (merge[i] <= merge[j]) {
            	sorted[k] = merge[i++];
            }else{
            	  sorted[k] = merge[j++];
            }
            k++;
        }

		if (i > mid) {
            for (t = j; t <= end; t++, k++) {
            	 sorted[k] = merge[t];
            }
        } else {
            for (t = i; t <= mid; t++, k++) {
            	sorted[k] = merge[t];
            }
        }
 
        for (t = start; t <= end; t++)
        	merge[t] = sorted[t-start];
	}

}
