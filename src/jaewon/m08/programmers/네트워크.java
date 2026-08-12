package jaewon.m08.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class 네트워크 {
	
	public int[][] computers;
	public int n;
	public int answer;
	public boolean[] visited;
	
	public int solution(int n, int[][] computers) {
		this.n = n;
		this.computers = computers;
        this.answer = 0;
        
        this.visited = new boolean[n];
        
        for(int i=0 ; i<n; i++) {
        	// 이미 방문한적 있으면 스킵
        	if(visited[i]) continue;
        	
        	Deque<Integer> queue = new ArrayDeque<>();
        	queue.offer(i);
        	visited[i] = true;
        	
        	// 방문할 노드가 있음
        	while(!queue.isEmpty()) {
        		int cur = queue.poll();
        		for(int next = 0; next < n ; next++) {
        			// 현재 노드와 다음 노드가 연결되어 있고, 다음 노드에 방문한 적 없다면
        			if(computers[cur][next] == 1 && !visited[next]) {
        				// 히히 다음에 가야지
        				visited[next] = true;
        				queue.offer(next);
        			}
        		}
        	}
        	answer++;
        	
        }
        
        
        return answer;
    }
}
