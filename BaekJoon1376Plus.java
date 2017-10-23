package fullNavigation; 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 차이를 최대로 문제
public class BaekJoon1376Plus {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		int[] a = new int[size];
		int cnt = 0;
		int max = 0;
		String line = br.readLine();
		
		StringTokenizer st = new StringTokenizer(line, " ");
		
		while(st.hasMoreTokens()) {
			a[cnt] = Integer.parseInt(st.nextToken());
			cnt++;
		}
		
		Arrays.sort(a);
	
		do {
			max = Math.max(max, calc(a));
		}while(permuCheck(a, max));
		
		System.out.println(max);
	}

	private static boolean permuCheck(int[] a, int max) {

		boolean desCheck = true;
		int pivot = 0;
		int temp = 0;
	
		// 1. a[i] > a[i-1] 인 i-1을 찾는다
		for(int i=a.length-1; i>=1; i--) {
			if( a[i] >= a[i-1]) {
				pivot = i-1;
				desCheck = false;
				break;
			}
		}
		
		if(desCheck) {
			return false;
		}
		
		// 2. i-1 < j 이고 a[i-1] < a[j] 인 가장 오른쪽에 있는 값 확인
		int pivot2 = a.length-1;
        while (a[pivot2] <= a[pivot]) {
        	pivot2 -= 1;
        }
		
		// 3. i-1 값과 j값을 swap
        temp = a[pivot];
		a[pivot] = a[pivot2];
		a[pivot2] = temp;
		
		// 4. i번째 부터 reverse
		pivot2 = a.length-1;
        while (pivot+1 < pivot2) {
            temp = a[pivot+1];
            a[pivot+1] = a[pivot2];
            a[pivot2] = temp;
            pivot += 1;
            pivot2 -= 1;
        }
		
		return true;
	}

	private static int calc(int[] a) {
		
		int cnt = 0;
		
		for(int i =0; i<a.length-1; i++) {
			cnt += Math.abs(a[i] - a[i+1]);
		}
		
		return cnt;
	}

	
}
