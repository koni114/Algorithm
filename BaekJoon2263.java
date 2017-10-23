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
		// �ο��� ����, �� �� �ʱ�ȭ
		// ����Ʈ���� ����, �� �� �ʱ�ȭ
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
		
		//1. ����Ʈ ������ �� �� -> ��Ʈ�� ã�´�
		root = postorder[postEnd];
		System.out.print(root+" ");
		
		// 2. �ο������� ��Ʈ�� ��ġ�� ã�´�
		rootIndex = position[root];
		
		// 3. ��Ʈ�� �ε��� - �ο��� ���� ��ġ 
		//    �ο��� �� ��ġ - ��Ʈ�� �ε���
		int left = rootIndex - inStart;
			freeOrder(inStart, rootIndex-1, postStart, postStart+left-1);
			freeOrder(rootIndex+1, inEnd, postStart+left, postEnd-1);
		
	}
}
