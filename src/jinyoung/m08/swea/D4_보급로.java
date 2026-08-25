package jinyoung.m08.swea;

import java.util.*;
import java.io.*;

public class D4_보급로 {
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };
	public static boolean[][] visited;
	public static int n;
	public static int min;
	public static int[][] arr;
	public static int[][] ans;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				String[] temp = br.readLine().split("");
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(temp[j]);
				}
			}

			min = Integer.MAX_VALUE;
			visited = new boolean[n][n];
			ans = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					ans[i][j] = Integer.MAX_VALUE;
				}
			}
			ans[0][0] = 0;
			bfs(0, 0);
			System.out.println("#" + test_case + " " + min);
		}
		br.close();
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[x][y] = true;
		q.offer(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] current = q.poll();
			int a = current[0];
			int b = current[1];
			if (a == n - 1 && b == n - 1) {
				min = Math.min(min, ans[n - 1][n - 1]);
			}
			if (min <= ans[a][b])
				continue;
			for (int dir = 0; dir < 4; dir++) {
				int nx = a + dx[dir];
				int ny = b + dy[dir];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if (ans[nx][ny] > ans[a][b] + arr[nx][ny]) {
					visited[nx][ny] = true;
					ans[nx][ny] = ans[a][b] + arr[nx][ny];
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}
}