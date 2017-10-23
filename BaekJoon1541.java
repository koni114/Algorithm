package greedy;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BaekJoon1541 {

	static int[] number;
	static String[] operation;
	
	// ÀÒ¾î¹ö¸° °ýÈ£ ¹®Á¦
	public static void main(String[] args) {

		int cnt = 1;
		int finalNumber = 0;
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		StringTokenizer st = new StringTokenizer(line, "-|+");
		int size = st.countTokens();
		number = new int[size+1];
		operation = new String[size];
		
		for(int i=1; i<=size; i++) {
			number[i] += Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<line.length(); i++) {
			String temp = line.substring(i, i+1);
			if(temp.equals("+")) {
				operation[cnt] = "+";
				cnt++;
			}else if(temp.equals("-")) {
				operation[cnt] = "-";
				cnt++;
			}
		}
		
		int start = size;
		
		for(int j=1; j<=size-1; j++) {
			if(operation[j].equals("-")) {
				start = j;
				break;
			}
		}
		
		for(int i =1; i<=start; i++) {
			finalNumber += number[i];
		}
		
		for(int i= start+1; i<=size; i++) {
			finalNumber -= number[i];
		}
		
		System.out.println(finalNumber);
	}

}
