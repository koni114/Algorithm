package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BaekJoon1707 {

	static ArrayList<Integer>[] list;
	static int[] check;
	static boolean ok;
	
	public static void main(String[] args) {
		
		// �׽�Ʈ ���̽� ���� �־���
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		// �׽�Ʈ ���̽� ������ŭ for loop
		for(int i=0; i<testCase; i++) {
			int nodeSize = sc.nextInt();
			int edgeSize = sc.nextInt();
			int color = 2;
			ok = true;
			
			list = new ArrayList[nodeSize+1];
			check = new int[nodeSize+1];
			
			
			for(int j=1; j<=nodeSize; j++) {
				list[j] = new ArrayList<Integer>();
			}

			for(int k=0; k<edgeSize; k++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				list[a].add(b);
				list[b].add(a);
			}
			
			for(int n =1; n<=nodeSize; n++) {
				if (check[n] == 0 && list[n].size() != 0 ) {
				bipartite(n,color);
				}
				}
			
		
			for(int r = 1; r<=nodeSize; r++ ) {
			for(int y : list[r]) {
				if(check[y] == check[r]) {
					ok = false;
				}
				}
		}
		if(ok) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
			
		}
		// 
	}
	
	static void bipartite(int startNode ,int color) {
		
		// �ʱⰪ ����
		// Node 1�� check -> 1
		check[startNode] = 3-color;
		
		// list ��� 1�� �迭 �� Ȯ��. check�� 0�̸� bipartite ȣ��, �ƴϸ� pass
		for(int y :list[startNode]) {
			if(check[y] == 0 ) {
				bipartite(y,3-color);
		}
	}
	}
}



 