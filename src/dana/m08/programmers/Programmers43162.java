package dana.m08.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class Programmers43162 {
			
	// bfs 
	private void bfs(int node, int numComputers, int[][] computers, boolean[] visited) {
		
		Queue<Integer> queue = new ArrayDeque<>(); 
		queue.offer(node);
		visited[node] = true; 

		while(!queue.isEmpty()) {
			// current node 
			int current = queue.poll();
			
			// check computers that are connected to the currernt node 
			for (int i = 0; i < numComputers; i++) {
				if (computers[current][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.offer(i); 
				}
			}
		}
	}
	
	public int solution(int n, int[][] computers) {
		
		int networkCounter = 0; 
		boolean[] visited = new boolean[n]; 
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				bfs(i, n, computers, visited);
				networkCounter++;
			}
		}
		
		return networkCounter;
	}
}
