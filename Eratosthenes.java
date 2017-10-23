package math;

import java.util.ArrayList;

// �����佺�׳׽��� ü
public class Eratosthenes {

	public static void main(String[] args) {

		// 1. 1~100 ������ �Ҽ��� ���ϰ� ���� ��,
		// ArrayList �̿�
		// - 1~100������ ���� list�� ����
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// - 1~100���� i for loop�� ���� ���� ���� ���� 
		for(int i=2; i<=100; i++) {
			list.add(i);
		}
		
		// - 2~sqrt(100)���� for loop�� ����,
		// ����  �ش� i���� list�� �����ϸ�, �� ���� �Ҽ��̹Ƿ�, �� ���� ������ ������ �������� ���� ����.
		for( int i = 2; i<= Math.sqrt(100); i++) {
			if(list.contains(i)){
				for(int j = 2; j*i <= 100; j++){
					if(list.contains(j*i)){
						list.remove(list.indexOf(i*j));
					}
				}
			}
		}
		
		System.out.println(list.size());
	}
}
