package bomin.m08.programmers;

class Solution {
    int[][] computers;
    boolean[] visited;
    int n;
    public int solution(int n, int[][] computers) {
        // 1) 노드 개수 - 선 하려 했는데, 1/2/3이 전부 서로 이어져있는 경우에서 반례
     
        // 2) dfs-> 첫 노드에서 이어진 노드까지 전부 탐색 후 visited[i] -> true로 바꾼 후 false인 다음 노드 찾아서 반복 / 개수 세기
        // computers 이차원배열 정리?
        // visited에 노드번호 넣기. 다시 false로 만들 필요는 없을 것 같음
        // computers[i][0] -> 1이면 1이랑 이어짐. ----> i에 visited[true] 처리 후 count++;
    	
    	
        this.n = n;
        this.computers = computers;
        visited = new boolean[n];
        int count = 0;
        
        for(int i=0; i<n;i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }
        
        return count;
    }
    void dfs(int idx){
        for(int i=0; i<n; i++){
            if(computers[i][idx] == 1 && visited[i] == false){
                //visited[i] == false 없으면 본인에서 재귀로 계속 도는거같음.. 스택오버플로우뜸
                visited[i] = true;
                dfs(i);
            }
        }
    }
    
}
