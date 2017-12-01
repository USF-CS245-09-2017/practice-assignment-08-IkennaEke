import java.util.Stack;


public class GraphAdjMatrix implements Graph{
	
	private int [][] graph;
	private int size;
	
	public GraphAdjMatrix(int vertices){
		size = vertices;
		graph = new int [vertices][vertices];
	}

	@Override
	public void addEdge(int v1, int v2) {
		// TODO Auto-generated method stub
		graph[v1][v2] = 1;
		
	}

	@Override
	public int[] neighbors(int vertex) {
		int count = 0;
		for(int i = 0; i<graph[vertex].length;i++){
			if(graph[vertex][i]==1){
				count++;
			}
		}
		int [] neighbor = new int[count];
		int index = 0;
		for(int i = 0; i<graph[vertex].length;i++){
			if(graph[vertex][i]==1){
				neighbor[index] = i;
				index++;
			}
		}
		return neighbor;
	}

	@Override
	public void topologicalSort() {
		int [] array = new int[size];
		int index = 0;
		Stack s = new Stack();
		int [] NumIncident = new int [size];
		for(int i= 0; i<graph.length;i++){
			NumIncident[i] = neighbors(i).length;
		}
		for(int i= 0; i<graph.length;i++){
			if(NumIncident[i]==0){
				s.push(i);
			}
		}
		while(!s.empty()&&index<array.length){
			int v = (int) s.pop();
			array[index] = v;
			index++;
			for(int i = 0; i<graph.length;i++){
				int [] n = neighbors(i);
				for(int j = 0;j<n.length;j++){
					if(n[j]==v){
						NumIncident[i]--;
						if(NumIncident[i]==0){
							s.push(i);
						}
					}
				}
			}
		}
		for(int i = 0 ;i<array.length;i++){
			System.out.print(array[i]+ " ");
		}
	}
}
