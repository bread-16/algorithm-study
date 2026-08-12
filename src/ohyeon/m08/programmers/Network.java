package ohyeon.m08.programmers;
/*
n: 컴퓨터의 개수
computers 2차원 배열: 컴퓨터와 연결되어있는지 확인하는 용도
visited: 방문 여부
방문 조건: 방문하지 않았고, 컴퓨터와 연결되어있는지 확인.
dfs로 재귀돌면서 끝까지 탐색.
*/
public class Network {
	int[][] computers;
    int n;
    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.n = n;
        int answer = 0;
        boolean[] visited = new boolean[n]; 
        //모든 컴퓨터 순회
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++; //새 네트워크
                dfs(visited, i); //재귀(돌면서 탐색)
            }
        }
        return answer;
    }
    void dfs(boolean[] visited, int start){
        visited[start] = true; //여기서 방문표시
        for(int i = 0; i < n; i++) {
            //컴퓨터와 연결되어있고, 아직 방문하지 않았다면
            if(computers[start][i] == 1 && !visited[i]) {
                dfs(visited, i); //재귀
            }
        }
    }
}
