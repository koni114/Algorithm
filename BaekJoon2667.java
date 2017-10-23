package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BaekJoon2667 {
	// ��� ����
	// 1. ��ǥ�� �ش��ϴ� ���� 0����, 1���� Ȯ���ϴ� �迭
	// 2. �� ������ ���� count
	// 3. ���ٿԴ���, �ƴ��� check�ϱ� ���� �迭
	
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
		// ���� ����
		// 1. ���� �� ���� ���� count ����
		// 2. BFS�� �ʿ��� queue
		int houseNumber = 1;
		Queue<Integer> queue = new LinkedList<Integer>();
		check[i][j] = true;
		
		// BFS �ǽ�
		queue.offer(i);
		queue.offer(j);
		
		while(!queue.isEmpty()) {
		
			int x = queue.poll();
			int y = queue.poll();
			// �� �� �� �쿡 1�� �ִ��� Ž�� 
		
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
			// ���� 1�� �ְ�, check ���� true�� �ƴϸ�, q�� �߰� -> houseNumber++
		}
		
		list.add(houseNumber);
		
	}

}
