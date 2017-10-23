package unionFind;

// 유니온 파인드 연습
public class UnionFindExample {

	static int[] parent;
	
	public static void main(String[] args) {

		parent = new int[10];
		for(int i=0; i<10; i++ ) {
			parent[i] = i;
		}
		
		// Find 함수 재귀로 구현
		Union(1,2);
		
		
	}

	// Union 개념 함수로 구현
	static void Union(int i, int j) {
		int x = Find(i);
		int y = Find(j);
		parent[y] = x;
		
	}
	
	// Find 개념 함수로 구현
	static int Find(int i){
		if(parent[i] == i) {
			return i;
		}else {
			// 경로 압축을 위해 같은 집합에 있는 모든 노드의 root를 부모 값으로 지정
			return parent[i] = Find(parent[i]);
		}
	}
	
	

}
