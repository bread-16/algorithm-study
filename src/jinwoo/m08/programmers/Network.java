package jinwoo.m08.programmers;

import java.util.HashSet;
import java.util.Set;

public class Network {
	
	int n;
	int[][] computers;
	boolean[] visited;
	
	public int solution(int n, int[][] computers) {
		this.n = n;
		this.computers = computers;
		this.visited = new boolean[n];
		
		int answer = 0;
		
		// 방문하지 않은 컴퓨터 방문 시 답 ++
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				answer++;
				dfs(i);
			}
		}
        return answer;
    }
	
	// 이어진 모든 컴퓨터 순회(방문했다고 바꿈)
	public void dfs(int depth) {
		visited[depth] = true;
		for(int i=0; i<n; i++) {
			if(computers[depth][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	} 
	
}
