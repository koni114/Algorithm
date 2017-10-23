package fullNavigation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon1697 {

	static boolean[] check = new boolean[200001];
	static int[] dist = new int[200001];
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int subin = sc.nextInt();
		int brother = sc.nextInt();
		
		bfsCheck(subin, brother);
		
	}

	static void bfsCheck(int subin, int brother) {
		
		// ����
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(subin);
		
		check[subin] = true;
		dist[subin] = 0;
		
		// while �� �̿�
		// queue.pop
		// x+1, x-1, 2x�� �ش��ϴ� ��ġ�� check
		// false �� true�� �ϰ� queue�� ����. 
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			if(temp == brother) {
				System.out.println(dist[temp]);
				break;
			}
			
			if(temp*2 <= 200000 && check[temp*2] != true) {
				check[temp*2] = true;
				queue.add(temp*2);
				dist[temp*2] = dist[temp] +1;
			}
			

			if(temp+1 <= 200000 && check[temp+1] != true) {
				check[temp+1] = true;
				queue.add(temp+1);
				dist[temp+1] = dist[temp] +1;
			}
			
			if( temp-1 >= 0 &&check[temp-1] != true) {
				check[temp-1] = true;
				queue.add(temp-1);
				dist[temp-1] = dist[temp] +1;
			}
			
		}
	}
	

}
