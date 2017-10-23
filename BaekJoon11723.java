package fullNavigation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11723 {

	static StringBuilder sb = new StringBuilder(); 
	static int check = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(in.readLine());
		
		for(int i=0; i<testCase ; i++ ) {
			
			String line =in.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			
			while(st.hasMoreTokens()) {
				String temp = st.nextToken();
				
				if(temp.equals("all") || temp.equals("empty")) {
					finalScore(temp, 0);
					break;
				}
				finalScore(temp, Integer.parseInt(st.nextToken()));
			}
		}
		System.out.println(sb);
		
	}
	
	static void finalScore(String temp, int value) throws IOException {
		
		
		switch(temp) {
		
		case"add":{
			check  = (check | (1 << value));
			break;
				  }
		case"remove":{
			check = (check & ~(1 << value));
			break;
		}
		case"check":{
			if((check & (1 << value)) == (1 << value)) {
				sb.append(1+ "\n");
				break;
			}else {
				sb.append(0+ "\n");
				break;
			}
		}
		case"toggle":{
			if((check & (1 << value)) == (1 << value)) {
				check = (check & ~(1 << value));
				break;
			}else {
				check  = (check | (1 << value));
				break;
			}
		}
		case"all":{
			check = ((1 << 21)-1);
			break;
		}
		case"empty":{
			check = 0;
			break;
		}
		}
	}

}
