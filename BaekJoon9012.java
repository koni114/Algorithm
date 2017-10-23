package stackqueue;

import java.util.Scanner;

public class BaekJoon9012 {

	static String[] check;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine();
		Outter:for(int i =0; i<testCase; i++) {
			
			String line = sc.nextLine().trim();
		
			int cnt = line.length();
			check = new String[cnt];
			
			for(int j=0; j<cnt; j++) {
				check[j] = line.substring(j, j+1);
			}

			int right = 0;
			int number = 0;
			while( number < cnt){
				String temp = check[number];
				if(temp.equals("(")) {
					right++;
				}else {
					right--;
					if(right < 0) {
						System.out.println("NO");
						continue Outter;
					}
				}
				number++;
			}
			if(right > 0) {
				System.out.println("NO");
				continue;
			}else {
				System.out.println("YES");
			}
		}
	}
}
