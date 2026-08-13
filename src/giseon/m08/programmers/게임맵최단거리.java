package giseon.m08.programmers;

import java.util.*;

//0.04ms, 81.7MB
class 게임맵최단거리 {
 // 탐색할 게임 맵
 int[][] maps;
 // 맵의 노드별 방문 여부 체크
 boolean[][] visited;
 // 탐색 방향을 동서남북 방향으로 설정
 int[] dr = {0, 0, 1, -1};
 int[] dc = {1, -1, 0, 0};
 // bfs로 탐색할 것이므로 queue 자료구조 선택
 Queue<int[]> q = new ArrayDeque<>();
 // 각 노드별 시작점으로부터의 거리를 저장
 int[][] dist;

 public int solution(int[][] maps) {
     this.maps = maps;
     this.visited = new boolean[maps.length][maps[0].length];
     this.dist = new int[maps.length][maps[0].length];
     // 거리를 싹다 -1로 채운다. 이러면 못가는 영역은 자연스럽게 -1이 됨
     for (int i = 0; i < maps.length; i++) {
         Arrays.fill(dist[i], -1);
     }
     int answer = 0;
     
     // bfs로 각 노드별로 시작점으로부터 거리를 기록한다. -> 최종 도달지는 최단거리
     
     // 출발지점 노드를 먼저 방문하게 한다.
     q.offer(new int[]{0, 0});
     visited[0][0] = true;
     dist[0][0] = 1; // 시작점 거리를 0으로 하고 탐색할때 마다 각 노드의 위치별로 더해가면서 거리 계산
     // maps를 탐색할 인덱스 변수(dr, dc로 더해가면서 인접 노드 탐색)
     int nr;
     int nc;
     while(!q.isEmpty()) {
         // 방문한 노드를 큐에서 꺼낸다.
         int[] node = q.poll();
         // 방문한 노드의 인접 노드들을 방문한다.
         for (int i = 0; i < 4; i++) {
             nr = node[0] + dr[i];
             nc = node[1] + dc[i];
             // 탐색 범위를 벗어나면 건너뛴다.
             if (nr < 0 || nr >= maps.length || nc < 0 || nc >= maps[0].length) {
                 continue;
             } else if (maps[nr][nc] == 1) { // 값이 1이고 탐색 범위 내면 방문 여부를 확인한다.
                 if (!visited[nr][nc]) { // 방문하지 않았다면 방문으로 표시하고 시작점~그 노드로부터 
                     visited[nr][nc] = true; // 방문 표시
                     dist[nr][nc] = dist[node[0]][node[1]] + 1; // 거리: 꺼낸 노드의 거리+1
                     q.offer(new int[]{nr, nc}); // 큐에 다음으로 탐색할 노드를 넣는다.
                 } else { continue; } // 이미 방문했어도 건너뛴다.
             }
         }
     }
     // 
     // 상대 진영의 dist 값이 -1이면 못간거니까 -1 (처음 생각 이거였음: 상대 진영에 도착할 수 없으면(상대 진영의 인접한 북, 서 노드 값이 벽이면) -1 리턴)
     if (dist[maps.length - 1][maps[0].length - 1] == -1) {
         answer = -1;
     } else {
         answer = dist[maps.length - 1][maps[0].length - 1];
     }
     return answer;
 }
}
