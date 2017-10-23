package unionFind;

import java.util.ArrayList;
import java.util.Scanner;

// ���̷��� ����
// 1. DFS�� Ǯ���
// 2. UnionFind�� Ǯ���
public class BeakJoon2606 {
	
	static ArrayList<Integer>[] list;
	static boolean[] check;
	static int cnt;
	
	public static void main(String[] args) {

		// �Է� �ޱ�
		Scanner sc = new Scanner(System.in);
		int computerSize = sc.nextInt();
		int nodeSize = sc.nextInt();
		
		// ���� ����
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
		// dfs �˻� �˰��� ����
		// list[i] �� ���� �ִ� ��� üũ.
		// 1�� ��ǻ�Ϳ� ����Ǿ� �ִ� �� �ѹ��� üũ�ϸ� ����
		
			for(int n=0; n < list[i].size(); n++ ) {
				if( check[list[i].get(n)] != true ) {
					finalScore(list[i].get(n));
					cnt++;
				}
			}
			
		return cnt;
		
	}
}
