package dijkstra;

public class dijkstra {
	int cityNode = 0; // ����� ��
	int[][] NodeWeight; // ��� ���� ����ġ ���� 2���� �迭
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
		// �ʱ� �� ����
		// 1. distance �� �ʱ�ȭ
		for(int i=0; i<cityNode; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		// ���� ��� �� �ʱ�ȭ
		distance[startNode] = 0;
		check[startNode] = true;
		
		// ���� ��� ����ġ �� �ʱⰪ ����
		for(int i =0; i< cityNode; i++) {
			if( !check[i]  && NodeWeight[startNode][i] != 0) {
				distance[i] = NodeWeight[startNode][i];
			}
			
		}
		
		// �� ����� �� -1 ��ŭ for loop�� ���� ���� shortestPath�� ����
		for(int i =0; i<cityNode-1 ; i++) {
			int min = Integer.MAX_VALUE;
			int min_index = -1;
			
			// 1. ���� distance �� �� �ּҰ��� ��带 ã��
			// check ���� False �̰�  distance ���� INF�� �ƴ� ��� �ѿ��� �ּҰ��� ã��
			for(int j =0; j<cityNode; j++) {
				if(!check[j] && distance[j] != Integer.MAX_VALUE) {
					if(min > distance[j]) {
						min = distance[j];
						min_index = j;
					}
				}
			}
			
			
			// 2. ���� ��忡�� ���� ���� �̵��ϴ� ����ġ�� �ִ� ���(���� �ִ� ���), ���� distance�� ��
			// ���� ��� distance �� >  ���� ��� + ����ġ ��
			check[min_index] = true;
			for(int j=0; j<cityNode; j++) {
				if(NodeWeight[min_index][j] != 0) {
					if(distance[j] > min + NodeWeight[min_index][j]) {
						distance[j] = min + NodeWeight[min_index][j];
					}
				}
			}
		}
		
		// ��� �� ���
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