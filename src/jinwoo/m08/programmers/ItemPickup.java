package jinwoo.m08.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class ItemPickup {
	
	// 위 아 오 왼
	int[] dx = { -1, 1, 0, 0};
	int[] dy = { 0, 0, 1, -1};
	
	int[][] map;
	
	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		
		// 반례로 인해 크기 2배수
		map = new int[102][102];
		// 맵에 사각형 넣기
		// 내부 2로 채워놓기
		// 외부 1로 채움 다만 2인경우는 채우지 않음
		for(int[] rect : rectangle) {
			for(int i=rect[0]*2 + 1; rect[2]*2 > i; i++) {
				for(int j=rect[1]*2 + 1; rect[3]*2>j; j++) {
					map[i][j] = 2;
				}
			}
			
			for(int i=rect[0]*2; rect[2]*2 >= i; i++) {
				for(int j=rect[1]*2; rect[3]*2>=j; j++) {
					if(map[i][j] == 2) continue;
					map[i][j] = 1;
				}
			}
		}
		
		bfs(characterX * 2, characterY * 2);
		
       
        return map[itemX*2][itemY*2]/2 - 1;
    }
	
	public void bfs(int x, int y) {
		Queue<int[]> cor = new ArrayDeque<>();
		
		map[x][y] = 2;
		
		cor.offer(new int[] {x,y});
		
		
		while(!cor.isEmpty()) {
			int[] position = cor.poll();
			
			for(int i=0; i<4; i++) {
				int nx = position[0] + dx[i];
				int ny = position[1] + dy[i];
				
				// 멈추는 조건  : 1. 맵 범위 넘어가면, 2. 사각형이 아니라면(!=1)
				if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
				
				if(map[nx][ny] != 1) continue;
				
				map[nx][ny] = map[position[0]][position[1]] + 1;
				
				cor.offer(new int[]{nx, ny});
				
			}
		}
	}
	
}
