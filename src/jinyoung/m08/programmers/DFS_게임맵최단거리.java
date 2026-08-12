package jinyoung.m08.programmers;

import java.util.*;

public class DFS_게임맵최단거리 {
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };
	public static int n=5;
	public static int m=5;
	public static int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
			{ 0, 0, 0, 0, 1 } };
	public static boolean[][] visited;
	public static int min = Integer.MAX_VALUE;
	
	public static boolean checkBound(int x, int y) {
		return x>=0 && x<n && y>=0 && y<m;
	}
	
	
	public static void main(String[] args) {
		Deque<Integer[]> deque = new ArrayDeque<>();
		visited = new boolean[n][m];
		visited[0][0]=true;
		deque.offer(new Integer[]{0,0,1});
		
		while(!deque.isEmpty()) {
			Integer[] current = deque.poll();
			int x = current[0];
			int y = current[1];
			int dist=current[2];
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(x==n-1 && y==m-1) {
					System.out.println(dist);
					return;
				}
				
				if(!checkBound(nx,ny)) continue;
				
				if(visited[nx][ny]) continue;
				
				if(maps[nx][ny]==1) {
					visited[nx][ny]=true;
					deque.offer(new Integer[] {nx,ny,dist+1});
				}
			}
			
		}
	}
}


/*
//dfs로 풀었는데 시간초과
//최단거리는 bfs로....
public class DFS_게임맵최단거리 {
	// 우 하 좌 상
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };
	public static int n;
	public static int m;
	public static int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 },
			{ 0, 0, 0, 0, 1 } };
	public static boolean[][] visited;
	public static int min = Integer.MAX_VALUE;

	public static boolean checkBound(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}

	public static void dfs(int x, int y, int depth) {
		if (x == n - 1 && y == m - 1) {
			min = Math.min(min, depth);
			return;
		}
		if (depth>=min) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (checkBound(nx, ny)) {
				if (maps[nx][ny]==1 && visited[nx][ny] == false) {
					visited[nx][ny] = true;
					dfs(nx, ny, depth + 1);
					visited[nx][ny] = false;
				}
			}
		}
	}

	public static void main(String[] args) {

		int answer = 0;
		// 갈 수 없는 곳 true
		n=maps.length;
		m=maps[0].length;
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (maps[i][j] == 0) {
					visited[i][j] = true;
				}
			}
		}
		dfs(0, 0, 1);
		answer = (min == Integer.MAX_VALUE) ? -1 : min;
		System.out.println(answer);

	}
}
*/