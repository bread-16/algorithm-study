package ohyeon.m08.pdf;

import java.util.*;
import java.io.*;

public class hunter {
	// 좌표를 저장할 클래스
    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N;
    static Point[] monsters;
    static Point[] clients;
    static int numPairs; // 몬스터-고객 쌍의 개수
    static int minDistance; // 정답(최단 거리)
    static boolean[] visitedMonster;
    static boolean[] visitedClient;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            
            // 몬스터와 고객의 쌍
            monsters = new Point[10]; 
            clients = new Point[10];
            numPairs = 0;
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    
                    if (val > 0) { // 양수: 몬스터
                        monsters[val] = new Point(i, j);
                        numPairs = Math.max(numPairs, val); // 최대 번호 갱신
                    } else if (val < 0) { // 음수: 고객
                        clients[-val] = new Point(i, j);
                    }
                }
            }

            minDistance = Integer.MAX_VALUE;
            visitedMonster = new boolean[numPairs + 1];
            visitedClient = new boolean[numPairs + 1];

            // 헌터는 항상 (0, 0) 위치에서 출발
            // dfs(현재 행, 현재 열, 누적 이동 거리, 완료한 타겟 수)
            dfs(0, 0, 0, 0);
            sb.append("#").append(tc).append(" ").append(minDistance).append("\n");
           
        }
        System.out.print(sb);
    }

    static void dfs(int currentR, int currentC, int dist, int count) {
        // [가지치기] 이미 현재까지의 거리가 최소 거리를 넘어섰다면 중단
        if (dist >= minDistance) return; 

        // 모든 몬스터와 고객(총 쌍의 2배)을 다 방문했다면 최소 거리 갱신
        if (count == numPairs * 2) { 
            minDistance = Math.min(minDistance, dist);
            return;
        }

        // 1. 몬스터를 방문하는 경우의 수 탐색
        for (int i = 1; i <= numPairs; i++) {
            if (!visitedMonster[i]) {
                visitedMonster[i] = true; // 방문 처리
                
                //거리 계산
                int moveDist = Math.abs(currentR - monsters[i].r) + Math.abs(currentC - monsters[i].c);
                dfs(monsters[i].r, monsters[i].c, dist + moveDist, count + 1);
                
                visitedMonster[i] = false; // 백트래킹 (원상 복구)
            }
        }

        // 2. 고객을 방문하는 경우의 수 탐색
        for (int i = 1; i <= numPairs; i++) {
            // 해당 번호의 몬스터를 이미 잡았고(visitedMonster[i] == true), 아직 고객을 방문하지 않았다면
            if (visitedMonster[i] && !visitedClient[i]) {
                visitedClient[i] = true; // 방문 처리
                
                //거리 계산
                int moveDist = Math.abs(currentR - clients[i].r) + Math.abs(currentC - clients[i].c);
                dfs(clients[i].r, clients[i].c, dist + moveDist, count + 1);
                
                visitedClient[i] = false; // 백트래킹 (원상 복구)
            }
        }
    }
}

