package unionFind;

import java.util.ArrayList;
import java.util.Scanner;

// 바이러스 문제
// 1. DFS로 풀어보기
// 2. UnionFind로 풀어보기
public class BeakJoon2606 {
	
	static ArrayList<Integer>[] list;
	static boolean[] check;
	static int cnt;
	
	public static void main(String[] args) {

		// 입력 받기
		Scanner sc = new Scanner(System.in);
		int computerSize = sc.nextInt();
		int nodeSize = sc.nextInt();
		
		// 변수 선언
		list = new ArrayList[computerSize+1];
		check = new boolean[computerSize+1];
		
		for(int i=0; i<=computerSize; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<nodeSize; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list[a].add(b);
			list[b].add(a);
			
		}
		
		System.out.println(finalScore(1));
	}

	static int finalScore(int i) {
		
		check[i] = true;
		// dfs 검색 알고리즘 구현
		// list[i] 로 갈수 있는 노드 체크.
		// 1번 컴퓨터와 연결되어 있는 곳 한번만 체크하면 무방
		
			for(int n=0; n < list[i].size(); n++ ) {
				if( check[list[i].get(n)] != true ) {
					finalScore(list[i].get(n));
					cnt++;
				}
			}
			
		return cnt;
		
	}
}
