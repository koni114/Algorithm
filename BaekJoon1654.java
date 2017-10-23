package binarySearch;

import java.util.Scanner;

public class BaekJoon1654 {

	static long number = 1;
	static int count = 0;
	// 랜선 자르기
	public static void main(String[] args) {
		
		long max = 0;
		
		Scanner sc = new Scanner(System.in);
		int lanNumber = sc.nextInt(); // 이미 가지고 있는 랜선의 개수 최대 10000
		long lanNeed = sc.nextLong();   // 필요한 랜선의 개수
		
		long[] lan = new long[lanNumber+1];
		
		for(int i=1; i<=lanNumber; i++) {
				lan[i] = sc.nextLong();
				max = Math.max(lan[i], max);
				
		}
		
		lanOptimal(1, max, lanNeed, lan);
		System.out.println(finalCheck(number, lan));
		
	}
	
	static void lanOptimal(long start, long end, long key, long[] lan) {
		
		if(start > end) return;
	
		long mid = (start + end) / 2;
		
		if( start <= end) {
			
				if( keyCheck(mid, lan) >= key) {
					number = Math.max(mid, number);
					lanOptimal(mid+1, end, key, lan);
				}else {
					lanOptimal(start, mid-1, key, lan);
				}
		}
	}

	static long keyCheck(long key, long[] lan) {
		
		long cnt = 0;
		
		for(int i=1; i<=lan.length-1; i++){
			if(lan[i] != 0) {
				if(key != 0) {
					cnt += lan[i] / key;
				}
			}
		}
		return cnt;
	}
	
	
	static long finalCheck(long key, long[] lan) {
		
		boolean OK = true;
		
		while(OK) {
			if(keyCheck(key, lan) != keyCheck(key+1, lan)) {
				OK = false;
			}else {
				key++;
			}
		}
		
		return key;
	}
	
}
