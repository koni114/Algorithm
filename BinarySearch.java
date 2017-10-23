package sort;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {

		// �̺� Ž�� 
		// ���ĵǾ� �ִ� ����Ʈ���� � ���� ������ ã�� �˰���
		// ����Ʈ�� ũ�⸦ N �̶�� ���� �� lgN ��ŭ�� �ð��� �ɸ���
		
		// 100���� ���� �Է� �ް�, Ư�� ��(key)�� �ִ��� �������� �̺� Ž���� �̿��� ã�ƺ���
		int[] binarySearch = new int[100];
		
		for(int i=0; i<100; i++) {
			binarySearch[i] = (int)(Math.random()*100)+1;
		}
		
		Arrays.sort(binarySearch);
		
		// �̺� Ž�� �˰��� �ڵ� ����
		// ��� �Լ��� ���� -> �Ű� ��: ���� ��, �� ��, key ��, �迭 4��
		int key = 47;
		System.out.println(binary(0, 99, key, binarySearch));
		
	}
	
	static boolean binary(int start, int end, int key, int[] binarySearch) {
		
		if(start > end) return false;
		
		// mid ���� �����
		int mid = (start + end) / 2;
		
		// ����  binary[mid] == key ������ true ����
		// binary[mid] < key �̸�  mid -> start�� ����
		// binary[mid] > key �̸�  mid -> end�� ����
		if(binarySearch[mid] == key) {
			return true; 
		}else {
			if(binarySearch[mid] < key) {
				return binary(mid-1, end, key, binarySearch);
			}else {
				return binary(start, mid+1, key, binarySearch);
			}
		}
	}

}
