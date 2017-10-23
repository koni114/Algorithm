package heap;

import java.util.Scanner;

	
public class BaekJoon11279 {
	
	static int[] heap = new int[100001];
	static int check = 1;
	
    public static void main(String args[]) {

    	Scanner sc = new Scanner(System.in);
    	int testCase = sc.nextInt();
    	
    	for(int i =0; i<testCase; i++) {
    		int a = sc.nextInt();
    		
    		if(a != 0) {
    			push(a);
    		}else {
    			System.out.println(pop());
    		}
    	}
    	
    }

	private static void push(int a) {

		// �ִ� �� �߰�
		// ���� �� �κп� ���� ���ڸ� �߰�.
		// ���� ���ڿ� parent���� ���� ���ʷ� ���ؼ� a > parent��, swap
		// parent�� child�� �ε��� ���� - child/2 = parent
		
		heap[++check] = a;
		for(int i = check; i> 1; i /= 2) {
			if(heap[i/2] < heap[i]) {
				int temp = heap[i];
				heap[i] = heap[i/2];
				heap[i/2] = temp;
			}else {
				break;
			}
		}
	}
    
	private static int pop() {
		// �ִ� �� ����
		// ���� ���� ��� ��ġ�� ���� ��Ʈ ���� ���� - �ٲܶ� ���� ���� 0���� ����������
		// ������ *2 �� *2+1 ���� ũ�� ����, �ƴϸ� *2�� *2+1�� ���ؼ� �� ū ���� swap
		if(check == 0) {
			return 0;
		}
		int ans = heap[1];
		heap[1] = heap[check];
		heap[check--] = 0;
		
		for(int i =1; i*2 <= check;) {
			if(heap[i] > heap[i*2] && heap[i] > heap[(i*2)+1]) {
				break;
			}
			else {
				if(heap[i*2] > heap[(i*2)+1]) {
					int temp = heap[i*2];
					heap[i*2] = heap[i];
					heap[i] = temp;
					i =  i*2;
				}else { 
					int temp = heap[(i*2)+1];
					heap[(i*2)+1] = heap[i];
					heap[i] = temp;
					i =  (i*2)+1;
				}
			}
		}
		
		return ans;
	}
    
    
}