package seohee.m08.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

// 0.05mb, 79.9MB
public class 게임맵최단거리_2 {
    int n, m;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        boolean[][] visited = new boolean[n][m];

        int answer = -1;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1], dist= cur[2];

            if (cx == n - 1 && cy == m - 1) {
                answer = dist;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d], ny = cy + dy[d];

                if (!inRange(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (maps[nx][ny] == 0) continue;

                queue.offer(new int[] {nx, ny, dist + 1});
                visited[nx][ny] = true;
            }
        }

        return answer;
    }

    private boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
