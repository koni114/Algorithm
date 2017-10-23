package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// 弥家 赛 备泅 -> priorityQueue肺 备泅
public class BaekJoon11279Plus {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		
		
		for(int i=0; i<testCase; i++) {
			
			int a = sc.nextInt();
			if(a == 0) {
				if(!pq.isEmpty()) {
					System.out.println(pq.poll());
				}else {
					System.out.println(0);
				}
			}else {
				pq.add(a);
			}
			
		}
		
	}

}
