package bomin.m09.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거다이어트 {
	static int[][] ingredients;
	static int L;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			ingredients = new int[N][2];
			answer = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				// 점수, 칼로리 저장
				ingredients[i][0] = Integer.parseInt(st.nextToken());
				ingredients[i][1] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int index, int score, int kcal) {
		if (kcal > L)
			return;
		if (index == ingredients.length) {
			if (answer < score) {
				answer = score;
			}
			return;
		}
		// 선택
		dfs(index + 1, score + ingredients[index][0], kcal + ingredients[index][1]);
		// 미선택
		dfs(index + 1, score, kcal);

	}
}
