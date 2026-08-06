package davin.m08.programmers;

import java.util.*;

public class 전력망을둘로나누기 {
List<List<Integer>> adj;
    
    public int solution(int n, int[][] wires) {
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] wire : wires) {
            adj.get(wire[0]).add(wire[1]);
            adj.get(wire[1]).add(wire[0]);
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            boolean[] visited = new boolean[n + 1];
            visited[v2] = true; // v1 -> v2 방향 차단
            
            int count = dfs(v1, visited);
            
            int diff = Math.abs(n - 2 * count);
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    
    private int dfs(int cur, boolean[] visited) {
        visited[cur] = true;
        int count = 1;
        for (int next : adj.get(cur)) {
            if (!visited[next]) {
                count += dfs(next, visited);
            }
        }
        return count;
    }
}
