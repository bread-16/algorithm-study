package davin.m08.programmers;
import java.util.*;

public class 게임맵최단거리 {

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;
		int[][] distance = new int[n][m];

		// 탐색할 좌표
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0 });
		distance[0][0] = 1;

		while (!q.isEmpty()) {
			int cur[] = q.poll();
			int x = cur[0];
			int y = cur[1];

			for (int i = 0; i < 4; i++) {
				if (x == n - 1 && y == m - 1)
					return distance[x][y];

				int nx = x + dx[i];
				int ny = y + dy[i];

				// 범위 초과
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				// 이미 방문한 곳, 벽이 있는 곳
				if (distance[nx][ny] != 0 || maps[nx][ny] == 0)
					continue;

				q.offer(new int[] { nx, ny });
				distance[nx][ny] = distance[x][y] + 1;
			}
		}
		return -1;
	}
}
