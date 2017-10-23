package tree;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BaekJoon1991 {

	static int treeSize;
	static String[][] tree;
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		treeSize = sc.nextInt();
		sc.nextLine();
		tree = new String[treeSize+1][3];
		
		for(int i =0; i<treeSize; i++) {
			String line = sc.nextLine();
			StringTokenizer st = new StringTokenizer(line ," ");
			for(int j=0; j<3; j++) {
				tree[i+1][j] =  st.nextToken();
			}
		}
		
		System.out.println(preOrder("A"));
		System.out.println(inOrder("A"));
		System.out.println(postOrder("A"));
	}

	
	static String preOrder(String node) {
	
		String temp = "";
		// ��� �湮
		temp += node;
		
		// ���� ���� ���� �ǽ�
		for(int i = 1; i<=treeSize; i++) {
			if(tree[i][0].equals(node)){
				if(!tree[i][1].equals(".")){
					temp += preOrder(tree[i][1]);
				}if(!tree[i][2].equals(".")) {
					temp += preOrder(tree[i][2]);
				}
			}
		}
		
		return temp;
		
	}
	static String inOrder(String node) {
		
		String temp = "";
		
		for(int i = 1; i<=treeSize; i++) {
			if(tree[i][0].equals(node)){
				// ���� �ο��� �ǽ�
				if(!tree[i][1].equals(".")){
					temp += inOrder(tree[i][1]);
				}
				// ��� �湮
				temp += node;
				
				// ������ �ο��� �ǽ�
				if(!tree[i][2].equals(".")) {
					temp += inOrder(tree[i][2]);
				}
			}
		}
		return temp;
	}
	
static String postOrder(String node) {
		
		String temp = "";
		
		
		for(int i = 1; i<=treeSize; i++) {
			if(tree[i][0].equals(node)){
				// ���� ����Ʈ ���� �ǽ�
				if(!tree[i][1].equals(".")){
					temp += postOrder(tree[i][1]);
				}
				
				// ������ ����Ʈ ���� �ǽ�
				if(!tree[i][2].equals(".")) {
					temp += postOrder(tree[i][2]);
				}
				
				// ��� �湮
				temp += node;
			}
		}
		return temp;
	}
	
}
