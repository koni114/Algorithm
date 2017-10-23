package divideAndConquer;

import java.util.Scanner;

public class BaekJoon1517 {

	static long cnt;
	
	public static void main(String[] args) {

		cnt = 0;
		Scanner sc = new Scanner(System.in);
		int size  = sc.nextInt();
		long[] bubble = new long[size];
		
		for(int i=0; i<size; i++) {
			bubble[i] = sc.nextLong();
		}
		
		swapCheck(bubble, 0, bubble.length-1);
		System.out.println(cnt);
		
	}

	static void swapCheck(long[] bubble, int start, int end) {
		
		if(start == end) return;
		int mid = (start + end) / 2;
		
		swapCheck(bubble , start, mid);
		swapCheck(bubble , mid+1, end);
		swapCombine(bubble, start, mid, end);
		
	}
	
	static void swapCombine(long[] bubble, int start, int mid, int end) {
		int i, j, k, t;
		int cntCheck = mid-start+1;
		
		i = start; 
		j = mid+1; 
		k = 0;     
		long[] sorted = new long[end-start+1];
		
		while (i <= mid && j <= end) {
            if (bubble[i] <= bubble[j]) {
            	sorted[k] = bubble[i++];
            	cntCheck--;
            }else{
            	  sorted[k] = bubble[j++];
            	  cnt += cntCheck;
            }
            k++;
        }

		if (i > mid) {
            for (t = j; t <= end; t++, k++) {
            	 sorted[k] = bubble[t];
            }
        } else {
            for (t = i; t <= mid; t++, k++) {
            	sorted[k] = bubble[t];
            }
        }
 
        for (t = start; t <= end; t++)
        	bubble[t] = sorted[t-start];
	}
	
}
