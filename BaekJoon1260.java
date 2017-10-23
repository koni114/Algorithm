package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//DFS�� BFS
// ���� ����Ʈ�� ���� Ǯ���
public class BaekJoon1260 {
	// ���� ����
	static ArrayList<Integer>[] list;
	static int nodeSize; // node�� ��
	static int edgeSize; // edge�� ��
	static int startNode; // ���� ���
	static boolean[] check;

	static public void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		nodeSize = sc.nextInt();
		edgeSize = sc.nextInt();
		startNode = sc.nextInt();
	
		list = new ArrayList[nodeSize+1];
		// node �� ��ŭ arrayList ����
		for(int i=1; i<=nodeSize; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		// edge �� �Է�
		for(int i=0; i<edgeSize; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		
		// ���� ������� ����
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
		
		// q�� �� ����
		queue.offer(startNode);
		check[startNode] = true;
		
		// q�� �ش��ϴ� Edge ���� ã�Ƽ� check �迭 true�� ����
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
