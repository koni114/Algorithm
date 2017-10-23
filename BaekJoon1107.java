package fullNavigation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1107 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		int brokenSize = Integer.parseInt(br.readLine());
		int[] broken = new int[brokenSize];
		int cnt = 0;
		if(brokenSize != 0) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			while(st.hasMoreTokens()) {
				
				broken[cnt] = Integer.parseInt(st.nextToken());
				cnt++;
			}
		}
		
		goNumber(number, broken);
		
		
	}

	private static void goNumber(int number, int[] broken) {
		
		
		int min = Math.abs(number - 100);
		
		for(int i = 0; i<1000000; i++ ) {
			int cnt = 0;
			if(checkNumber(i, broken)) {
				continue;
			}else {
				cnt += String.valueOf(i).length();
				cnt += Math.abs((number - i));
				if(min > cnt) {
						min = cnt;
				}
			}
		}
		
		System.out.println(min);
	}

	private static boolean checkNumber(int i, int[] broken){
		String temp = String.valueOf(i);
		
		for(int k =0; k<broken.length; k++) {
			for(int n = 0; n < temp.length(); n++) {
				if(broken[k] == Integer.parseInt(temp.substring(n, n+1))) {
					return true;
				}
			}
		}
		return false;
	}
}
