package jinyoung.m08.programmers;

import java.util.*;

public class BFS_퍼즐조각채우기 {

	Deque<int[]> deque = new ArrayDeque<>();
	int[] dx = { 0, 1, 0, -1 };
	int[] dy = { 1, 0, -1, 0 };
	List<List<int[]>> puzzle = new ArrayList<>();
	List<List<int[]>> board = new ArrayList<>();

	public List<int[]> rotate(List<int[]> piece) {
		List<int[]> rotated = new ArrayList<>();

		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;

		for (int[] point : piece) {
			int x = point[0];
			int y = point[1];

			int nx = y;
			int ny = -x;

			rotated.add(new int[] { nx, ny });

			minX = Math.min(minX, nx);
			minY = Math.min(minY, ny);
		}

		for (int[] point : rotated) {
			point[0] -= minX;
			point[1] -= minY;
		}

		return rotated;
	}

	public boolean isSame(List<int[]> a, List<int[]> b) {
		if (a.size() != b.size()) {
			return false;
		}

		a.sort((p1, p2) -> {
			if (p1[0] == p2[0]) {
				return p1[1] - p2[1];
			}
			return p1[0] - p2[0];
		});

		b.sort((p1, p2) -> {
			if (p1[0] == p2[0]) {
				return p1[1] - p2[1];
			}
			return p1[0] - p2[0];
		});

		for (int i = 0; i < a.size(); i++) {
			if (a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) {
				return false;
			}
		}

		return true;
	}

	public int solution(int[][] game_board, int[][] table) {
		int answer = -1;
		int n = table.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (table[i][j] == 1) {
					List<int[]> piece = new ArrayList<>();
					int minX = Integer.MAX_VALUE;
					int minY = Integer.MAX_VALUE;
					table[i][j] = 0;
					minX = Math.min(minX, i);
					minY = Math.min(minY, j);
					piece.add(new int[] { i, j });
					deque.offer(new int[] { i, j });
					while (!deque.isEmpty()) {

						int[] current = deque.poll();
						int x = current[0];
						int y = current[1];

						for (int dir = 0; dir < 4; dir++) {
							int nx = x + dx[dir];
							int ny = y + dy[dir];
							if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
								continue;
							}
							if (table[nx][ny] == 0) {
								continue;
							}
							table[nx][ny] = 0;
							minX = Math.min(minX, nx);
							minY = Math.min(minY, ny);
							piece.add(new int[] { nx, ny });
							deque.offer(new int[] { nx, ny });
						}
					}
					for (int k = 0; k < piece.size(); k++) {
						piece.get(k)[0] -= minX;
						piece.get(k)[1] -= minY;
					}
					puzzle.add(piece);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (game_board[i][j] == 0) {
					List<int[]> boardPiece = new ArrayList<>();
					int minX = Integer.MAX_VALUE;
					int minY = Integer.MAX_VALUE;
					game_board[i][j] = 1;
					minX = Math.min(minX, i);
					minY = Math.min(minY, j);
					boardPiece.add(new int[] { i, j });
					deque.offer(new int[] { i, j });
					while (!deque.isEmpty()) {

						int[] current = deque.poll();
						int x = current[0];
						int y = current[1];

						for (int dir = 0; dir < 4; dir++) {
							int nx = x + dx[dir];
							int ny = y + dy[dir];
							if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
								continue;
							}
							if (game_board[nx][ny] == 1) {
								continue;
							}
							game_board[nx][ny] = 1;
							minX = Math.min(minX, nx);
							minY = Math.min(minY, ny);
							boardPiece.add(new int[] { nx, ny });
							deque.offer(new int[] { nx, ny });
						}
					}
					for (int k = 0; k < boardPiece.size(); k++) {
						boardPiece.get(k)[0] -= minX;
						boardPiece.get(k)[1] -= minY;
					}
					board.add(boardPiece);
				}
			}
		}
		answer = 0;

		boolean[] used = new boolean[puzzle.size()];

		for (int i = 0; i < board.size(); i++) {
			List<int[]> hole = board.get(i);

			for (int j = 0; j < puzzle.size(); j++) {

				if (used[j]) {
					continue;
				}

				if (hole.size() != puzzle.get(j).size()) {
					continue;
				}

				List<int[]> current = puzzle.get(j);

				for (int r = 0; r < 4; r++) {

					if (isSame(hole, current)) {
						answer += hole.size();
						used[j] = true;
						break;
					}

					current = rotate(current);
				}

				if (used[j]) {
					break;
				}
			}
		}

		return answer;
	}
}