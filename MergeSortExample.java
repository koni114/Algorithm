package sort;

import java.util.Arrays;

public class MergeSortExample {

	
	public static void main(String[] args) {

		// ���� ��Ʈ �����ϱ�
		// 10���� ���� ����(1~10)�� �Է� �޾� ���� ��Ʈ�� �̿��ϱ�
		int[] array = new int[10];
		
		for(int i=0; i<10; i++) {
			array[i] = (int)(Math.random()*10)+1;
		}
		
		// ���� ��Ʈ �Լ� ����
		// ���� ���� ���� �� �ε��� �Ű� ������ �Է�
		
		System.out.println(Arrays.toString(array));
		mergeSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	
	}

	static void mergeSort(int[] array, int start, int end) {
		
		if(start == end ) return;
		int mid = (start + end) / 2 ;
		// ���� ����
		mergeSort(array, start, mid);
		mergeSort(array, mid+1, end);
		
		// ���� ����
		combine(array, start, mid, end);
		
	}
	
	static void combine(int[] array, int start, int mid, int end) {
		
		int i, j, k, t;
		i = start; 
		j = mid+1; 
		k = 0;     
		int[] sorted = new int[end-start+1];
		
		// 1�ܰ�
		// �� �κ��� �迭�� ���� �� �ε����� ���� �ϳ��� ��
		while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
            	sorted[k] = array[i++];
            }else{
            	  sorted[k] = array[j++];
            }
            k++;
        }

		if (i > mid) {
            for (t = j; t <= end; t++, k++) {
            	 sorted[k] = array[t];
            }
        } else {
            for (t = i; t <= mid; t++, k++) {
            	sorted[k] = array[t];
            }
        }
 
        for (t = start; t <= end; t++)
        	array[t] = sorted[t-start];
	
	
	}
	}

