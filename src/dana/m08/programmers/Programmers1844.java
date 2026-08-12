package dana.m08.programmers;

import java.util.ArrayDeque;
import java.util.Queue; 

public class Programmers1844 {
	
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length; 
        
        // 이동할 네 가지 방향 (상, 하, 좌, 우)
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        // BFS를 위한 큐 생성 (좌표를 저장할 배열 형태)
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1]; 
            
            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nr = x + dr[i];
                int nc = y + dc[i];
                
                // 맵 범위를 벗어나는지 확인
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue; 
                }
                // 벽인 경우 무시
                if (maps[nr][nc] == 0) {
                    continue; 
                }
                // 처음 방문하는 길인 경우 최단 거리 갱신 및 큐에 추가
                if (maps[nr][nc] == 1) {
                    maps[nr][nc] = maps[x][y] + 1; 
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        // 상대 팀 진영 (n-1, m-1)의 값 확인 
        int answer = maps[n - 1][m - 1];
        
        // 값이 여전히 1이라면 도달하지 못한 경우 -> -1 반환 
        if (answer == 1) {
            return -1; 
        }
        return answer; 
    }
}
