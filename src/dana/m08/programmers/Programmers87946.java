package dana.m08.programmers;

public class Programmers87946 {
	
    int answer = 0; 
    
    // DFS 헬퍼 메소드: 
    void dfs(int[][] dungeons, boolean[] visited, int currEnergy, int count) {
        // 답 업데이트 해주기 
        answer = Math.max(answer, count);
        // 모든 던전을 탐험해보기 
        for (int i = 0; i < dungeons.length; i++) {
            
            int minEnergy = dungeons[i][0];
            int consume = dungeons[i][1];
            
            // 종료조건 
            if (visited[i] || currEnergy < minEnergy) {
                continue; 
            }
            // 탐험하기 
            visited[i] = true;
            dfs(dungeons, visited, currEnergy - consume, count + 1);
            visited[i] = false;
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        /*
        전략: 모든 경우의 수를 다 탐험하며, 가능한 경우, answer++ 
                DFS사용 
                
        0.04ms, 74mb 
        O(n · n!)
        */
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons, visited, k, 0);
        
        return answer;
    }

}
