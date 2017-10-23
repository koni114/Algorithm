package math;

import java.util.ArrayList;

// 에라토스테네스의 체
public class Eratosthenes {

	public static void main(String[] args) {

		// 1. 1~100 사이의 소수를 구하고 싶을 때,
		// ArrayList 이용
		// - 1~100까지의 수를 list에 넣음
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// - 1~100까지 i for loop를 통해 값을 집어 넣음 
		for(int i=2; i<=100; i++) {
			list.add(i);
		}
		
		// - 2~sqrt(100)까지 for loop을 통해,
		// 만약  해당 i값이 list에 존재하면, 그 값은 소수이므로, 그 값을 제외한 나머지 나눠지는 수를 제거.
		for( int i = 2; i<= Math.sqrt(100); i++) {
			if(list.contains(i)){
				for(int j = 2; j*i <= 100; j++){
					if(list.contains(j*i)){
						list.remove(list.indexOf(i*j));
					}
				}
			}
		}
		
		System.out.println(list.size());
	}
}
