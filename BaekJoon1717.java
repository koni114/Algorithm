package unionFind;

import java.util.Scanner;

public class BaekJoon1717 {

	static int[] parent;
	
	public static void main(String[] args) {

		// 입력 받기
		// n, m
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // node의 수
		int m = sc.nextInt(); // 입력으로 주어진 연산 개수
		
		// 변수 선언
		parent = new int[n+1];
		
		// 변수 초기화
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
		if(find(a) == find(b)){ 	 // 처음에는 parent[a] == parent[b] 로 했었는데 틀렸습니다가 나왔음.
			System.out.print("YES"); // 당연한 결과! 그 이유는 만약 합집합을 한 후로 find함수를 한번 더 불러야 parent[] 값에 root가 저장되는데, 
		}else {						 // Union을 한 뒤 바로 check를 들어가게 되면 틀린 값이 나옴
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
