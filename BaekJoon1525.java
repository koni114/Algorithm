package fullNavigation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 퍼즐
public class BaekJoon1525 {

	static HashMap<String, Integer> map;
	static ArrayList<Integer>[] move;
	static String endLine = "123456780";
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String line = "";
		
		// 이동할 수 있는 경우의 수 setting
		map = new HashMap<String, Integer>();
		moveSetting();
		
		// 입력값 받음
		for(int i=0; i<9; i++) {
			line += String.valueOf(sc.nextInt());
		}
		
		//
		finalScore(line);
	}

	static void finalScore(String line) {
		
		map.put(line, 0);
		Queue<String> queue = new LinkedList<String>();
		queue.add(line);
		
		while(!queue.isEmpty()) {
			String temp = queue.poll();
			
			if(temp.equals(endLine)) {
				System.out.println(map.get(endLine));
				return;
			}
			
			ArrayList<String> nextLine = new ArrayList<String>();
			nextLine = change(temp);
			for(int i=0; i<nextLine.size(); i++) {
				if(!map.containsKey(nextLine.get(i))){
					queue.add(nextLine.get(i));
					map.put(nextLine.get(i), map.get(temp) +1 );
				}
			}
			
		}
		
		System.out.println(-1);
		
	}
	
	
	private static ArrayList<String> change(String temp) {

		int checkNumber = 0;
		ArrayList<String> next = new ArrayList<String>();
		
		for(int i=0; i<temp.length(); i++) {
			if(temp.substring(i, i+1).equals("0")) {
				checkNumber = i;
			}
		}
		
		for( int i=0; i<move[checkNumber].size(); i++) {
			int changeNumber = move[checkNumber].get(i);
			StringBuffer sb = new StringBuffer(temp);
			char a = sb.charAt(changeNumber);
			sb.setCharAt(changeNumber, '0');
			sb.setCharAt(checkNumber, a);
			next.add(String.valueOf(sb));
		}
		
		return next;
	}


		
		

	static void moveSetting() {
		
		move = new ArrayList[9];
		for(int i=0; i<move.length; i++) {
			move[i] = new ArrayList<Integer>();
		}
		
		move[0].add(1);
		move[0].add(3);
		
		move[1].add(0);
		move[1].add(2);
		move[1].add(4);
		
		move[2].add(1);
		move[2].add(5);
		
		move[3].add(0);
		move[3].add(4);
		move[3].add(6);
		
		move[4].add(1);
		move[4].add(3);
		move[4].add(5);
		move[4].add(7);
		
		move[5].add(2);
		move[5].add(4);
		move[5].add(8);
		
		move[6].add(3);
		move[6].add(7);
		
		move[7].add(4);
		move[7].add(6);
		move[7].add(8);
		
		move[8].add(5);
		move[8].add(7);
	}
	
	
	
}
