package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BaekJoon2667 {
	// 멤버 변수
	// 1. 좌표에 해당하는 값이 0인지, 1인지 확인하는 배열
	// 2. 총 단지의 개수 count
	// 3. 갔다왔는지, 아닌지 check하기 위한 배열
	
	static int[][] house;
	static int cnt;
	static boolean[][] check;
	static ArrayList<Integer> list;
	static int complexSize;
	
	public static void main(String[] args) {
		int count = 0;
		
		Scanner sc = new Scanner(System.in);
		complexSize = sc.nextInt();
		sc.nextLine();
		list = new ArrayList<Integer>();
		house = new int[complexSize+1][complexSize+1];
		check = new boolean[complexSize+1][complexSize+1];

		for(int i=1; i<=complexSize; i++) {
			String line;
			 line = sc.nextLine();
			 for(int j=0; j<complexSize; j++) {
				 house[i][j+1] = Integer.parseInt(line.substring(j, j+1));
			 }
		}
		
		for(int i=1; i<=complexSize; i++) {
			for(int j=1; j<=complexSize; j++) {
				if(!check[i][j] && house[i][j] == 1 ) {
					cnt++;
					finalScore(i, j);
				}
			}
		}
		Collections.sort(list);
		System.out.println(cnt);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	static void finalScore(int i, int j){
		// 변수 선언
		// 1. 단지 내 집의 개수 count 변수
		// 2. BFS에 필요한 queue
		int houseNumber = 1;
		Queue<Integer> queue = new LinkedList<Integer>();
		check[i][j] = true;
		
		// BFS 실시
		queue.offer(i);
		queue.offer(j);
		
		while(!queue.isEmpty()) {
		
			int x = queue.poll();
			int y = queue.poll();
			// 상 하 좌 우에 1이 있는지 탐색 
		
			if(x+1 <= complexSize && house[x+1][y] == 1 && !check[x+1][y]) {
				houseNumber++;
				queue.offer(x+1);
				queue.offer(y);
				check[x+1][y] = true;
			}
			if( x-1 > 0 && house[x-1][y] == 1 && !check[x-1][y]){
				houseNumber++;
				queue.offer(x-1);
				queue.offer(y);
				check[x-1][y] = true;
			}	
			if(y+1 <= complexSize && house[x][y+1] == 1 && !check[x][y+1]){
				houseNumber++;
				queue.offer(x);
				queue.offer(y+1);
				check[x][y+1] = true;
			}
			if(y-1 > 0 && house[x][y-1] == 1 && !check[x][y-1]){
				houseNumber++;
				queue.offer(x);
				queue.offer(y-1);
				check[x][y-1] = true;
			}
			// 만약 1이 있고, check 값이 true가 아니면, q에 추가 -> houseNumber++
		}
		
		list.add(houseNumber);
		
	}

}
