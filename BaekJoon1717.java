package unionFind;

import java.util.Scanner;

public class BaekJoon1717 {

	static int[] parent;
	
	public static void main(String[] args) {

		// �Է� �ޱ�
		// n, m
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // node�� ��
		int m = sc.nextInt(); // �Է����� �־��� ���� ����
		
		// ���� ����
		parent = new int[n+1];
		
		// ���� �ʱ�ȭ
		for(int i=0; i<n+1; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i<m; i++) {
			int check = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(check == 0) {
				Union(a,b);
			}else {
				checkParents(a, b);
			}
		}
	}

	static void checkParents(int a, int b) {

		System.out.println("");
		if(find(a) == find(b)){ 	 // ó������ parent[a] == parent[b] �� �߾��µ� Ʋ�Ƚ��ϴٰ� ������.
			System.out.print("YES"); // �翬�� ���! �� ������ ���� �������� �� �ķ� find�Լ��� �ѹ� �� �ҷ��� parent[] ���� root�� ����Ǵµ�, 
		}else {						 // Union�� �� �� �ٷ� check�� ���� �Ǹ� Ʋ�� ���� ����
			System.out.print("NO");
		}
	}

	static void Union(int a, int b) {

		int x = find(a);
		int y = find(b);
		
		parent[y] = x;
	}

	private static int find(int a){

		if(parent[a] == a) {
			return a;
		}else {
			return parent[a] = find(parent[a]);
		}
	}
}
