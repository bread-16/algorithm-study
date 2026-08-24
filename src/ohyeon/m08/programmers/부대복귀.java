package ohyeon.m08.programmers;

import java.util.*;

public class 부대복귀 {
	static class Node implements Comparable <Node> {
        int currNode, cost;
        
        Node(int currNode, int cost) {
            this.currNode = currNode;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    static List<List<Integer>> graph;
    static int N;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        N = n;
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        int[] answer = new int[sources.length];
        
        for (int i = 0; i <sources.length; i++) {
            answer[i] = dijkstra(sources[i], destination);
        }
        
        return answer;
    }
    
    static int dijkstra(int start, int target) {
        int[] dist = new int[N + 1]; 
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            
            if(curr.currNode == target) {
                return curr.cost;
            }
            
            if(curr.cost > dist[curr.currNode]) continue;
            
            for (int next : graph.get(curr.currNode)) {
                if (dist[next] > curr.cost + 1) {
                    dist[next] = curr.cost + 1;
                    pq.offer(new Node(next, dist[next]));
                }
            }
        }
        
        return dist[target] == Integer.MAX_VALUE ? -1 : dist[target];
    }
}

/* 더 좋은 방법
import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 1. 인접 리스트로 양방향 그래프 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        // 2. 거리 배열 -1로 초기화 (미방문 상태 표시)
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        // 3. destination에서 역으로 출발하는 BFS
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(destination);
        dist[destination] = 0; // 자기 자신의 거리는 0
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (int next : graph.get(curr)) {
                // 아직 방문하지 않은 노드라면 거리 갱신 후 큐에 삽입
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    queue.offer(next);
                }
            }
        }
        
        // 4. 각 sources에 해당하는 최단 거리 결과 배열 생성
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
}
**/
