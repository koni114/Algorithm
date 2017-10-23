package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon2178 {
	
	static int height;
	static int width;
	static int[][] puzzle;
	static boolean [][] check;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();
		width = sc.nextInt();
		sc.nextLine();
		
		puzzle = new int[height+1][width+1];
		check = new boolean[height+1][width+1];
		
		for(int i=1; i<= height; i++){
			String line = sc.nextLine().trim();
			for(int j=1; j<=width; j++) {
				puzzle[i][j] = Integer.parseInt(line.substring(j-1, j));
			}
		}
		
		puzzleTest();
		
	}
	
	static void puzzleTest() {
		// 1. ������ (1,1)�� �ʱ�ȭ, BFS ����
		// 2. BFS�� �ʿ��� queue ����
		// 3. shortestPath cnt ����
		// 4. ��, ��, ��, �츦 ��Ÿ���� ���� x,y �迭 ����
		int i= 1;
		int j= 1;
		int cnt = 0;
		check[1][1] = true;
		
		int[] temp = new int[3];
		temp[0] = 1;
		temp[1] = 1;
		temp[2] = 1;
		Queue<Object> queue = new LinkedList<Object>();
		int[] xPlus = {0, 0, -1, 1};
		int[] yPlus = {1, -1, 0, 0};
		
		queue.offer(temp);
		
	
		
		while(!queue.isEmpty()) {
			
			// �� �ܰ��� ���� ���� ���� �߿�
			int[] count = (int[])queue.poll();
			int x = count[0];
			int y = count[1];
			int number = count[2];
			
			if( x == height && y == width ) {
				System.out.println(number);
				
				return;
			}
			
			for(i=0; i<4; i++){
				 int ax = x+ xPlus[i];
				 int ay = y+ yPlus[i];
				if(ax> 0 && ax<= height && ay>0 && ay<=width) {
						if(puzzle[ax][ay] == 1 && !check[ax][ay]) {
							int[] add = new int[3];
							add[0] = ax;
							add[1] = ay;
							add[2] = number + 1;
							queue.offer(add);
							check[ax][ay] = true;
						}
				}
			}

			
		}
		
		
	}
	
}
