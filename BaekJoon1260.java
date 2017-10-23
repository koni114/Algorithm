package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//DFS와 BFS
// 인접 리스트를 통해 풀어보기
public class BaekJoon1260 {
	// 변수 선언
	static ArrayList<Integer>[] list;
	static int nodeSize; // node의 수
	static int edgeSize; // edge의 수
	static int startNode; // 시작 노드
	static boolean[] check;

	static public void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		nodeSize = sc.nextInt();
		edgeSize = sc.nextInt();
		startNode = sc.nextInt();
	
		list = new ArrayList[nodeSize+1];
		// node 수 만큼 arrayList 선언
		for(int i=1; i<=nodeSize; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		// edge 값 입력
		for(int i=0; i<edgeSize; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		
		// 작은 순서대로 정렬
		for(int i=1; i<=nodeSize; i++) {
			Collections.sort(list[i]);
		}
		
		check = new boolean[nodeSize+1];
		dfs(startNode);
		System.out.println(" ");
		check = new boolean[nodeSize+1];
		bfs(startNode);
	
	}

	static void dfs(int startNode) {
		if(check[startNode]) return;
		check[startNode] = true;
		
		System.out.print(startNode+ " ");
		
		for(int y : list[startNode]) {
			if(check[y] == false) {
				dfs(y);
			}
		}
	}
	
	static void bfs(int startNode) {
		Queue queue = new LinkedList<Integer>();
		
		// q에 값 넣음
		queue.offer(startNode);
		check[startNode] = true;
		
		// q에 해당하는 Edge 값을 찾아서 check 배열 true로 변경
		while(!queue.isEmpty()) {

			int k = (int)queue.remove();
			System.out.print(k+" ");
			for(int y : list[k]) {
				if(check[y] == false) {
					check[y] = true;
					queue.offer(y);
				}
			}
		}
		
		
	}
	
}
