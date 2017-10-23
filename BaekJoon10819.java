package fullNavigation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// ���̸� �ִ�� ����
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
		
		// 1. a[i] > a[i-1] �� i-1�� ã�´�
		
		while(check > 0 && a[check-1] >= a[check]) {
			check -= 1;
		}
		
		if(check <= 0) {
			return false;
		}
		// 2. i-1 < j �̰� a[i-1] < a[j] �� ���� �����ʿ� �ִ� �� Ȯ��
		int j = a.length-1;
        while (a[j] <= a[check-1]) {
            j -= 1;
        }

        
		// 3. i-1 ���� j���� swap
		int temp = a[check-1];
		a[check-1] = a[j];
		a[j] = temp;
		
		// 4. i��° ���� reverse
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
