package binarySearch;

import java.util.Scanner;

public class BaekJoon2805 {
	// 나무 자르기 
	static long maxOptimal = 0;
	
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		// 나무의 수, 나무의 길이(optimal) 값 입력 받음
		int treeNumber = sc.nextInt();
		long key = sc.nextLong();
		
		// 변수 선언
		// 1. 각각의 나무의 수에 해당하는 나무 길이 입력 배열 선언
		long[] tree = new long[treeNumber];
		long max = 0;
		long left = 0;
		long right = 1;
		
		for(int i=0; i<treeNumber; i++) {
			tree[i] = sc.nextLong();
			max = Math.max(tree[i], max);
		}
		
		right = max;
		
		// 함수로 매개값 전달. while 구문 이용
		// 사용 알고리즘: 이진 탐색, 재귀 함수로 구현
		// 필요한 매개값
		// optimal, left, right, tree 배열
		treeOptimal(key, left, right-1, tree);
		System.out.println(maxOptimal);
	}
	
	static void treeOptimal(long key, long left, long right, long[] tree) {
		
		// l 이 r보다 커지면 종료 -> 한번더 생각해보자
		while( left <= right) {
			long mid = (left+right) / 2;
		
			if(check(mid, tree) >= key) {
				maxOptimal = Math.max(mid, maxOptimal);
				left = mid+1;				
			}else {
				right = mid-1;
			}
		}
		
	}
	
	static long check(long mid, long[] tree) {
		
		long cnt = 0;
		// key 값과 비교하기 위한 함수
		
		for(int i=0; i<tree.length; i++) {
			if(tree[i] - mid >=0) {
				cnt += tree[i] - mid;
			}
		}
		return cnt;
	}

}
