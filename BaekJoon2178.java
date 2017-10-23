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
		// 1. 시작점 (1,1)로 초기화, BFS 적용
		// 2. BFS에 필요한 queue 선언
		// 3. shortestPath cnt 선언
		// 4. 상, 하, 좌, 우를 나타내기 위한 x,y 배열 선언
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
			
			// 총 단계의 수를 세는 것이 중요
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
