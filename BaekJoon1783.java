package greedy;

import java.util.Scanner;

// ���� �� 
public class BaekJoon1783 {

	static int height; // ������ ũ��
	static int width; // ������ ũ��
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();
		width = sc.nextInt();
		
		// n = 1 OR m = 1 �̸� 1
		if(height == 1 || width == 1) {
			System.out.println(1);
			return;
		}
		
		if(height == 2 && width == 2) {
			System.out.println(1);
			return;
		}
		if(height == 2){
			if( 4 > (width+1) / 2) {
				System.out.println((width+1)/2);
				return;
			}else {
				System.out.println(4);
				return;
			}
		}
	
		if( width < 7) {
			
			if( 4 > width) {
				System.out.println(width);
				return;
			}else {
				System.out.println(4);
				return;
			}
		}
		
		
		System.out.println(width-2);
		// n = 2 OR m = 2 �̸� = 2
		
		
		
	}

}
