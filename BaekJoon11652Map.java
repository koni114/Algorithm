package sort;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class BaekJoon11652Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
		
		
		// TreeMap에 초기값 입력 -> key값에 따라서 자동으로 정렬
		// 만약 TreeMap에 기존 값이 있으면, value++ , 아니면  (key, 1) 값 입력
		for(int i=0; i<size; i++) {
			long temp = sc.nextLong();
			if(map.containsKey(temp)) {
				int cnt = map.get(temp);
				cnt++;
				map.put(temp, cnt);
			}else {
				map.put(temp, 1);
			}
		}
		int maxValue = 0;
		long maxNumber = 0;
		// Iterator 를 통해 최대값 찾기
		Iterator<Long> it = map.keySet().iterator();
		while(it.hasNext()) {
			long temp = it.next();
			if ( maxValue < map.get(temp)) {

				maxNumber = temp;
				maxValue = map.get(temp);
			}
		}
		System.out.println(maxNumber);
	}

}
