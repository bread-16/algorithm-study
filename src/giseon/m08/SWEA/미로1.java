package giseon.m08.SWEA;

import java.util.*;
import java.io.*;

public class 미로1 {
	// 우하좌상 탐색할 델타 배열 선언
	static final int[] dr = {0, 1, 0, -1};
	static final int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			Integer.parseInt(br.readLine().trim()); 
			sb.append("#").append(tc).append(" ");
			
			int[][] map = new int[16][16];
			boolean[][] visited = new boolean[16][16];
			Queue<int[]> q = new ArrayDeque<>();
			for (int i = 0; i < 16; i++) {
				String str = br.readLine().trim();
				for (int j = 0; j < 16; j++) {
					map[i][j] = str.charAt(j) - '0';
					
					if (map[i][j] == 1) visited[i][j] = true; // 갈 수 없는 곳이면 방문한 걸로 처리해서 못 가게 함
					else if (map[i][j] == 2) { // 출발지 위치 확인
						q.offer(new int[] {i, j});
						visited[i][j] = true;
					} 
				} // j end
			} // i end
			
			int answer = 0;
			bfs:
			while (!q.isEmpty()) {
				int[] cur = q.poll();				
				for (int i = 0; i < 4; i++) {
					int nr = cur[0]+dr[i];
					int nc = cur[1]+dc[i];
					if (inRange(cur[0], cur[1], nr, nc)) { // 범위 내 인덱스 탐색이면
						if (!visited[nr][nc]) { // 아직 방문하지 않았고 값이 0이면 인접한 노드 큐에 넣기
							if (map[nr][nc] == 0) {
								visited[nr][nc] = true;
								q.offer(new int[] {nr, nc});		
							}
							else if (map[nr][nc] == 3) {
								answer = 1;
								break bfs;
							}
						}
					}
				} // dr, dc end
			} // while end
			sb.append(answer).append("\n");
		} // tc end
		System.out.print(sb);
	} // main end
	
	static public boolean inRange(int r, int c, int nr, int nc) {
		if (r < 0 || c < 0 || nr > 15 || nc > 15) {
			return false;
		}
		return true;
	}
}
