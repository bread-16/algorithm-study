package jinyoung.m08.swea;

import java.util.*;
import java.io.*;

public class D3_5215_햄버거다이어트 {
	public static int N, L;
	public static int[][] score;
	public static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			score = new int[N][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i][0] = Integer.parseInt(st.nextToken());
				score[i][1] = Integer.parseInt(st.nextToken());
			}
			max = 0;
			dfs(0, 0, 0);
			System.out.println("#" + test_case + " " + max);
		}
	}

	public static void dfs(int idx, int tasteSum, int calSum) {
		if (calSum > L) {
			return;
		}
		if (idx == N) {
			max = Math.max(max, tasteSum);
			return;
		}
		dfs(idx + 1, tasteSum, calSum);
		dfs(idx + 1, tasteSum + score[idx][0], calSum + score[idx][1]);
	}
}
