package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BaekJoon1260Review {

	static int nodeSize;
	static int edgeSize;
	static int startNode;
	static boolean[] check;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		nodeSize = sc.nextInt();
		edgeSize = sc.nextInt();
		startNode = sc.nextInt();
		
		list = new ArrayList[nodeSize+1];
		check = new boolean[nodeSize+1];
		
		// list �ʱ�ȭ
		for(int i=1; i<=nodeSize; i++) {
			list[i] = new ArrayList<Integer>();
			check[i] = false;
		}
		// ���� �� �Է� ����
		for(int i=0; i<edgeSize; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=1; i<=nodeSize; i++){
			Collections.sort(list[i]);
		}
		
		dfs(startNode);
		System.out.println("");
		check = new boolean[nodeSize+1];
		bfs(startNode);
		
	}

	static void dfs(int startNode) {
		if(check[startNode] == true) return;
		check[startNode] = true;
		System.out.print(startNode + " ");
		Stack<Integer> stack = new Stack<Integer>();
		
		int currentNode = startNode;
		stack.push(startNode);
		
		Outter:while(!stack.isEmpty()) {
			
			for(int i=0; i<list[currentNode].size(); i++) {
				int temp = (int)list[currentNode].get(i);
				if(!check[temp]) {
					System.out.print(temp + " ");
					stack.push(temp);
					currentNode = temp;
					check[temp] = true;
					continue Outter;
				}
			}
			stack.pop();
			if(stack.size() != 0 )currentNode = stack.lastElement();
			// 1. ���� ��忡�� �� �� �ִ� ���� ����
			// 2. �� �� �ִ� �������� ��� true �� stack.pop, �ƴϸ� check false �� �� �߿� ���� �� ���� ����. 
			// 3. ���� ������ �̵�.
			// 4. �̵� ������, check �� true �� ����, stack.push ����
			
		}
		
	}
	
	static void bfs(int startNode) {
	
		check[startNode] = true;
		System.out.print(startNode + " ");
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int currentNode = startNode;
		queue.offer(startNode);
		
		while(!queue.isEmpty()) {
			
			// queue.front�� ���� ���� Ȯ��
			// ���� check[queue.front] �� false�� queue ���� �߰� -> �̶� check �� true �� ����, and ���, 
			// ���� ���� ������ ��� true �̸�, ���� �߰� ���� �ʿ� ����
			// queue.front �� ����
			
			for(int i=0; i<list[currentNode].size(); i++) {
				int temp = (int)list[currentNode].get(i);
				if(!check[temp]) {
					queue.offer(temp);
					check[temp] = true;
					System.out.print(temp+ " ");
				}
				}
			if(queue.size() != 0) queue.poll();
			if(queue.size() != 0) currentNode = queue.peek();
		}
		}
	}

