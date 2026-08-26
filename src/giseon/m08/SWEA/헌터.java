package giseon.m08.SWEA;

import java.util.*;
import java.io.*;

public class 헌터 {

	static final int INF = 1000000000; // 거리(시간) 최솟값을 구해야하므로 answer 초기값 설정을 위한 값
	
    static int[][] monsters; // 몬스터 위치 저장할 배열
    static int[][] customers; // 고객 위치 저장할 배열
    static int mobCount; // 몬스터, 고객들만 탐색할 수 있도록 몬스터 수 미리 세놓고 dfs 반복문에서 반복 덜하게 설정
    static boolean[] hunted; // 몬스터 사냥 여부
    static boolean[] visited; // 고객에게 보고했는지 여부
    static StringBuilder sb;
    static int answer;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            // 맵 크기 입력
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            
            // 각 몬스터, 고객의 위치정보를 저장할 배열 각 요소가 {i, j} 형식으로 저장됨
            // 몬스터 수 최대 4(고객도 똑같은 수)이므로 5로 설정해서 1~4번 인덱스 사용
            monsters = new int[5][2];
            customers = new int[5][2];
            answer = INF;
        	mobCount = 0;
            
            // 입력받으면서 0이 아닌 값을 받았을 때 바로 i, j를 배열에 저장(양수면 몬스터, 음수면 고객)
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int point = Integer.parseInt(st.nextToken());
                    if(point > 0) { // 양수면 몬스터이므로 좌표를 몬스터 배열에 저장
                        monsters[point][0] = i;
                        monsters[point][1] = j;
                        mobCount++;
                    } else if (point < 0){ // 음수면 고객이므로 좌표를 고객 배열에 저장
                        customers[-point][0] = i;
                        customers[-point][1] = j;
                    } else {
                        continue;
                    }
                }
            }
                 
            // 몬스터 사냥여부, 고객 집 방문 여부
            hunted = new boolean[5];
            visited = new boolean[5];
            
            // 몬스터부터 잡기 시작해서 모든 경우의 수 탐색
            dfs(0, 0, 0, 0); // 시작점 0, 0 / 깊이 0, 거리 0
            
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
    public static void dfs(int x, int y, int depth, int dist) {
        if (dist >= answer) { // 이번에 구한 거리가 이전에 구한 것보다 커지는 순간은 더이상 안봐도 되므로 종료시키기 
        	return;
        }
    	
    	if (depth == mobCount * 2) { // 몹, 고객 다 돌면 끝내기            
            if (answer > dist) answer = dist; // 거리 최소로 갱신
            return;
        }
        
        int move = 0;
        for (int i = 1; i <= mobCount; i++) {
        	// 몬스터를 잡지 않은 상태라면 몬스터 잡고 시작
            if (!hunted[i]) {
                move = Math.abs(x - monsters[i][0]) + Math.abs(y - monsters[i][1]); // 가로 세로 방향으로만 이동하므로 맨해튼 거리
                hunted[i] = true;
                dfs(monsters[i][0], monsters[i][1], depth+1, dist + move); // 몬스터 있는 위치로 이동
                hunted[i] = false;
            }    
            // 몬스터를 잡은 상태에서 고객 방문하지 않았을때 고객 방문
            if (hunted[i] && !visited[i]) {
            	move = Math.abs(x - customers[i][0]) + Math.abs(y - customers[i][1]);
            	visited[i] = true;
            	dfs(customers[i][0], customers[i][1], depth+1, dist + move);
            	visited[i] = false;
            }
        }
    }
}
