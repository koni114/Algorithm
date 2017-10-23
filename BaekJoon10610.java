package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 30
public class BaekJoon10610 {

	public static void main(String[] args) {

		
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		boolean OK = false;
		int size = line.length();
		int[] check = new int[size+1];
		int number = 0;
		String finalScore = "";
		
		// ��ü�� ���� 3�� ������� Ȯ�� �ϱ� ���� ����
		
		for(int i=1; i<=size; i++) {
			check[i] = Integer.parseInt(String.valueOf(line.charAt(i-1)));
			number += check[i];
		}
		
		for(int i=1; i<=size; i++) {
			if(number % 3 == 0 && check[i] == 0) {
				OK = true;
				Arrays.sort(check);
				
			}
		}
		
		
		if(OK){
			for(int j=line.length(); j>=1; j--) {
				finalScore += check[j];
			}
		}
		
		if(finalScore.equals("")) {
			System.out.println(-1);
		}else {
			System.out.println(finalScore);
		}
	}
}
