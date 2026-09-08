package jaewon.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수제_버거_장인 {

	static int N, M;

	static boolean[][] cantMake;

	static boolean[] visited;

	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			visited = new boolean[N + 1];
			cantMake = new boolean[N + 1][N + 1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				cantMake[a][b] = true;
				cantMake[b][a] = true;
			}

			count = 0;
			dfs(1);

			sb.append("#").append(testCase).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int materialIdx) {
		// 모든 재료를 확인해서 조합 완성
		if (materialIdx > N) {
			count++;
			return;
		}

		// 1. 현재 재료를 선택 X. 다음 재료 선택
		dfs(materialIdx + 1);

		// 2. 현재 재료 선택
		boolean canSelect = true;

		for (int i = 1; i <= N; i++) {
			// 궁합이 맞는지 확인. 이미 선택한 재료거나 궁합 안맞으면 만들 수 X
			if (visited[i] && cantMake[materialIdx][i]) {
				canSelect = false;
				break;
			}
		}

		// 이 재료로 만들 수 있다면
		if (canSelect) {
			visited[materialIdx] = true;
			dfs(materialIdx + 1);
			// 백트래킹
			visited[materialIdx] = false;
		}

	}

}
