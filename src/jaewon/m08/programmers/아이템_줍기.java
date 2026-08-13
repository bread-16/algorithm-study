package jaewon.m08.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class 아이템_줍기 {

    public int[][] map = new int[104][104];

    // 상 하 좌 우
    public int[] dr = {-1, 1, 0, 0};
    public int[] dc = {0, 0, -1, 1};

    // 테두리를 1로 채운다
    public void drawRect(int stR, int stC, int endR, int endC) {
        for (int c = stC; c <= endC; c++) {
            map[stR][c] = 1;
            map[endR][c] = 1;
        }
        for (int r = stR; r <= endR; r++) {
            map[r][stC] = 1;
            map[r][endC] = 1;
        }
    }

    // 열린 내부를 0으로 지운다
    public void eraseInside(int stR, int stC, int endR, int endC) {
        for (int r = stR + 1; r < endR; r++) {
            for (int c = stC + 1; c < endC; c++) {
                map[r][c] = 0;
            }
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 1단계: 모든 사각형의 테두리를 먼저 그린다 (좌표 2배 확대)
        for (int[] rect : rectangle) {
            int stC = rect[0] * 2;
            int stR = rect[1] * 2;
            int endC = rect[2] * 2;
            int endR = rect[3] * 2;
            drawRect(stR, stC, endR, endC);
        }

        // 2단계: 그리기가 모두 끝난 뒤 내부를 지운다
        for (int[] rect : rectangle) {
            int stC = rect[0] * 2;
            int stR = rect[1] * 2;
            int endC = rect[2] * 2;
            int endR = rect[3] * 2;
            eraseInside(stR, stC, endR, endC);
        }

        // 3단계: BFS
        int startR = characterY * 2, startC = characterX * 2;
        int targetR = itemY * 2, targetC = itemX * 2;

        int[][] dist = new int[104][104];
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{startR, startC});
        dist[startR][startC] = 1;   // 방문 표시 겸용, 마지막에 1을 뺀다

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curR = cur[0], curC = cur[1];

            if (curR == targetR && curC == targetC) {
                return (dist[curR][curC] - 1) / 2;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nextR = curR + dr[dir];
                int nextC = curC + dc[dir];

                if (nextR < 0 || nextR >= map.length || nextC < 0 || nextC >= map[0].length) continue;
                if (map[nextR][nextC] == 0) continue;      // 테두리가 아님
                if (dist[nextR][nextC] != 0) continue;      // 이미 방문

                dist[nextR][nextC] = dist[curR][curC] + 1;
                q.offer(new int[]{nextR, nextC});
            }
        }

        return 0;
    }
}