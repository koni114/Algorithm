package binarySearch;

import java.util.Scanner;

public class BaekJoon2805 {
	// ���� �ڸ��� 
	static long maxOptimal = 0;
	
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		// ������ ��, ������ ����(optimal) �� �Է� ����
		int treeNumber = sc.nextInt();
		long key = sc.nextLong();
		
		// ���� ����
		// 1. ������ ������ ���� �ش��ϴ� ���� ���� �Է� �迭 ����
		long[] tree = new long[treeNumber];
		long max = 0;
		long left = 0;
		long right = 1;
		
		for(int i=0; i<treeNumber; i++) {
			tree[i] = sc.nextLong();
			max = Math.max(tree[i], max);
		}
		
		right = max;
		
		// �Լ��� �Ű��� ����. while ���� �̿�
		// ��� �˰���: ���� Ž��, ��� �Լ��� ����
		// �ʿ��� �Ű���
		// optimal, left, right, tree �迭
		treeOptimal(key, left, right-1, tree);
		System.out.println(maxOptimal);
	}
	
	static void treeOptimal(long key, long left, long right, long[] tree) {
		
		// l �� r���� Ŀ���� ���� -> �ѹ��� �����غ���
		while( left <= right) {
			long mid = (left+right) / 2;
		
			if(check(mid, tree) >= key) {
				maxOptimal = Math.max(mid, maxOptimal);
				left = mid+1;				
			}else {
				right = mid-1;
			}
		}
		
	}
	
	static long check(long mid, long[] tree) {
		
		long cnt = 0;
		// key ���� ���ϱ� ���� �Լ�
		
		for(int i=0; i<tree.length; i++) {
			if(tree[i] - mid >=0) {
				cnt += tree[i] - mid;
			}
		}
		return cnt;
	}

}
