package unionFind;

// ���Ͽ� ���ε� ����
public class UnionFindExample {

	static int[] parent;
	
	public static void main(String[] args) {

		parent = new int[10];
		for(int i=0; i<10; i++ ) {
			parent[i] = i;
		}
		
		// Find �Լ� ��ͷ� ����
		Union(1,2);
		
		
	}

	// Union ���� �Լ��� ����
	static void Union(int i, int j) {
		int x = Find(i);
		int y = Find(j);
		parent[y] = x;
		
	}
	
	// Find ���� �Լ��� ����
	static int Find(int i){
		if(parent[i] == i) {
			return i;
		}else {
			// ��� ������ ���� ���� ���տ� �ִ� ��� ����� root�� �θ� ������ ����
			return parent[i] = Find(parent[i]);
		}
	}
	
	

}
