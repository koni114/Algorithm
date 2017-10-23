package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon2110 {

	public static void main(String[] args) {

		long checkNumber = 0; // 공유기의 거리 check
		
		
		Scanner sc = new Scanner(System.in);
		// 변수 입력 받음
		// 집의 개수
		// 공유기의 개수
		int houseNumber = sc.nextInt();
		int key = sc.nextInt();
		
		long[] house = new long[houseNumber];
		
		for(int i=0; i<houseNumber; i++) {
			house[i] = sc.nextLong();
		}
		
		Arrays.sort(house);
		finalScore(key, house);
		
	}
	
	static void  finalScore(int key, long[] house) {

		int cnt = key; // key 값과 비교 하기 위한 변수 
		long checkNumber = 0;
		// 찾는 알고리즘 
		// 1번 집부터 시작해, checkNumber 보다 크거나 같은 거리의 집 위치를 찾는다.
		// 찾았으면, cnt++, 찾은 집 위치부터 다시 checkNumber 보다 큰 거리의 집위치 찾는다
		// 이때 cnt값이 key 에 도달 하게 되면, for문 종료 후 다시 checkNumber 
		
		Out:while(cnt >= key){
			checkNumber++;
			int temp = 1;
			int k = 0;
			boolean ok = true;
			
			check:while(ok){
			
			for(int i = k; i<house.length; i++) {
					if(temp == key) continue Out;
					for(int j= i+1; j<house.length; j++) {
						if(dist(house[i], house[j]) >= checkNumber) {
							temp++;
							k = j;
							continue check;
						}
					}
					
			}
			
			cnt = temp;
			ok = false;
			
			}
		}
	
		System.out.println(checkNumber-1);
	}
	
	
	static long dist(long a, long b){
		
		return Math.abs(a - b);
		
		
	}

}
