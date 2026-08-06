package seohee.m08.programmers;

public class 피로도 {
    int k, maxCount;
    int[][] dungeons;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.k = k;
        visited = new boolean[dungeons.length];
        dfs(0);
        return maxCount;
    }

    private void dfs(int cnt) {
        maxCount = Math.max(maxCount, cnt);

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i])
                continue;
            if (dungeons[i][0] > k)
                continue;
            visited[i] = true;
            k -= dungeons[i][1];
            dfs(cnt + 1);
            visited[i] = false;
            k += dungeons[i][1];
        }
    }
}
