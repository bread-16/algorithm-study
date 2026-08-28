package dana.m08.swea;

import java.util.*;
import java.io.*;

public class swea1226 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		
		// 시작 좌표 저장 
		int startR = 0;
		int startC = 0; 
		
		// 정답 좌표 저장 
		int ansR = 0;
		int ansC = 0; 
		
		// 테케 수 : 10 고정 
		for (int tc = 1; tc <= 10; tc++) {
			// 현재 테케 수 
			int testNum = Integer.parseInt(br.readLine());
			// 맵 : 16x16 고정 
			int[][] map = new int[16][16]; 
			// 맵 입력 받기 
			for (int i = 0; i < 16; i++) {
				String line = br.readLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = line.charAt(j) - '0'; 
					// 시작 좌표 저장 
					if (map[i][j] == 2) {
						startR = i;
						startC = j; 
					}
					// 도착지 좌표 저장 
					if (map[i][j] == 3) {
						ansR = i;
						ansC = j;
					}
				}
			}
			
			// BFS 사용하기 
			// 0 -> 도달하지 못함, 1 -> 도달했다 
			int answer = 0; 
			// visited 배열 
			boolean[][] visited = new boolean[16][16]; 
			// 서치할 4방향 : up down left right
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1}; 
			// {row, col}
			Queue<int[]> q = new ArrayDeque<>(); 
			// 시작점을 방문했다고 해주기 
			visited[startR][startC] = true; 
			// 시작점을 큐에 넣어주기 
			q.offer(new int[]{startR, startC});
			// BFS 시작 
			while(!q.isEmpty()) {
				int[] current = q.poll();
				int r = current[0];
				int c = current[1]; 
				
				// 4방향 탐색 -> 0이면 큐에 추가 
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d]; 
					// 새로운 좌표가 정당한가? 
					if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16) {
						// 도착지에 방문 했으면 끝내버리기
						if (map[nr][nc] == 3) {
							answer = 1;
							q.clear();
							break; 
						}
						if (map[nr][nc] == 0) {
							// 이미 방문했나? 
							if (visited[nr][nc]) {
								continue;
							} else {
								// 방문했다고 체크해주기 
								visited[nr][nc] = true; 
								// 큐에 넣어주기 
								q.offer(new int[] {nr, nc});
							}
						}
					}
				}
			}
			// sb 
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			// end of test case # 
		}
		// print answer 
		System.out.print(sb);
	}
}