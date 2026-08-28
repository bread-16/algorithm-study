package jaewon.m08.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 미로1 {

	static int startX;
	static int startY;
	static int endX;
	static int endY;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] map = new int[16][16];
		// 우 하 좌 상
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		for (int testCase = 1; testCase <= 10; testCase++) {
			in.readLine();

			Queue<int[]> q = new ArrayDeque<>();
			boolean[][] visited = new boolean[16][16];

			for (int i = 0; i < 16; i++) {
				String line = in.readLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = line.charAt(j) - '0';
					if (map[i][j] == 2) {
						startX = i;
						startY = j;
					} else if (map[i][j] == 3) {
						endX = i;
						endY = j;
					}
				}
			}

			q.offer(new int[] { startX, startY });
			visited[startX][startY] = true;

			int answer = 0;

			while (!q.isEmpty()) {
				int[] current = q.poll();
				int currentX = current[0];
				int currentY = current[1];

				if (currentX == endX && currentY == endY) {
					answer = 1;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nextX = currentX + dr[i];
					int nextY = currentY + dc[i];

					if (isRange(nextX, nextY)) continue;
					if (visited[nextX][nextY]) continue;
					if (map[nextX][nextY] == 1) continue;

					visited[nextX][nextY] = true;
					q.offer(new int[] { nextX, nextY });
				}
			}

			sb.append('#').append(testCase).append(' ').append(answer).append('\n');
		}

		System.out.print(sb);
	}
	
	public static boolean isRange(int nextX, int nextY) {
		if (nextX < 0 || nextX >= 16 || nextY < 0 || nextY >= 16) return true;
		return false;
	}
	
}