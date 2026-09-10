package jaewon.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 장훈이의_높은_선반 {

	static int N; // 점원 수
	static int B; // 선반의 높이

	static int[] humans; // 점원 배열

	static int height; // 탑 높이

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			humans = new int[N];

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				humans[i] = Integer.parseInt(st.nextToken());
			}
			
			height = Integer.MAX_VALUE;

			// 0번째 점원부터 탐색
			dfs(0, 0);
			
			sb.append("#").append(testCase).append(" ").append(height-B).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int idx, int sum) {
		// 이미 높이가 B를 넘어가면 더 쌓을 필요 X
		if (sum >= B) {
			height = Math.min(height, sum);
			return;
		}

		// 점원을 다 탐색해도 B 미만이면 return
		if (idx == N) {
			return;
		}
		
		// 현재 idx 점원을 탑에 올리고 dfs 호출
		dfs(idx + 1, sum + humans[idx]);
		// 현재 idx 점원을 탑에 올리지 않고 dfs 호출
		dfs(idx + 1, sum);

	}
}
