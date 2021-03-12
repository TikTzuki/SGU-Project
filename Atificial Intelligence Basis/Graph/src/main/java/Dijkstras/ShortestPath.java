package Dijkstras;

public class ShortestPath {
	static final int V = 9;
	int minDistance(int dist[], Boolean sptSet[]) {
		int min = Integer.MAX_VALUE, min_index = -1;
		
		for(int v=0; v<V; v++) {
			if(sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}
		}
		return min_index;
	}
	
	void printPath(int dist[]) {
		for(int i=0; i<V; i++)
			System.out.println(i+ "\t\t" + dist[i]);
	}
	
	void dijkstra(int graph[][], int src) {
		/**
		 * The output array. dist[i] will the shortest distance from src to i
		 */
		int dist[] = new int[V];
		
		/**
		 * sptSet[i] will true if vertex i is included in shortest path tree or shortest distance from src to i is finalized
		 */
		Boolean sptSet[] = new Boolean[V];
		
		/**
		 * Initialize all distances as INFINITE and stpSet[] as false
		 */
		for(int i=0; i<V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		
		/**
		 * Distance of source vertex from itself is always 0
		 */
		dist[src] = 0;
		
		/**
		 * Find shortest path for all vertices
		 */
		for(int count = 0; count < V-1; count++) {
			/**
			 * Pick the minium distance vertex from the set of vertices not yet processed . u is allways equal to src in first iteration
			 */
			int u = minDistance(dist, sptSet);
			
			/*
			 * Mark the picked vertex as processed
			 */
			sptSet[u] = true;
			
			/**
			 * Update dist value of the adjacent vertices of the picked vertex
			 */
			for(int v=0; v<V; v++)
				/**
				 * Update dist[v] only if is not in sptSet, 
				 * there is an edge from u to v,
				 * and total weight of path from src to v through u is smaller then current value of dist[v]
				 */
				if(!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}
		
		printPath(dist);
	}
	
	public static void main(String[] args) {
		int graph[][] = new int[][] {{
			9
		}};
	}
}
