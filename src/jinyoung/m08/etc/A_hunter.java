package jinyoung.m08.etc;

import java.util.*;
import java.io.*;

public class A_hunter {
	public static int[][] targets;
	public static int totalTargets;

	// DFS 탐색을 위한 방문 및 상태 배열
	public static boolean[] visited; // 각 타깃 지점 방문 여부
	public static boolean[] killed; // 몬스터 처치 여부 (몬스터 번호 1~4 인덱스 사용)
	public static int minTime; // 최소 시간 정답 변수

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("hunter_50_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());

			targets = new int[8][3];
			totalTargets = 0;

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int val = Integer.parseInt(st.nextToken());
					if (val != 0) {
						targets[totalTargets][0] = i; // X 좌표
						targets[totalTargets][1] = j; // Y 좌표
						targets[totalTargets][2] = val; // ID (양수: 몬스터, 음수: 고객)
						totalTargets++;
					}
				}
			}
			visited = new boolean[totalTargets];
			killed = new boolean[5]; // 몬스터 번호는 1~4까지 존재하므로 크기 5 지정
			minTime = Integer.MAX_VALUE;

			// 헌터의 시작점 (0, 0)에서 DFS 탐색 시작 (현재까지 방문한 타깃 0개, 누적 시간 0)
			dfs(0, 0, 0, 0);
			sb.append("#").append(test_case).append(" ").append(minTime).append("\n");
		}
		System.out.print(sb);
	}

	public static void dfs(int curX, int curY, int count, int sumTime) {
		// 가지치기: 탐색 중 이미 누적 시간이 현재 최솟값 이상이면 더 볼 필요 없음
		if (sumTime >= minTime) {
			return;
		}

		// 모든 몬스터를 잡고 모든 고객에게 보고를 마친 경우
		if (count == totalTargets) {
			minTime = Math.min(minTime, sumTime);
			return;
		}

		// 다음으로 방문할 타깃 지점 고르기
		for (int i = 0; i < totalTargets; i++) {
			if (visited[i])
				continue; // 이미 방문한 곳은 제외

			int targetX = targets[i][0];
			int targetY = targets[i][1];
			int targetId = targets[i][2];

			// 현재 위치에서 다음 목적지까지의 맨해튼 거리 계산
			int dist = Math.abs(curX - targetX) + Math.abs(curY - targetY);

			// Case 1: 다음 목적지가 몬스터인 경우 (ID가 양수)
			if (targetId > 0) {
				visited[i] = true;
				killed[targetId] = true; // 몬스터 잡음 표시

				dfs(targetX, targetY, count + 1, sumTime + dist);

				// 백트래킹 원상 복구
				killed[targetId] = false;
				visited[i] = false;
			}
			// Case 2: 다음 목적지가 고객인 경우 (ID가 음수)
			else {
				int monsterId = -targetId; // 매칭되는 몬스터 번호 (예: -1번 고객 -> 1번 몬스터)

				// 핵심 조건: 해당 몬스터를 이전에 이미 잡았을 때만 고객 방문 가능
				if (killed[monsterId]) {
					visited[i] = true;

					dfs(targetX, targetY, count + 1, sumTime + dist);

					// 백트래킹 원상 복구
					visited[i] = false;
				}
			}
		}
	}
}

/*
 * public class A_hunter { // 우 하 좌 상 public static int[] dx = { 0, 1, 0, -1 };
 * public static int[] dy = { 1, 0, -1, 0 };
 * 
 * public static void main(String[] args) throws Exception { System.setIn(new
 * FileInputStream("hunter_50_input.txt"));
 * 
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * StringBuilder sb = new StringBuilder(); int T =
 * Integer.parseInt(br.readLine()); for (int test_case = 1; test_case <= T;
 * test_case++) { int n = Integer.parseInt(br.readLine()); int[][] arr = new
 * int[n][n];
 * 
 * for (int i = 0; i < n; i++) { StringTokenizer st = new
 * StringTokenizer(br.readLine()); for (int j = 0; j < n; j++) { arr[i][j] =
 * Integer.parseInt(st.nextToken()); } }
 * sb.append("#").append(test_case).append(" ");
 * 
 * int[] monster = new int[5]; int[] customer = new int[5]; int tmp=0;
 * Queue<int[]> q = new ArrayDeque<>(); boolean[][] visited = new boolean[n][n];
 * visited[0][0] = true; q.offer(new int[] { 0, 0, 0 }); while (!q.isEmpty()) {
 * int[] current = q.poll(); int x = current[0]; int y = current[1]; int result
 * = current[2]; if (arr[x][y] == 1) { tmp = result; } if (arr[x][y] == -1) {
 * sb.append(result-tmp).append("\n"); break; } for (int dir = 0; dir < 4;
 * dir++) { int nx = x + dx[dir]; int ny = y + dy[dir]; if (checkBound(nx, ny,
 * n)) { continue; } if (visited[nx][ny] == true) { continue; } //
 * System.out.println(nx+" "+ny); visited[nx][ny] = true; q.offer(new int[] {
 * nx, ny, result + 1 }); } } } System.out.println(sb);
 * 
 * }
 * 
 * public static boolean checkBound(int x, int y, int n) { return (x < 0 || x >=
 * n || y < 0 || y >= n); }
 * 
 * }
 */
