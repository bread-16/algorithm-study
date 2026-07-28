package jinyoung.m07.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D2_1954 {
	static int T;
	static int n;
	//방향: 우 하 좌 상
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	//방향 정하기
	static int dir;
	public static boolean checkBound(int x, int y) {
		if (x >= n || y >= n || x < 0 || y < 0) {
			return true;
		}
		return false;
	}

	public static boolean checkDir(int x, int y,int[][] map) {
		if (map[x][y] > 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int idx = 1; idx <= T; idx++) {
			n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			int nx = 0;
			int ny = 0;
			int x = 0;
			int y = 0;
			dir = 0;
			for (int i = 1; i <= n * n; i++) {

				map[x][y] = i;
				nx = x + dx[dir % 4];
				ny = y + dy[dir % 4];

				if (checkBound(nx, ny)) {
					dir++;
					nx = x + dx[dir % 4];
					ny = y + dy[dir % 4];
				} else {
					if (checkDir(nx, ny,map)) {
						dir++;
						nx = x + dx[dir % 4];
						ny = y + dy[dir % 4];
					}
				}

				x = nx;
				y = ny;
				
				
			}
			sb.append("#").append(idx).append("\n");
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(j!=n-1) sb.append(map[i][j]).append(" ");
					else if(j==n-1) sb.append(map[i][j]).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
