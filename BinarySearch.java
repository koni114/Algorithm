package sort;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {

		// 이분 탐색 
		// 정렬되어 있는 리스트에서 어떤 값을 빠르게 찾는 알고리즘
		// 리스트의 크기를 N 이라고 했을 때 lgN 만큼의 시간이 걸린다
		
		// 100개의 값을 입력 받고, 특정 값(key)이 있는지 없는지를 이분 탐색을 이용해 찾아보자
		int[] binarySearch = new int[100];
		
		for(int i=0; i<100; i++) {
			binarySearch[i] = (int)(Math.random()*100)+1;
		}
		
		Arrays.sort(binarySearch);
		
		// 이분 탐색 알고리즘 코딩 구현
		// 재귀 함수로 구현 -> 매개 값: 시작 값, 끝 값, key 값, 배열 4개
		int key = 47;
		System.out.println(binary(0, 99, key, binarySearch));
		
	}
	
	static boolean binary(int start, int end, int key, int[] binarySearch) {
		
		if(start > end) return false;
		
		// mid 값을 만든다
		int mid = (start + end) / 2;
		
		// 만약  binary[mid] == key 같으면 true 리턴
		// binary[mid] < key 이면  mid -> start로 변경
		// binary[mid] > key 이면  mid -> end로 변경
		if(binarySearch[mid] == key) {
			return true; 
		}else {
			if(binarySearch[mid] < key) {
				return binary(mid-1, end, key, binarySearch);
			}else {
				return binary(start, mid+1, key, binarySearch);
			}
		}
	}

}
