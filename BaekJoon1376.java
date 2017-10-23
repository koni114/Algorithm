package fullNavigation;

import java.util.Scanner;

// 날짜 계산
// E S M 이 주어짐
public class BaekJoon1376 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int e = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		
		calc(e, s, m);
		
	}
	
	static void calc(int e, int s, int m) {
		int checkE = 1;
		int checkS = 1;
		int checkM = 1;
		int cnt = 1;
		
		while(checkE != e || checkS != s || checkM != m) {
			
			if(checkE == 15) {
				checkE = 1;
			}else {
				checkE++;
			}
			
			if(checkS == 28) {
				checkS = 1;
			}else {
				checkS++;
			}
			
			if(checkM == 19) {
				checkM = 1;
			}else {
				checkM++;
			}
			
			cnt++;
		}
		
		System.out.println(cnt);
	}
}

