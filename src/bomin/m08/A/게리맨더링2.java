package bomin.m08.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게리맨더링2 {
	static int[] population;
	static List<Integer>[] graph;
	static boolean[] visited;
	static boolean[] selected;
	static int[] group;
	static int answer = Integer.MAX_VALUE;
	static int N;
	static int populSum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		population = new int[N + 1];
		populSum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			populSum += population[i];
		}
		group = new int[N + 1];
		visited = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		selected = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count; j++) {
				graph[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 1; i <= N / 2; i++) {
			dfs(1, 0, i);

		}

	}

	// 경우의 수 만들기
	static void dfs(int cur, int depth, int target) {
		// target개의 조합 만들기
		if (depth == target) {
			// 선택되지 않은 지역은 2번 그룹
			for (int i = 1; i <= N; i++) {
				if (group[i] != 1) {
					group[i] = 2;
				}
			}
			// 각각 연결되어 있는지 확인
			boolean firstConnected = bfs(1);
			boolean secondConnected = bfs(2);

			if (firstConnected && secondConnected) {
				int firstSum = 0;
				for (int i = 1; i <= N; i++) {
					if (group[i] == 1) {
						firstSum += population[i];
					}
				}
				int secondSum = populSum - firstSum;
				answer = Math.min(answer, Math.abs(firstSum - secondSum));
			}

			// 2번 그룹으로 만들었던 지역 원상복구
			for (int i = 1; i <= N; i++) {
				if (group[i] == 2) {
					group[i] = 0;
				}
			}
			//종료
			return;
		}
		for (int i = cur; i <= N; i++) {
			group[i] = 1;
			dfs(i + 1, depth + 1, target);
			// 백트래킹
			group[i] = 0;
		}
	}

	// 연결되어 있나 체크하기
	static boolean bfs(int groupNum) {
		visited = new boolean[N + 1];
		int start = -1;

		for (int i = 1; i <= N; i++) {
			if (group[i] == groupNum) {
				start = i;
				break;
			}
		}
		Queue<Integer> Q = new ArrayDeque<>();
		Q.offer(start);
		visited[start] = true;

		while (!Q.isEmpty()) {
			int cur = Q.poll();
			for (int next : graph[cur]) {
				if (visited[next])
					continue;

				if (group[next] != groupNum)
					continue;

				visited[next] = true;
				Q.offer(next);
			}
		}
		for (int i = 1; i <= N; i++) {
			if (group[i] == groupNum && !visited[i]) {
				return false;
			}
		}
		return true;

	}

}
