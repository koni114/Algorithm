package fullNavigation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 소수 경로
public class BaekJoon1963 {

	static ArrayList<Integer> primeNumber = new ArrayList<Integer>();
	static boolean[] check;
	static int[] dist;
	public static void main(String[] args) {

		// 먼저 1000~9999사이의 소수 값을 만듬.
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		primeCheck();
		
		
		for(int i=0; i<testCase; i++) {
			
			check = new boolean[10001];
			dist = new int[10001];
			
			int startNumber = sc.nextInt();
			int finalNumber = sc.nextInt();
			
			finalScore(startNumber, finalNumber);
		}
		
		
	}
	
	
	static void finalScore(int startNumber, int finalNumber) {

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startNumber);
		dist[startNumber] = 0;
		
		// 시작값 queue.add()
		while(!queue.isEmpty()) {
			
			int temp = (int)queue.poll();
			
			if(temp == finalNumber) {
				System.out.println(dist[temp]);
				return;
			}
			
			for(int i = 0; i<4; i++) {
				for(int n = 0; n <= 9; n++ ) {
					int next = changeNumber(temp, i, n);
					if(next != -1 && check[next] == false && primeNumber.contains(next)) {
						check[next] = true;
						queue.add(next);
						dist[next] = dist[temp]+ 1;
					}
				}
			}
		}
		
		// 시작값에서 바꿀 수 있는 모든 경우의 수 -> 소수인지 check & check: false이면 queue에 집어넣음
		System.out.println("Impossible");
		
	}

	
	static int changeNumber(int temp, int i, int n) {

		if(i == 0 && n == 0) return -1;
		// temp 숫자의 i(0,1,2,3)째 숫자를 n으로 변경,
		// 만약 변경 불가능한 경우 -1 리턴
		String line = String.valueOf(temp);
		StringBuilder sb = new StringBuilder(line);
		sb.setCharAt(i, String.valueOf(n).charAt(0));
		if(line.equals(sb.toString())) {
			return -1;
		}else {
			return Integer.parseInt(sb.toString());
		}
	}




	static void primeCheck() {
		
		// 에라토스테네스의 체로 소수 값 만들기
		
		// list에 1000~9999까지의 값을 넣음
		for(int i=1000; i<=9999; i++) {
			primeNumber.add(i);
		}
		
		// 
		for(int i = 2; i<= 100; i++) {
			for(int j = 10; j*i <= 10000; j++){
				if(primeNumber.contains(j*i)){
					primeNumber.remove(primeNumber.indexOf(i*j));
				}
			}
		}
		
	}

}
