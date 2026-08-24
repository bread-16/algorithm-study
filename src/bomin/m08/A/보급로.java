package bomin.m08.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 보급로 {

	static class Node implements Comparable<Node> {
		int r;
		int c;
		int cost;

		Node(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	static int[][] map;
	static int[][] dis;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dis = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
					dis[i][j] = Integer.MAX_VALUE;
				}
			}
			PriorityQueue<Node> pQ = new PriorityQueue<>();
			pQ.offer(new Node(0, 0, 0));
			dis[0][0] = 0;
			while (!pQ.isEmpty()) {
				Node cur = pQ.poll();
				int r = cur.r;
				int c = cur.c;
				int cost = cur.cost;
				

				if (cost > dis[r][c])
					continue;
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (!boundary(nr, nc))
						continue;
					if (dis[nr][nc] > cost + map[nr][nc]) {
						dis[nr][nc] = cost + map[nr][nc];
						pQ.offer(new Node(nr, nc, cost + map[nr][nc]));
					}
				}
			}
			sb.append("#").append(tc).append(" ")
			.append(dis[N-1][N-1])
			.append("\n");

		}
		System.out.println(sb);
	}

	static boolean boundary(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < N)
			return true;

		return false;
	}

}
