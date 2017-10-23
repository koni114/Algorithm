package sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		// ���� ���� �ڵ� �غ���
		// 1. ���ĵ��� ���� 5���� ���� ���� �Է�
		int[] bubble = new int[5];
		
		for(int i=0; i<5; i++) {
			bubble[i] = (int)(Math.random()*10)+1;
		}
		// ���� �� �� Ȯ��
		System.out.println(Arrays.toString(bubble));
		
		// ���� ��Ʈ ���� --> o(N^2)
		
		for(int i=0; i<bubble.length; i++) {
			for(int j=0; j<bubble.length-1; j++) {
				if(bubble[j] > bubble[j+1]) {
					int temp = bubble[j];
					bubble[j] = bubble[j+1];
					bubble[j+1] = temp;
				}
			}
		}
		
		// ���� �� Ȯ��
		System.out.println(Arrays.toString(bubble));
	}

}
