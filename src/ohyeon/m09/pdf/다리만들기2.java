package ohyeon.m09.pdf;

import java.io.*;
import java.util.*;

public class 다리만들기2 {
	static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int islandCount = 1;
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int u, v, weight;
        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static List<Edge> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // BFS를 이용한 섬 번호 매기기 (2부터 시작)
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    islandCount++;
                    bfs(i, j, islandCount);
                }
            }
        }
        islandCount--; // 총 섬의 개수

        // 가능한 모든 다리(간선) 찾기
        edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 1) {
                    makeBridge(i, j, map[i][j]);
                }
            }
        }

        // 크루스칼 알고리즘을 위한 유니온-파인드 초기화
        Collections.sort(edges);
        parent = new int[islandCount + 2];
        for (int i = 2; i <= islandCount + 1; i++) {
            parent[i] = i;
        }

        // MST(최소 신장 트리) 구성
        int totalCost = 0;
        int edgeCount = 0;
        for (Edge edge : edges) {
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                totalCost += edge.weight;
                edgeCount++;
            }
        }

        // 결과 출력 (모든 섬이 연결되었다면 비용 출력, 아니면 -1)
        if (edgeCount == islandCount - 1 && islandCount > 0) {
            System.out.println(totalCost);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs(int r, int c, int id) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;
        map[r][c] = id;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (map[nr][nc] == 1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        map[nr][nc] = id;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }

    static void makeBridge(int r, int c, int id) {
        for (int i = 0; i < 4; i++) {
            int nr = r;
            int nc = c;
            int len = 0;

            while (true) {
                nr += dr[i];
                nc += dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) break;
                if (map[nr][nc] == id) break; // 같은 섬이면 중단

                if (map[nr][nc] == 0) {
                    len++;
                } else {
                    // 다른 섬에 도달
                    int targetId = map[nr][nc];
                    if (len >= 2) { // 다리 길이는 2 이상이어야 함
                        edges.add(new Edge(id, targetId, len));
                    }
                    break;
                }
            }
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}
