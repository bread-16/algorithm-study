package bomin.m08.A; 
 
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
 
public class 헌터 { 
	static int[][] monster; 
	static int[][] customer; 
	static int[][] root; 
	static boolean[] visited; 
	static int[][] map; 
	static int endDepth; 
	static int answer; 
	static int count; 
	static int monsterCount; 
 
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		int T = Integer.parseInt(br.readLine()); 
		
		//dfs -> 몬스터와 고객 전부 방문 완료 할 때 까지
		//거리계산 메서드 따로 넣어서 최소 거리 구하기.
		// 몬스터를 잡으면 같은 인덱스의 고객 해금. dfs 진행에 그대로 넣어주기.
		// 처음엔 리스트로 했다가, list.add는 현재 list.size()내에서만 인덱스를 넣을 수 있어서 int[][]로 변경.
		// root -> bfs의 루트 배열. 여기에 처음에 몬스터만 넣고, 몬스터를 잡으면 이제 그 자리에 customer넣음.
		
		
 
		// 맵 채우기 
		for (int tc = 1; tc <= T; tc++) { 
			int N = Integer.parseInt(br.readLine()); 
			map = new int[N][N]; 
			monster = new int[4][]; 
			customer = new int[4][]; 
			root = new int[4][]; 
			answer = Integer.MAX_VALUE; 
			count = 0; 
			monsterCount = 0; 
			for (int i = 0; i < N; i++) { 
				StringTokenizer st = new StringTokenizer(br.readLine()); 
				for (int j = 0; j < N; j++) { 
					map[i][j] = Integer.parseInt(st.nextToken()); 
					if (map[i][j] > 0) { 
						monster[map[i][j] - 1] = new int[] { i, j }; 
						monsterCount++; 
					} 
					if (map[i][j] < 0) { 
						customer[Math.abs(map[i][j]) - 1] = new int[] { i, j }; 
					} 
				} 
			} 
			for(int i = 0; i < monsterCount; i++) { 
				root[i] = monster[i]; 
			} 
			visited = new boolean[monsterCount]; 
			endDepth = monsterCount * 2; 
			dfs(0, new int[] { 0, 0 }); 
 
			sb.append("#").append(tc).append(" ").append(answer).append("\n"); 
 
		} 
		System.out.print(sb); 
	} 
 
	static void dfs(int depth, int[] start) { 
		if (depth == endDepth) { 
			answer = Math.min(answer, count); 
			return; 
		} 
		for (int i = 0; i < monsterCount; i++) { 
			//고객 방문까지 완료했다면
			if(root[i] == null) 
				continue; 
			 
			int distance = minDistance(start, root[i]); 
			count += distance; 
			// 아직 몬스터를 잡지 않았다면. 
			if (!visited[i]) { 
				//처음에 dfs(depth+1, root[i])했다가 root가 변경된 값으로 dfs가 실행되서, root[i]를 따로 변수에 저장하고, root값 변경.
				//visited => 몬스터 잡았는지 체크용.
				int[] next = root[i]; 
				root[i] = customer[i]; 
				visited[i] = true; 
				dfs(depth + 1, next); 
				//백트래킹 
				count -= distance; 
				root[i] = monster[i]; 
				visited[i] = false; 
			} else { 
				int[] next = root[i]; 
				//원래는 리스트.remove(i)로 고객 방문까지했으면 인덱스 지우려했으나, 이것도 dfs 돌면 인덱스에러가 떠서 root[i]에 그냥 null값 넣어서 구분하기.
				root[i] = null; 
				dfs(depth + 1, next); 
				root[i] = customer[i]; 
				count -= distance; 
			} 
 
		} 
	} 
 
	static int minDistance(int[] start, int[] end) { 
		int distance = 0; 
		// 세로차이, 가로차이 절댓값으로 거리계산 
		distance = Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]); 
 
		return distance; 
	} 
 
} 