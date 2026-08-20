package jinwoo.m07.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SupplyRoute {
	
	static int arrLen;
	static int[] dx = {-1, 0 , 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case=1; test_case <= T; test_case++) {
			
			arrLen = Integer.parseInt(in.readLine());
			
			int[][] map = new int[arrLen][arrLen];
			// 맵에 숫자 담기
			for(int i = 0; i < arrLen; i++) {
			    String numbers = in.readLine();

			    for(int j = 0; j < arrLen; j++) {
			        map[i][j] = numbers.charAt(j) - '0';
			    }
			}
			
			// 복구 시간 담는 맵
			int[][] costsMap = new int[arrLen][arrLen];
			
			// 다익스트라를 위한 인트 최대값으로 채우기
			for(int i=0; i<arrLen; i++) {
				Arrays.fill(costsMap[i], Integer.MAX_VALUE);
			}
			
			PriorityQueue<EngineerCorps> pq = new PriorityQueue<>();
			
			// 시작점의 EngineerCorps 생성( 위치 0,0 cost 0)
			EngineerCorps ec = new EngineerCorps(0,0,0);
			
			// 우선순위 큐에 담기
			pq.offer(ec);
			
			// 시작점 초기화
			costsMap[0][0] = 0;
			
			while(!pq.isEmpty()) {
				EngineerCorps e = pq.poll();
				
				int x = e.r;
				int y = e.c;
				int nowCost = e.cost;
				// 현재 비용이 costsMap의 비용보다 크면 넘어가기
				if(costsMap[x][y] < nowCost) continue;
				
				for(int i=0; i<4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					// 배열 범위 밖 감지하는 메소드
					if(!inRange(nx, ny))continue;
					
					// 만약 해당 경로까지의 비용이 등록되어있는 다른 경로의 비용보다 작으면 비용 교체
					// 비용 교체 후 우선순위 큐에 담기
					if(costsMap[nx][ny] > nowCost + map[nx][ny]) {
						costsMap[nx][ny] = nowCost + map[nx][ny];
						
						pq.offer(new EngineerCorps(nx, ny, costsMap[nx][ny]));
					}
					
				}
			}
			
			int result = costsMap[arrLen - 1][arrLen - 1];
			
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
 		}
		System.out.println(sb.toString());
	}
	// 우선순위 큐에 담기 위한 class 지금 존재하는 좌표와, 해당 좌표까지 오기의 비용을 담고 있음
	static class EngineerCorps implements Comparable<EngineerCorps>{

		int r;
		int c;
		int cost;
		
		EngineerCorps(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		// 우선순위 큐를 위한 오버라이딩
		// 작은걸 우선으로 꺼내기 위한 오름차순
		// 내림차순으로 하고싶다면 
		// Integer.compare(o.cost, this.cost);
		// 다만 내림차순은 다익스트라 기본 구현에 맞지 않음
		@Override
		public int compareTo(EngineerCorps o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}
	// 배열 범위를 벗어났는지 체크하는 메서드
	static boolean inRange(int x, int y) {		
		return !(x < 0 || x >= arrLen || y < 0 || y >= arrLen);
	}
	
}


