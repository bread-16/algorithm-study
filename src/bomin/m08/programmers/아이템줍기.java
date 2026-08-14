package bomin.m08.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

class 아이템줍기 {

	int[][] rectangle;
	int[][] path;
	int[][] dis;

	int[] dr = { 1, 0, -1, 0 };
	int[] dc = { 0, 1, 0, -1 };

	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

		this.rectangle = rectangle;
		int re = rectangle.length;

		path = new int[102][102];
		dis = new int[102][102];

		// 1. 모든 사각형의 좌표를 2배해서 전체 영역을 1로 채움
		for (int i = 0; i < re; i++) {

			for (int j = rectangle[i][0] * 2;
					j <= rectangle[i][2] * 2;
					j++) {

				for (int k = rectangle[i][1] * 2;
						k <= rectangle[i][3] * 2;
						k++) {

					path[j][k] = 1;
				}
			}
		}

		// 2. 모든 사각형의 테두리를 제외한 내부를 0으로 변경
		for (int i = 0; i < re; i++) {

			for (int j = rectangle[i][0] * 2 + 1;
					j < rectangle[i][2] * 2;
					j++) {

				for (int k = rectangle[i][1] * 2 + 1;
						k < rectangle[i][3] * 2;
						k++) {

					path[j][k] = 0;
				}
			}
		}

		// 3. 시작점 방문 처리
		int startX = characterX * 2;
		int startY = characterY * 2;

		path[startX][startY] = 0;
		dis[startX][startY] = 0;

		int r = path.length;
		int c = path[0].length;

		Queue<int[]> Q = new ArrayDeque<>();
		Q.offer(new int[] { startX, startY });

		// 4. BFS
		while (!Q.isEmpty()) {

			int[] temp = Q.poll();

			for (int i = 0; i < 4; i++) {

				int nx = temp[0] + dr[i];
				int ny = temp[1] + dc[i];

				// 범위 벗어나면 넘어감
				if (nx < 0 || nx >= r || ny < 0 || ny >= c)
					continue;

				// 테두리가 아니거나 이미 방문했다면 넘어감
				if (path[nx][ny] != 1)
					continue;

				// 방문 처리
				path[nx][ny] = 0;

				Q.offer(new int[] { nx, ny });

				dis[nx][ny] = dis[temp[0]][temp[1]] + 1;
			}
		}

		// 좌표를 2배했으므로 실제 거리는 / 2
		return dis[itemX * 2][itemY * 2] / 2;
	}
}