package jaewon.m08.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 좌상단(S)->우하단(G)으로 가는 다익스트라 문제(가중치)
 * 이동 경로: 상하좌우 -> dr, dc 배열 활용
 * 1. 기존 맵과 똑같은 크기의 맵을 생성, 최대값으로 채움
 * 2. 시작점은 0으로 변환하고 BFS로 길찾기 -> 우선순위 큐 사용, 최소 비용 경로부터 찾기 
 * 3. 우선순위 큐에서 나올때 현재 가중치와 dist 가중치 비교,
 */

public class 보급로 {

	static int[][] map;
	static int[][] dist;
	static int N;

	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			// 맵 크기 N 입력
			N = Integer.parseInt(in.readLine());
			// map, dist 초기화
			map = new int[N][N];
			dist = new int[N][N];
			int answer = 0;

			// 보급로 맵 채우기
			for (int i = 0; i < N; i++) {
				String line = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
			}
			// 가중치 맵 채우기
			for (int[] row : dist) {
				Arrays.fill(row, Integer.MAX_VALUE);
			}

			// 시작점 초기화. 항상 0으로 시작해서 0으로 넣어도 상관 없지만 명시적으로 작성
			dist[0][0] = map[0][0];

			// {가중치, 행, 열}로 우선순위 큐 삽입
			PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
			pq.offer(new int[] { map[0][0], 0, 0 });

			while (!pq.isEmpty()) {
				int cur[] = pq.poll();
				// 현재 칸의 가중치, 행, 열
				int distance = cur[0];
				int curRow = cur[1];
				int curCol = cur[2];

				// 이미 갱신된 가중치가 작으면 현재 가중치 스킵
				if (distance > dist[curRow][curCol]) {
					continue;
				}
				// 도착지면 종료
				if (curRow == N - 1 && curCol == N - 1) {
					answer = distance;
					break;
				}

				// 현재 위치에서 4방향 탐색
				for (int d = 0; d < 4; d++) {
					int nextRow = curRow + dr[d];
					int nextCol = curCol + dc[d];
					// 다음 칸이 범위 밖이면 스킵
					if (!isIn(nextRow, nextCol))
						continue;

					// 다음 칸의 거리 계산. 출발지부터 다음 칸의 거리까지 가중치가 기존보다 작다면 갱신 및 우선순위 큐 삽입
					int candidate = distance + map[nextRow][nextCol];
					if (candidate < dist[nextRow][nextCol]) {
						dist[nextRow][nextCol] = candidate;
						pq.offer(new int[] { candidate, nextRow, nextCol });
					}

				}

			}

			sb.append("#").append(testCase).append(" ").append(answer).append("\n");

		}
		System.out.println(sb);

	}

	// 범위 계산
	public static boolean isIn(int nextRow, int nextCol) {
		if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N)
			return false;

		return true;
	}

}
