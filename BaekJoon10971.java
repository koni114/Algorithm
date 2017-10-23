package fullNavigation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 외판원 순회2 문제
public class BaekJoon10971 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int citySize = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		int[][] cityCost = new int[citySize][citySize];
		int[] cityRoad = new int[citySize];
		
		for(int i = 0 ; i < citySize; i++) {
			cityRoad[i] = i+1;
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			int cnt = 0;
			while(st.hasMoreTokens()) {
				cityCost[i][cnt] = Integer.parseInt(st.nextToken());
				cnt++;
			}
		}
		
		do {
			boolean OK = true;
			int cnt = 0;
			for(int i =0; i<citySize-1; i++) {
				if(cityCost[cityRoad[i]-1][cityRoad[i+1]-1] == 0) OK = false;
				else {
					cnt += cityCost[cityRoad[i]-1][cityRoad[i+1]-1];
				}
			}
			
			if(OK && cityCost[cityRoad[cityRoad.length-1]-1][cityRoad[0]-1] != 0 ) {
				cnt += cityCost[cityRoad[citySize-1]-1][0];
				min = Math.min(min, cnt);
			}
		}while(permuCheck(cityRoad));
		
		System.out.println(min);
		
	}

	private static boolean permuCheck(int[] a) {

		
		int check = a.length-1;
		
		// 1. a[i] > a[i-1] 인 i-1을 찾는다
		
		while(check > 1 && a[check-1] > a[check]) {
			check -= 1;
		}
		
		if(check <= 1) {
			return false;
		}
		// 2. i-1 < j 이고 a[i-1] < a[j] 인 가장 오른쪽에 있는 값 확인
		int j = a.length-1;
        while (a[j] < a[check-1]) {
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

	

}
