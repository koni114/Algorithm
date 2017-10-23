package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class BaekJoon9466 {

	static int studentSize;
	static int[] student;
	static int[] check;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		// testCase
		for(int i=0; i< testCase; i++) {
			
			studentSize = sc.nextInt();
			student = new int[studentSize+1];
			check = new int[studentSize+1];
			int cnt = 0;
			
			for(int j=1; j<=studentSize; j++ ) {
				student[j] = sc.nextInt();
			}
			
			for(int k = 1; k<=studentSize; k++) {
				if(student[k] == k) {
					check[k] =  k;
				}
			}
			
			for(int k = 1; k<=studentSize; k++) {
				if(check[k] == 0) {
					termProject(k);	
				}
			}
			
			for(int n = 1; n<=studentSize; n++) {
				if(check[n] == 0) cnt++;
			}
			
			System.out.println(cnt);
		}
		
		
		
	}

	// o(N^2) --> 시간 초과
	static void termProject(int k) {
	
		// 선언
		int number = k;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		while(true) {
			if(check[k] ==  0) {
				list.add(k);
				check[k] = k;
				k = student[k];
			}else if(check[k] == number) {
				for(int i : list) {
					check[i] = number;
				}
					return;
			}else {
				for(int i : list) {
					check[i] = 0;
				}
				return;
			}
		}
	}
}
