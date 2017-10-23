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
		
		// list 초기화
		for(int i=1; i<=nodeSize; i++) {
			list[i] = new ArrayList<Integer>();
			check[i] = false;
		}
		// 간선 값 입력 받음
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
			// 1. 현재 노드에서 갈 수 있는 간선 조사
			// 2. 갈 수 있는 간선에서 모두 true 면 stack.pop, 아니면 check false 인 값 중에 작은 값 부터 조사. 
			// 3. 작은 값으로 이동.
			// 4. 이동 했으면, check 값 true 로 변경, stack.push 수행
			
		}
		
	}
	
	static void bfs(int startNode) {
	
		check[startNode] = true;
		System.out.print(startNode + " ");
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int currentNode = startNode;
		queue.offer(startNode);
		
		while(!queue.isEmpty()) {
			
			// queue.front의 간선 값을 확인
			// 만약 check[queue.front] 가 false면 queue 값에 추가 -> 이때 check 값 true 로 변경, and 출력, 
			// 만약 다음 간선이 모두 true 이면, 따로 추가 해줄 필요 없다
			// queue.front 값 제거
			
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

