package divideAndConquer;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class BaekJoon2263 {

	static int size;
	static int[] inorder;
	static int[] postorder;
	static int[] position;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 인오더 시작, 끝 값 초기화
		// 포스트오더 시작, 끝 값 초기화
		int inStart = 1;
		int inEnd = 0;
		int postStart = 1;
		int postEnd = 0;
		
		
		
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		
		inEnd = size;
		postEnd = size;
		
		inorder = new int[size+1];
		postorder = new int[size+1];
		position = new int[size+1];
		
		for(int i=1; i<=size; i++) {
			int a =  sc.nextInt();
			inorder[i] = a;
			position[a] = i;
		}
		
		for(int i=1; i<=size; i++) {
			postorder[i] = sc.nextInt();
		}
		 
		freeOrder(inStart, inEnd, postStart, postEnd);
	}

	static void freeOrder(int inStart, int inEnd, int postStart, int postEnd) {

		if(inStart > inEnd || postStart > postEnd) return;
		
		int root = 0;
		int rootIndex = 0;
		
		//1. 포스트 오더의 끝 값 -> 루트를 찾는다
		root = postorder[postEnd];
		System.out.print(root+" ");
		
		// 2. 인오더에서 루트의 위치를 찾는다
		rootIndex = position[root];
		
		// 3. 루트의 인덱스 - 인오더 시작 위치 
		//    인오더 끝 위치 - 루트의 인덱스
		int left = rootIndex - inStart;
			freeOrder(inStart, rootIndex-1, postStart, postStart+left-1);
			freeOrder(rootIndex+1, inEnd, postStart+left, postEnd-1);
		
	}
}
