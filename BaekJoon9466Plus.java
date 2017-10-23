package graph;

import java.util.Scanner;

// ���⵵ o(N+E) 
public class BaekJoon9466Plus {

	static int[] student; // ���� ���� ���� ����
	static int[] check;   // �湮 ���� üũ
	static int alone;    // ���� ¥�� ���ϴ� �л��� �� -> ���� ��
	static int[] array;  // ���� �Һи��� ���� ������ ��Ƶδ� �迭
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();                  // 1. testCase �� �� �Է� �޴´�
		
		for(int i=0; i<testCase; i++ ) {              // testCase�� �� ��ŭ for loop
			
			int studentSize = sc.nextInt();   	      // 2. �л� �� �Է� �޴´�
			// ���� �ʱ�ȭ
			alone = 0;                                // �л��� �� 0���� �ʱ�ȭ
			student = new int[studentSize+1];         // �л��� �� ũ�� ��ŭ �迭 ũ�� ����
			check = new int[studentSize + 1];
			array = new int[studentSize + 1];
			
			for(int j=1; j<=studentSize; j++) {       // �� �л��� �ش� �Ǵ� ���� �� student �� �Է� ����
				student[j] = sc.nextInt();			  // ���ÿ� array �迭 �ʱ�ȭ
				
			}

			for(int j=1; j<=studentSize; j++) {
				if(check[j] == 0) {                    // ����  check �迭�� 0���� ��츸 �� �� ���� ���� üũ
					alone += termProject(j);           
				}
			}
			
			System.out.println(alone);
		}
			
		
	}
	
	static int termProject(int j) {
		int cnt = 1;
		int number = j; 
		
		while(true) {									// �ٽ� idea
			if( check[j] != 0) { 						// �ٸ� ����� �����ϱ� ����(dfs�� �ٸ� ��츦 �ǹ�) �� �ش� ������ check ���� �ٸ��� ��
				if(check[j] == number) {                // ���� check �迭�� 0�� �ƴ� ���� ��� �ִµ�, ���� dfs�� ���, --> array[j] - 1(���� �˰��� ���� ����)
					return array[j] - 1;                // ���� �ٸ� dfs �� ��� cns-1
				}else {
					return cnt-1;
				}
			}
			check[j] = number;                           // check[j] == 0 �ΰ�� ���� ���� check, cnt �� ++
			array[j] = cnt;
			j = student[j];
			cnt++;
		}
		
	}
	
	
}