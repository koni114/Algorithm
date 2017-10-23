package dijkstra;

public class dijkstra {
	int cityNode = 0; // 노드의 수
	int[][] NodeWeight; // 노드 간의 가중치 저장 2차원 배열
	int[] distance;
	boolean[] check;
	
	public dijkstra(int cityNode) {
		this.cityNode = cityNode;
		this.NodeWeight = new int[cityNode][cityNode];
		this.distance = new int[cityNode];
		this.check = new boolean[cityNode];
	}
	
	
	public void putWeight(int i, int j, int weight) {
		
		NodeWeight[i][j] = weight;
		
	}

	public void shortestPath(int startNode) {
		// 초기 값 선언
		// 1. distance 값 초기화
		for(int i=0; i<cityNode; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		// 시작 노드 값 초기화
		distance[startNode] = 0;
		check[startNode] = true;
		
		// 시작 노드 가중치 값 초기값 기입
		for(int i =0; i< cityNode; i++) {
			if( !check[i]  && NodeWeight[startNode][i] != 0) {
				distance[i] = NodeWeight[startNode][i];
			}
			
		}
		
		// 총 노드의 수 -1 만큼 for loop를 돌면 최종 shortestPath를 구함
		for(int i =0; i<cityNode-1 ; i++) {
			int min = Integer.MAX_VALUE;
			int min_index = -1;
			
			// 1. 현재 distance 값 중 최소값의 노드를 찾음
			// check 값이 False 이고  distance 값이 INF가 아닌 경우 한에서 최소값을 찾음
			for(int j =0; j<cityNode; j++) {
				if(!check[j] && distance[j] != Integer.MAX_VALUE) {
					if(min > distance[j]) {
						min = distance[j];
						min_index = j;
					}
				}
			}
			
			
			// 2. 현재 노드에서 다음 노드로 이동하는 가중치가 있는 경우(길이 있는 경우), 현재 distance와 비교
			// 다음 노드 distance 값 >  현재 노드 + 가중치 값
			check[min_index] = true;
			for(int j=0; j<cityNode; j++) {
				if(NodeWeight[min_index][j] != 0) {
					if(distance[j] > min + NodeWeight[min_index][j]) {
						distance[j] = min + NodeWeight[min_index][j];
					}
				}
			}
		}
		
		// 결과 값 출력
		 System.out.println("The shortest path between City "+ startNode + " to");
	        for(int i=1;i<cityNode;i++){
	            System.out.println("City "+ i +" is: "+ distance[i]+ " ");
	        }
	}
	
	
	
	public static void main(String[] args) {

		dijkstra g = new dijkstra(7);
        g.putWeight(5, 6, 20);
        g.putWeight(6, 5, 10);
        g.putWeight(0, 5, 10);
        g.putWeight(1, 0, 20);
        g.putWeight(1, 2, 80);
        g.putWeight(5, 2, 40);
        g.putWeight(6, 2, 10);
        g.putWeight(2, 6, 10);
        g.putWeight(3, 0, 50);
        g.putWeight(1, 4, 20);
        g.putWeight(4, 1, 90);
        g.putWeight(2, 4, 20);
        g.putWeight(3, 4, 30);
        g.putWeight(4, 3, 30);
        g.shortestPath(0);
		
	}

}