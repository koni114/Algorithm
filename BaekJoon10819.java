package fullNavigation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 차이를 최대로 문제
public class BaekJoon10819 {

	public static void main(String[] args) throws NumberFormatException, IOException{

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
		}while(permuCheck(a));
		
		System.out.println(max);
	}

	private static boolean permuCheck(int[] a) {

		
		int length = a.length;
		int check = a.length-1;
		
		// 1. a[i] > a[i-1] 인 i-1을 찾는다
		
		while(check > 0 && a[check-1] >= a[check]) {
			check -= 1;
		}
		
		if(check <= 0) {
			return false;
		}
		// 2. i-1 < j 이고 a[i-1] < a[j] 인 가장 오른쪽에 있는 값 확인
		int j = a.length-1;
        while (a[j] <= a[check-1]) {
            j -= 1;
        }

        
		// 3. i-1 값과 j값을 swap
		int temp = a[check-1];
		a[check-1] = a[j];
		a[j] = temp;
		
		// 4. i번째 부터 reverse
		 j = a.length-1;
	        while (check < j) {
	            temp = a[check];
	            a[check] = a[j];
	            a[j] = temp;
	            check += 1;
	            j -= 1;
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
