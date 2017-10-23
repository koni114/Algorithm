package graph;

import java.util.Scanner;

public class BaekJoon11724 {

	static int[][] edgeNumber;
	static boolean[] check;
	static int nodeSize;
	static int edgeSize;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		nodeSize  = sc.nextInt();
		edgeSize = sc.nextInt();
		
		check = new boolean[nodeSize];
		
		
		edgeNumber = new int[nodeSize][nodeSize];
		
		for(int i=0; i<edgeSize; i++) {

			int a =sc.nextInt();
			int b =sc.nextInt();
			
			edgeNumber[a-1][b-1] = 1;
			edgeNumber[b-1][a-1] = 1;
		}

		finalScore();
		
	}

	static void finalScore() {
		
		// 변수 선언
		int component = 0;
		for(int i=0; i<nodeSize; i++) {
			if( check[i] == false) {
				component += 1;
				dfs(i);
			}
		}
		System.out.println(component);
	}
	
	static void dfs(int number) {
		if(check[number]) return;
		check[number] = true;
		for(int i=0; i<nodeSize; i++) {
			if(check[i] == false && edgeNumber[number][i] == 1) {
				dfs(i);
			}
		}
		
	}
}
