package sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		// 버블 정렬 코딩 해보기
		// 1. 정렬되지 않은 5개의 랜덤 숫자 입력
		int[] bubble = new int[5];
		
		for(int i=0; i<5; i++) {
			bubble[i] = (int)(Math.random()*10)+1;
		}
		// 정렬 전 값 확인
		System.out.println(Arrays.toString(bubble));
		
		// 버블 소트 수행 --> o(N^2)
		
		for(int i=0; i<bubble.length; i++) {
			for(int j=0; j<bubble.length-1; j++) {
				if(bubble[j] > bubble[j+1]) {
					int temp = bubble[j];
					bubble[j] = bubble[j+1];
					bubble[j+1] = temp;
				}
			}
		}
		
		// 정렬 후 확인
		System.out.println(Arrays.toString(bubble));
	}

}
