package jaewon.m09.baekjoon;

import java.io.*;
import java.util.*;

public class 게리맨더링 {

	static int N;
	static int[] population;
	static List<Integer>[] graph;

	// true = A 선거구, false = B 선거구
	static boolean[] selected;
	static boolean[] visited;

	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		population = new int[N + 1];
		selected = new boolean[N + 1];
		graph = new ArrayList[N + 1];

		// 인구수 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		// 인접 리스트 초기화
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		// 그래프 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			int count = Integer.parseInt(st.nextToken());

			for (int j = 0; j < count; j++) {
				int next = Integer.parseInt(st.nextToken());
				graph[i].add(next);
			}
		}

		// 1번 구역부터 A/B 선거구 배정 시작
		divide(1);

		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	// 1. 재귀 DFS
	// 각 구역을 A 또는 B 선거구에 배정
	static void divide(int idx) {

		// 모든 구역 배정 완료
		if (idx == N + 1) {
			check();
			return;
		}

		// 현재 구역을 A 선거구에 넣기
		selected[idx] = true;
		divide(idx + 1);

		// 현재 구역을 B 선거구에 넣기
		selected[idx] = false;
		divide(idx + 1);
	}

	// 현재 만들어진 선거구 분할이 유효한지 검사
	static void check() {

		int startA = -1;
		int startB = -1;

		int countA = 0;
		int countB = 0;

		int sumA = 0;
		int sumB = 0;

		// A/B 선거구 정보 계산
		for (int i = 1; i <= N; i++) {

			if (selected[i]) {
				startA = i;
				countA++;
				sumA += population[i];
			} else {
				startB = i;
				countB++;
				sumB += population[i];
			}
		}

		// 둘 중 하나라도 비어 있으면 불가능
		if (countA == 0 || countB == 0) {
			return;
		}

		// A 선거구 연결성 검사
		visited = new boolean[N + 1];

		int connectedA = dfs(startA, true);

		if (connectedA != countA) {
			return;
		}

		// B 선거구 연결성 검사
		visited = new boolean[N + 1];

		int connectedB = dfs(startB, false);

		if (connectedB != countB) {
			return;
		}

		// 두 선거구 모두 연결되어 있음
		int diff = Math.abs(sumA - sumB);

		answer = Math.min(answer, diff);
	}

	// 2. 연결성 확인 DFS
	// 같은 선거구에 속한 구역만 탐색
	static int dfs(int cur, boolean group) {

		visited[cur] = true;

		int count = 1;

		for (int next : graph[cur]) {

			// 이미 방문함
			if (visited[next]) {
				continue;
			}

			// 다른 선거구라면 이동하지 않음
			if (selected[next] != group) {
				continue;
			}

			count += dfs(next, group);
		}

		return count;
	}
}