package jinyoung.m08.swea;

import java.util.*;
import java.io.*;

public class D3_6808_규영이와인영이의카드게임 {

	public static int[] a = new int[9];
	public static int[] b = new int[9];
	public static boolean[] c;
	public static boolean[] visited = new boolean[9];
	public static int win;
	public static int lose;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			c = new boolean[19];
			c[0] = true;
			for (int i = 0; i < 9; i++) {
				a[i] = Integer.parseInt(st.nextToken());
				c[a[i]] = true;
			}
			int idx = 0;
			for (int i = 1; i < 19; i++) {
				if (c[i] == false) {
					b[idx++] = i;
				}
			}
			win = 0;
			lose = 0;
			dfs(0, 0, 0);

			sb.append("#").append(test_case).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int cnt, int gyu, int in) {
		if (cnt == 9) {
			if (gyu > in) {
				win++;
			}
			if (in > gyu) {
				lose++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			int sum = a[cnt] + b[i];
			if (a[cnt] > b[i]) {
				dfs(cnt + 1, gyu + sum, in);
			} else {
				dfs(cnt + 1, gyu, in + sum);
			}
			visited[i] = false;
		}
	}
}