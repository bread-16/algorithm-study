package giseon.m08.programmers;

import java.util.*;

class 부대복귀 {

    static final int INF = 1000000000;

    public int[] solution(int n, int[][] roads, int[] srcs, int dest) {
        int[] answer = new int[srcs.length];

        Queue<Integer> q = new ArrayDeque<>();
        // 각 노드별 dest로부터의 거리를 저장할 배열 선언
        // dist[dest] = 0으로 시작할 수 있게 나머지는 INF로 초기화
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[dest] = 0;

        // 인접 리스트 구현
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        // 양방향 간선이므로 인접한 각 노드에 추가해준다.
        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];

            graph[a].add(b);
            graph[b].add(a);
        }

        // BFS
        // dest에서 각 srcs까지 최단거리를 구하는 것
        // dest부터 출발
        q.offer(dest);
        while (!q.isEmpty()) {
            int cur = q.poll();
            // 인접한 노드들을 순회하며 큐에 넣는다.
            // 각 노드별 인접 리스트를 순회하며 거리를 갱신한다.
            for (int next : graph[cur]) {
                if (dist[next] == INF) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }

        for (int i = 0; i < srcs.length; i++) {
            // 만약 거리가 INF라면 answer에는 -1를 넣는다.
            int s = srcs[i];
            if (dist[s] == INF) {
                answer[i] = -1;
            } else {
                answer[i] = dist[s];
            }
        }

        return answer;
    }
}
