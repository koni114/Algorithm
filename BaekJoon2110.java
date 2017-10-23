package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon2110 {

	public static void main(String[] args) {

		long checkNumber = 0; // �������� �Ÿ� check
		
		
		Scanner sc = new Scanner(System.in);
		// ���� �Է� ����
		// ���� ����
		// �������� ����
		int houseNumber = sc.nextInt();
		int key = sc.nextInt();
		
		long[] house = new long[houseNumber];
		
		for(int i=0; i<houseNumber; i++) {
			house[i] = sc.nextLong();
		}
		
		Arrays.sort(house);
		finalScore(key, house);
		
	}
	
	static void  finalScore(int key, long[] house) {

		int cnt = key; // key ���� �� �ϱ� ���� ���� 
		long checkNumber = 0;
		// ã�� �˰��� 
		// 1�� ������ ������, checkNumber ���� ũ�ų� ���� �Ÿ��� �� ��ġ�� ã�´�.
		// ã������, cnt++, ã�� �� ��ġ���� �ٽ� checkNumber ���� ū �Ÿ��� ����ġ ã�´�
		// �̶� cnt���� key �� ���� �ϰ� �Ǹ�, for�� ���� �� �ٽ� checkNumber 
		
		Out:while(cnt >= key){
			checkNumber++;
			int temp = 1;
			int k = 0;
			boolean ok = true;
			
			check:while(ok){
			
			for(int i = k; i<house.length; i++) {
					if(temp == key) continue Out;
					for(int j= i+1; j<house.length; j++) {
						if(dist(house[i], house[j]) >= checkNumber) {
							temp++;
							k = j;
							continue check;
						}
					}
					
			}
			
			cnt = temp;
			ok = false;
			
			}
		}
	
		System.out.println(checkNumber-1);
	}
	
	
	static long dist(long a, long b){
		
		return Math.abs(a - b);
		
		
	}

}
