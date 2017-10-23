package fullNavigation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 다음 순열 구하기
public class BaekJoon10972 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력 부분
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 int size = Integer.parseInt(br.readLine());
		 int[] permuArray = new int[size];
		 int pivot = 0;
		 int pivot2 = 0;
		 boolean OK = true;
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line, " ");
		int cnt = 0;
		
		while(st.hasMoreTokens()) {
			permuArray[cnt] = Integer.parseInt(st.nextToken());
			cnt++;
		}
		
		// 알고리즘 단계
		// 1. a[i] > a[i-1]인 i-1값을 찾는다
		for(int i = size-1; i >= 1; i--) {
			pivot = i-1;
			if( permuArray[i-1] < permuArray[i] ) {
				OK = false;
				break;
			}
		}
		
		// 전부 내림차순인 경우,
		if(OK) {
			System.out.println(-1);
			return;
		}
		
		// 2. i-1 < j && a[i-1] < a[j] 이면서 최대인 j값을 찾는다
		for(int j = pivot+1; j<size; j++) {
			if( permuArray[pivot] < permuArray[j]) {
				pivot2 = j;
			}
		}
		
		// 3. a[i-1] 과 a[j]를 swap 한다
		swap(pivot, pivot2, permuArray);
		// 4. a[i] 부터 뒤집는다

		int check = ((size-1)-pivot)/2;
		for(int i = pivot+1, k = size-1; i<= pivot+check; i++, k--) {
			
			int temp = 0;
			temp = permuArray[i];
			permuArray[i] = permuArray[k];
			permuArray[k] = temp;
			
		}
		
		for(int i =0; i<size; i++) {
			sb.append(permuArray[i] + " ");
		}
		
		System.out.println(sb);
		
		
		
		
	}

	private static void swap(int pivot, int pivot2, int[] permuArray) {

		int temp = 0;
		temp = permuArray[pivot];
		permuArray[pivot] = permuArray[pivot2];
		permuArray[pivot2] = temp;
	}

	

}
