package ohyeon.m08.programmers;

public class Fatigue {
	int maxCount = 0; 
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(k, 0, dungeons);
        
        return maxCount;
    }

    public void dfs(int k, int count, int[][] dungeons) {
        maxCount = Math.max(maxCount, count);

        if (count == dungeons.length) {
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], count + 1, dungeons);
                visited[i] = false;
            }
        }
    }
}
