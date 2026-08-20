package ohyeon.m07.swea;

import java.io.*;
import java.util.*;

public class SupplyLoad {
	static class Node implements Comparable<Node> {
        int r, c, cost;
 
        Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
 
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost); // 누적 복구 시간 기준 오름차순
        }
    }
     
    static int N;
    static int[][] map;
    static int[][] dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            dist = new int[N][N];
 
            for (int i = 0; i < N; i++) {
                String line = br.readLine().trim();
                Arrays.fill(dist[i], Integer.MAX_VALUE);
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }
 
            int answer = dijkstra();
            System.out.println("#" + t + " " + answer);
        }
    }
    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
         
        // 출발점 (0, 0) 초기화
        dist[0][0] = 0;
        pq.offer(new Node(0, 0, 0));
 
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
 
            // 목적지 도착 시 해당 최단 시간 반환
            if (curr.r == N - 1 && curr.c == N - 1) {
                return curr.cost;
            }
 
            // 이미 처리된 최단 거리보다 비용이 크다면 건너뜀
            if (curr.cost > dist[curr.r][curr.c]) continue;
 
            for (int d = 0; d < 4; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];
 
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    int nextCost = curr.cost + map[nr][nc];
 
                    // 더 짧은 경로를 찾은 경우 갱신 후 큐에 삽입
                    if (dist[nr][nc] > nextCost) {
                        dist[nr][nc] = nextCost;
                        pq.offer(new Node(nr, nc, nextCost));
                    }
                }
            }
        }
        return dist[N - 1][N - 1];
    }
}
