package jinwoo.m08.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class GameMapShortestPath {
	
	// 위, 왼, 아, 오
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, -1, 0, 1};
	int[][] maps;
	
	public int solution(int[][] maps) {
		this.maps = maps;
        return bfs();
    }
	
	public int bfs() {
		Deque<int[]> position = new ArrayDeque<>();
		position.offerLast(new int[]{0 , 0});
		
		while(!position.isEmpty()) {
			int[] cur = position.pollFirst();
			int x = cur[0];
			int y = cur[1];
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) continue;
				
				if(maps[nx][ny] != 1) continue;
				
				maps[nx][ny] = maps[x][y] + 1;
				
				position.offerLast(new int[] {nx, ny});
			}
		}
		if(maps[maps.length-1][maps[0].length-1] == 1) {
			return -1;
		}
		
		return maps[maps.length-1][maps[0].length-1];
	}
}
