package seohee.m08.programmers;

import java.util.*;

// 0.05ms, 75MB
public class 게임맵최단거리 {
    int n, m;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1];

            if (cx == n - 1 && cy == m - 1) {
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d], ny = cy + dy[d];

                if (!inRange(nx, ny)) continue;
                if (dist[nx][ny] != -1 || maps[nx][ny] == 0) continue;

                queue.offer(new int[] {nx, ny});
                dist[nx][ny] = dist[cx][cy] + 1;
            }
        }

        return dist[n - 1][m - 1];
    }

    private boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
