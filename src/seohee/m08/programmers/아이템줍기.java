package seohee.m08.programmers;

import java.util.*;

// 통과 (0.06ms, 73.1MB)
public class 아이템줍기 {
    static final int[] dx1 = {0, -1, 0, 1};
    static final int[] dy1 = {-1, 0, 1, 0};

    static final int[] dx2 = {-1, -1, 0, 0};
    static final int[] dy2 = {0, -1, -1, 0};

    static final int SIZE = 110;

    boolean[][] board = new boolean[SIZE][SIZE];
    int itemX, itemY;
    int answer = Integer.MAX_VALUE/2;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        this.itemX = itemX * 2;
        this.itemY = itemY * 2;

        for (int[] r: rectangle) {
            for (int i = r[0]*2; i < r[2]*2; i++) {
                for (int j = r[1]*2; j < r[3]*2; j++) {
                    board[i][j] = true;
                }
            }
        }

        return bfs(characterX * 2, characterY * 2) / 2;
    }

    private int bfs(int sx, int sy) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[SIZE][SIZE];
        queue.add(new int[] {sx, sy, 0});
        visited[sx][sy] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1], dist = cur[2];

            if (cx == itemX && cy == itemY)
                return dist;

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx1[d], ny = cy + dy1[d];
                if (!inRange(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (!isBorder(nx, ny)) continue;
                queue.add(new int[] {nx, ny, dist + 1});
                visited[nx][ny] = true;
            }
        }
        return -1;
    }

    private boolean isBorder(int x, int y) {
        int cnt = 0;
        for (int d = 0; d < 4; d++) {
            if (!inRange(x + dx2[d], y + dy2[d])) {
                cnt++;
                continue;
            }
            if (!board[x + dx2[d]][y + dy2[d]])
                cnt++;
        }
        return cnt == 4 || cnt == 0 ? false : true;
    }

    private boolean inRange(int x, int y) {
        return 0 <= x && x < SIZE && 0 <= y && y < SIZE;
    }
}
