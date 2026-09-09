package jinyoung.m08.swea;

import java.util.*;
import java.io.*;

public class D5_3421_수제버거장인 {
	public static int N, M;
	public static boolean[][] bad;
	public static boolean[] selected;
	public static int ans;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			bad = new boolean[N][N];
			selected = new boolean[N];
			ans = 0;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				bad[a][b] = true;
				bad[b][a] = true;
			}
			search(0);
			System.out.println("#" + test_case + " " + ans);
		}
	}

	public static void search(int idx) {
		if (idx == N) {
			ans++;
			return;
		}
		search(idx + 1);

		boolean can = true;
		for (int i = 0; i < idx; i++) {
			if (selected[i] && bad[i][idx]) {
				can = false;
				break;
			}
		}
		if (can) {
			selected[idx] = true;
			search(idx + 1);
			selected[idx] = false;
		}
	}
}
