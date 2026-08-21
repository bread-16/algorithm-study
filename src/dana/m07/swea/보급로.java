package dana.m07.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 보급로 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//	테스트 케이스 수 
		int T = Integer.parseInt(br.readLine()); 
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			// 맵 사이즈 N 
			int N = Integer.parseInt(br.readLine()); 
			
			// 맵 = 가중치 정보를 담은 배열 
			int[][] map = new int[N][N];
			
			// 맵을 가중치로 채우기
			for (int i = 0; i < N; i++) {
				// 한줄씩 읽기 
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
			}
			
			// 최단 거리를 저장할 배열 
			int[][] distance = new int[N][N]; 
			
			// 다 INF로 초기화 하기 
			int INF = Integer.MAX_VALUE; 
			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], INF);
			}
			
			// 다익스트라를 위한 priority queue 
			// {가중치, row, col}
			PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])); 
			
			// 시작점 거리 distance에 업데이트 하기 
			distance[0][0] = 0; 
			
			// 큐에 시작 점 넣기 
			queue.offer(new int[] {0, 0, 0}); 
			// 여기까지가 다익스트라 시작 전 준비 완료 시점 
			
			
			// 다익스트라 알고리즘 시작 
			
			// 4 디렉션 (up, down, left, right)
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1}; 
			
			while(!queue.isEmpty()) {
				
				// 큐에서 노드 하나 빼기 
				int[] node = queue.poll();
				int cost = node[0];
				int r = node[1];
				int c = node[2]; 
				
				// 현재 노드의 neighbour 4개 탐색하기 
				for (int d = 0; d < 4; d++) {
					// 다음 노드가 out of range가 아니면
					int nr = dr[d] + r;
					int nc = dc[d] + c;
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						// 다음노드까지의 가중치 계산 
						int newCost = cost + map[nr][nc]; 
						// 만약 newCost가 최단 거리이면 갱신 
						// 그리고 큐에 넣기 
						if (newCost < distance[nr][nc]) {
							distance[nr][nc] = newCost; 
							queue.offer(new int[] {newCost, nr, nc}); 
						}
					}
				}
			}
			
			// 답 출력 
			System.out.println("#" + test_case + " " + distance[N-1][N-1]);  
		}
	}
}
