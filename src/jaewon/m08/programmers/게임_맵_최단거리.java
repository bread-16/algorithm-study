package jaewon.m08.programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 게임_맵_최단거리 {

	public int[][] maps;

	// 상 하 좌 우
	public int[] dy = { -1, 1, 0, 0 };
	public int[] dx = { 0, 0, -1, 1 };

	public int solution(int[][] maps) {
		this.maps = maps;
		int n = maps.length;
		int m = maps[0].length;
		
		// 출발점부터 n,m 까지 최단 거리 저장 맵
		int[][] dist = new int[n][m];
		for (int[] row : dist) {
			Arrays.fill(row, -1);
		}

		Deque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { 0, 0 });

		dist[0][0] = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curY = cur[0];
			int curX = cur[1];
			
			// n,m 도착. 해당 값 반환
			if (curY == n - 1 && curX == m - 1) {
				return dist[curY][curX];
			}
			
			// 상하좌우 검색. 벽이 아니면 감
			for (int dir = 0; dir < 4; dir++) {
				int nextY = curY + dy[dir];
				int nextX = curX + dx[dir];
				
				// 범위 밖. 스킵
				if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
					continue;
				}
				// 다음 경로가 벽이거나 지나간 길이라면 다시 가지 않음. 스킵
				if (maps[nextY][nextX] == 0 || dist[nextY][nextX] != -1) {
					continue;
				}
				
				// 다음 칸의 거리는 현재 칸 +1
				dist[nextY][nextX] = dist[curY][curX] + 1;
				queue.offer(new int[] { nextY, nextX });

			}

		}

		return -1;
	}
}
