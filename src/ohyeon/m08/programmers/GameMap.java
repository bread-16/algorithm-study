package ohyeon.m08.programmers;

import java.util.*;

public class GameMap {
	static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int answer = 1;
        boolean[][] visited = new boolean[n][m];
        Queue <int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 1}); // 현재 위치 (x, y), 이동거리
        visited[0][0] = true;
        
        while(!queue.isEmpty()) { //bfs
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            answer = current[2];
            
            if (x == n-1 && y == m-1) { //목적지에 도착
                return answer;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && maps[nx][ny]!=0 && !visited[nx][ny]) { //맵 안에 있어야하고 이동 가능한 칸이여야하고 방문하지 않았어야하고
                        visited[nx][ny] = true;
                        queue.offer(new int[] {nx, ny, answer+1});
                }
            }
        }
        return -1;
    }
}
