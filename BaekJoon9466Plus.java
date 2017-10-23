package graph;

import java.util.Scanner;

// 복잡도 o(N+E) 
public class BaekJoon9466Plus {

	static int[] student; // 다음 간선 값을 저장
	static int[] check;   // 방문 여부 체크
	static int alone;    // 조를 짜지 못하는 학생의 수 -> 최종 값
	static int[] array;  // 현재 불분명한 조편성 정보를 담아두는 배열
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();                  // 1. testCase 의 수 입력 받는다
		
		for(int i=0; i<testCase; i++ ) {              // testCase의 수 만큼 for loop
			
			int studentSize = sc.nextInt();   	      // 2. 학생 수 입력 받는다
			// 변수 초기화
			alone = 0;                                // 학생의 수 0으로 초기화
			student = new int[studentSize+1];         // 학생의 수 크기 만큼 배열 크기 선언
			check = new int[studentSize + 1];
			array = new int[studentSize + 1];
			
			for(int j=1; j<=studentSize; j++) {       // 각 학생에 해당 되는 간선 값 student 에 입력 받음
				student[j] = sc.nextInt();			  // 동시에 array 배열 초기화
				
			}

			for(int j=1; j<=studentSize; j++) {
				if(check[j] == 0) {                    // 만약  check 배열이 0값인 경우만 조 편성 가능 여부 체크
					alone += termProject(j);           
				}
			}
			
			System.out.println(alone);
		}
			
		
	}
	
	static int termProject(int j) {
		int cnt = 1;
		int number = j; 
		
		while(true) {									// 핵심 idea
			if( check[j] != 0) { 						// 다른 조들과 구분하기 위해(dfs가 다른 경우를 의미) 각 해당 조들의 check 값을 다르게 줌
				if(check[j] == number) {                // 만약 check 배열에 0이 아닌 값이 들어 있는데, 같은 dfs인 경우, --> array[j] - 1(백준 알고리즘 강의 참고)
					return array[j] - 1;                // 만약 다른 dfs 인 경우 cns-1
				}else {
					return cnt-1;
				}
			}
			check[j] = number;                           // check[j] == 0 인경우 다음 간선 check, cnt 값 ++
			array[j] = cnt;
			j = student[j];
			cnt++;
		}
		
	}
	
	
}