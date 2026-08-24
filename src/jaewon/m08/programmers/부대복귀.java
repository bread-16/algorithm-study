package jaewon.m08.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 부대복귀 {

	static List<Integer>[] graph;
	static int[] dist;

	public int[] solution(int n, int[][] roads, int[] sources, int destination) {
		int[] answer = new int[sources.length];

		graph = new ArrayList[n + 1];
		dist = new int[n + 1];
		Arrays.fill(dist, -1);

		// 모든 정점의 인접 리스트 초기화
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		// 양방향 간선 추가
		for (int[] road : roads) {
			addEdge(road[0], road[1]);
		}

		// 목적지로부터 모든 정점 최단거리 계산
		bfs(destination);

		for (int i = 0; i < sources.length; i++) {
			answer[i] = dist[sources[i]];
		}

		return answer;

	}

	static void addEdge(int a, int b) {
		graph[a].add(b);
		graph[b].add(a);
	}

	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();

		dist[start] = 0;
		q.offer(start);

		while (!q.isEmpty()) {
			int current = q.poll();

			for (int next : graph[current]) {
				// 정점을 한번도 방문하지 않았다면 갱신
				if (dist[next] == -1) {
					dist[next] = dist[current] + 1;
					q.offer(next);
				}
			}
		}

	}

}
