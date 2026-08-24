package dana.m08.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 헌터 {
	
	// static variables 
	static List<Creature> creatures; 
	static int result; 
	static boolean[] visited;
	static boolean[] isClear; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine()); 
			
			creatures = new ArrayList<>(); 
			
			// 맵 저장 할때 생명채 나오면 리스트에 추가 
			for (int i = 0; i < N; i++) {
				String line = br.readLine(); 
				StringTokenizer st = new StringTokenizer(line); 
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());  
					// 생명채가 아니면 저장 (음수, 양수)
					if (n != 0) {
						creatures.add(new Creature(i, j, n)); 
					}
				}
			}
			
			// 최종 걸린 시간 -> 답 
			result = Integer.MAX_VALUE; 
			// 방문여부 
			visited = new boolean[creatures.size()]; 
			// 몬스터 퇴치 여부 
			isClear = new boolean[creatures.size() / 2]; 
			// dfs 시작은 
			dfs(0, 0, 0, 0); 

			// 이 시점에서는 dfs가 다 끝나고 답이 나왔다 
			sb.append("#").append(tc).append(" ").append(result).append("\n"); 
		}
		System.out.print(sb.toString());
	}
	// 여기까지는 알겠다 
		
	// dfs 시작 
	// clear = 몬스터와 클라이언트 체크 숫자 
	static void dfs(int clear, int time, int r, int c) { 
		
		// 시간이 초과이면 끝내기 
		if (time > result) { 
			return; 
		}
		
		// 몬스터 퇴치, 의뢰 완료를 전부 끝냈을시 result 갱신 
		if (clear == creatures.size()) {
			result = Math.min(result, time); 
			return; 
		}
		
		// 크리처들을 하나씩 본다: 
		for (int i = 0; i < creatures.size(); i++) {
			// 이미 방문했다면 컨티뉴 
			if (visited[i]) {
				continue; 
			}

			Creature currentCreature = creatures.get(i); 
			
			// 만약 크리처가 클라이언트이면 -> 해당 몬스터 퇴치 안되어있으면 스킵 
			// 만약 현재 크리처가 몬스터 이면 -> 퇴치하기 -> isClear 갱신 

			if (currentCreature.type < 0) {
				if (!isClear[Math.abs(currentCreature.type)-1]) continue;
			} else {
				isClear[currentCreature.type - 1] = true;
			}
			
			visited[i] = true;
			dfs(clear + 1, time+(Math.abs(r-currentCreature.r) + Math.abs(c-currentCreature.c)), currentCreature.r, currentCreature.c); 
			visited[i] = false; 
			
			if (currentCreature.type > 0) {
				isClear[Math.abs(currentCreature.type)-1] = false; 
			}
		}
	}
	
	
	// Creatures class 
	static class Creature {
		int r;
		int c;
		int type;
		
		public Creature(int r, int c, int type) {
			this.r = r; 
			this.c = c; 
			this.type = type;
		}
	}
}

//public class 헌터 {
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
//		// 테케 수
//		int T = Integer.parseInt(br.readLine()); 
//		
//		for (int tc = 1; tc <= T; tc++) {
//			// 맵 크기 
//			int N = Integer.parseInt(br.readLine()); 
//			int[][] map = new int[N][N]; 
//			// 몬스터 개수 
//			int monsterCount = 0; 
//			// 맵 넣기 
//			for (int i = 0; i < N; i++) {
//				// 한줄씩 가져오기 
//				StringTokenizer st = new StringTokenizer(br.readLine());; 
//				for (int j = 0; j < N; j++) {
//					map[i][j] = Integer.parseInt(st.nextToken()); 
//					// 만약 양수면 몬스터 수 갱신해주기 
//					if (map[i][j] > 0) {
//						monsterCount++; 
//					}
//				}
//			}
//			// 인풋 끝 
//			
//
//			// 몬스터 찾음 / 안찾음 여부 
//			boolean[] monsterFound = new boolean[monsterCount]; 
//			// 고객을 만남 / 안만남 여부 
//			boolean[] clientMet = new boolean[monsterCount]; 
//			// BFS위한 visited array 
//			boolean[][] visited = new boolean[N][N]; 
//			// 각 노드가 탐색할 4방향 (up, down, left, right) 
//			int[] dr = {-1, 1, 0, 0};
//			int[] dc = {0, 0, -1, 1}; 
//			// BFS위한 queue 
//			// 각 노드: {row, col, time}
//			Queue<int[]> queue = new ArrayDeque<>(); 
//			// 시작점 넣고 시작하기 
//			queue.offer(new int[]{0, 0, 0}); 
//			// BFS 시작 
//			while(!queue.isEmpty()) {
//				int[] node = queue.poll(); 
//				int row = node[0]; 
//				int col = node[1];
//				int time = node[3]; 
//				// 만약 모든 고객을 만났으면 끝내기 
//				
//				// 4 방향 탐색하기 
//				/*
//				 * 몬스터이면 -> 잡기 
//				 * 고객이면 -> 해당몬스터 잡혔으면 -> 가기 
//				 * 		  -> 아니면 -> ? 
//				 * 
//				 * */
//				for (int d = 0; d < 4; d++) {
//					int nr = dr[d] + row; 
//					int nc = dc[d] + col; 
//					if (nr <= 0 && nr > N && nc <= 0 && nc > N) {
//						// 만약 고객이면 && 방문 안한 고객이면 
//						if (map[nr][nc] < 0 && !visited[nr][nc]) {
//							// 이 고객의 몬스터를 만났었는지 체크 -> 이 고객의 몬스터를 만났었어야지만 이 노드 방문 가능 
//							if (monsterFound(Math.abs(map[nr][nc]))) {
//								// visited 체크하기 
//								visited[nr][nc] = true; 
//								// 큐에 고객 노드 넣기 
//								queue.offer(new int[] {nr, nc, time + 1}); 
//							}
//						}
//					}
//				}
//			}
//		}
//		// end of test cases 
//	}
//
//}
