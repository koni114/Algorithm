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

		// 최대 힙 추가
		// 제일 끝 부분에 먼저 숫자를 추가.
		// 넣은 숫자와 parent와의 값을 차례로 비교해서 a > parent면, swap
		// parent와 child의 인덱스 차이 - child/2 = parent
		
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
		// 최대 힙 제거
		// 제일 낮은 노드 위치의 수와 루트 값과 변경 - 바꿀때 지울 값은 0으로 변경해주자
		// 변경후 *2 와 *2+1 보다 크면 종료, 아니면 *2와 *2+1과 비교해서 더 큰 값과 swap
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