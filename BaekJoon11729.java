package divideAndConquer;

import java.util.Scanner;

public class BaekJoon11729 {

	static int size;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		
		
		System.out.println(hanoiScore(size));
		hanoi(size, 1, 3);
		
	}

	static void hanoi(int size, int start, int end) {
		
		int other = 0;
		
		if(start + end == 3 ) {
			other = 3;
		}else if(start+end == 4) {
			other = 2;
		}else {
			other = 1;
		}
		
		
		if( size ==  3){
			System.out.println(start + " "+ end);
			System.out.println(start + " "+ other);
			System.out.println(end + " " + other);
			System.out.println(start + " "+ end);
			System.out.println(other + " "+ start);
			System.out.println(other + " "+ end);
			System.out.println(start + " "+ end);
		}
		
		if(size == 2) {
		
			System.out.println(start + " "+ other);
			System.out.println(start + " "+ end);
			System.out.println(other + " "+ end);
		}
		
		if(size == 1) {
			System.out.println(start + " "+ end);
		}
		
		if( size > 3){
			
			hanoi(size-1, start, other);
			System.out.println(start + " "+ end);
			hanoi(size-1, other, end);
			
		}
		// N-1 값을 넣은 재귀 함수, 
		
	}
	
	static int hanoiScore(int size) {
		
		 if(size == 1) return 1;
		 else {
			return (hanoiScore(size-1)*2 + 1);
		 }
	}
	
}
