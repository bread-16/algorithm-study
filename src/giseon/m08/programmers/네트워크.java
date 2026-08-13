package giseon.m08.programmers;

// 0.02ms, 83.5MB
class 네트워크 {
    
    int[][] coms;
    int n;
    boolean[] visited; // 각 컴퓨터(노드)마다 방문여부만 생각하면 됨
    
    public int solution(int n, int[][] coms) {
        this.coms = coms;
        this.n = n;
        this.visited = new boolean[n];
        
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // i번 컴퓨터를 아직 방문하지 않았다면
                answer++; // 네트워크 하나를 발견했으므로 count
                dfs(i); // i번 컴퓨터에서 DFS
            }
        }
        
        return answer;
    }
    
    // 인접 행렬을 순회하면서 방문하지 않은 노드들을 방문하고, coms가 1이면 연결을 깊게 탐색한다.
    // coms[i][j] == 1 이면 coms[j][0~n-1] 탐색하고 끝까지 탐색했으면 네트워크 수 count
    public void dfs(int node) {
        for (int j = 0; j < n; j++) {
            if (!visited[j] && coms[node][j] == 1) { // 아직 방문하지 않았고 node와 j가 연결되어 있다면
                visited[j] = true; // j 방문
                dfs(j); // j에서 다시 DFS
            }
        }
    }
}
