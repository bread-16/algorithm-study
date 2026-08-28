package jinwoo.m08.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SWEA1226 {
	static int[][] map;
	static int[] start;
	static boolean[][] visited;
	static Deque<int[]> dq;
	static int answer;
	// 우하좌상
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<10; t++) {
			int T = Integer.parseInt(in.readLine());
			
			map = new int[16][16];
			visited = new boolean[16][16];
			start = new int[2];
			answer = 0;
			dq = new ArrayDeque<>();
					
			for(int i=0; i<16; i++) {
				String arr = in.readLine();
				for(int j=0; j<16; j++) {
					map[i][j] = arr.charAt(j) - '0';
					if(map[i][j] == 2) {
						start[0] = i;
						start[1] = j;
						visited[i][j] = true;
					} 
				}
			}
			
			dq.offer(start);
			bfs();
			
			sb.append("#").append(T).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs() {
		
		while(!dq.isEmpty()) {
			int[] node = dq.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node[0] + dx[i];
				int ny = node[1] + dy[i];
				
				if(!inRange(nx,ny)) continue;
				if(visited[nx][ny])continue;
				if(map[nx][ny] == 1) continue;
				
				visited[nx][ny] = true;
				
				if(map[nx][ny] == 3) {
					answer = 1;
					return;
				}
				dq.offer(new int[]{nx,ny});
			}
		}
	}
	
	public static boolean inRange(int r, int c) {
		return (r>=0 && r<16 && c>=0 && c<16);
	}
}
