package bomin.m09.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장훈이의높은선반 {
	static int N;
	static int B;
	static int[] heights;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			heights = new int[N];
			answer = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			sb.append("#").append(tc).append(" ").append(answer - B).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int index, int sum) {
		//분기처리
		if (sum >= answer)
			return;
		
		//최솟값 갱신
		if (sum >= B) {
			answer = sum;
			return;
		}
		if (index == N) {
			return;
		}
		dfs(index + 1, sum + heights[index]);
		dfs(index + 1, sum);
	}

}
