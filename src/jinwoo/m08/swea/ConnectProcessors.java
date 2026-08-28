package jinwoo.m08.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ConnectProcessors {

	static int[][] cells;
	static int maxiNodeLen;
	static List<Core> cores;
	static int MaxConnectedCore;
	static int minNodes;
	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static public class Core {
		int r;
		int c;

		public Core(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			maxiNodeLen = Integer.parseInt(in.readLine());

			cells = new int[maxiNodeLen][maxiNodeLen];
			cores = new ArrayList<>();

			for (int i = 0; i < maxiNodeLen; i++) {
				String c = in.readLine().trim();
				StringTokenizer stC = new StringTokenizer(c);
				for (int j = 0; j < maxiNodeLen; j++) {
					cells[i][j] = Integer.parseInt(stC.nextToken());
					if (i > 0 && i < maxiNodeLen - 1 && j > 0 && j < maxiNodeLen - 1) {
						if (cells[i][j] == 1) {
							cores.add(new Core(i, j));
						}
					}
				}
			}
			MaxConnectedCore = 0;
			minNodes = 100000000;
			dfs(0, 0, 0);

			sb.append("#").append(t + 1).append(" ").append(minNodes).append("\n");
		}
		System.out.println(sb);
	}

	static public void dfs(int depth, int connectedCore, int nodes) {
		
		if (depth == cores.size()) {
			if (connectedCore == MaxConnectedCore) {
				if (minNodes > nodes) {
					minNodes = nodes;
				}
			} else if (connectedCore > MaxConnectedCore) {
				MaxConnectedCore = connectedCore;
				minNodes = nodes;
			}
			return;
		}

		Core core = cores.get(depth);

		for (int i = 0; i < 4; i++) {
			int nodeNum = 0;
			int nx = core.r;
			int ny = core.c;
			
			boolean possible = true;
			
			while (true) {
				nx += dx[i];
				ny += dy[i];

				if (!inRange(nx, ny)) break;

				if (cells[nx][ny] != 0) {
					possible = false;
					break;
				} else {
					cells[nx][ny] = 2;
					nodeNum++;
				}
			}
			
			if(possible) {
				dfs(depth+1, connectedCore+1, nodes+nodeNum);
			}
			int cx = core.r;
			int cy = core.c;
			for (int j = 0; j < nodeNum; j++) {
				cx += dx[i];
				cy += dy[i];
				if (cells[cx][cy] == 2) {
					cells[cx][cy] = 0;
				}
			}
		}
		dfs(depth+1, connectedCore, nodes);
	}

	static public boolean inRange(int r, int c) {
		return (r >= 0 && r < maxiNodeLen && c >= 0 && c < maxiNodeLen);
	}
}
