package jinyoung.m08.swea;

import java.io.*;
import java.util.*;

public class D2_1979 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int arr[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 가로
			int result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - k + 1; j++) {
					int sum = 0;
					for (int l = 0; l < k; l++) {
						sum += arr[i][j + l];
					}
					if (j - 1 < 0) {
						if (sum == k && arr[i][j + k] != 1) {
							result++;
						}
					} else if (j >= n - k) {
						if (sum == k && arr[i][j - 1] != 1) {
							result++;
						}
					} else {
						if (sum == k && arr[i][j - 1] != 1 && arr[i][j + k] != 1) {
							result++;
						}
					}
				}
			}
			// 세로
			for (int j = 0; j < n; j++) {
				for (int i = 0; i < n - k + 1; i++) {
					int sum = 0;
					for (int l = 0; l < k; l++) {
						sum += arr[i + l][j];
					}
					if (i - 1 < 0) {
						if (sum == k && arr[i + k][j] != 1) {
							result++;
						}
					} else if (i >= n - k) {
						if (sum == k && arr[i - 1][j] != 1) {
							result++;
						}
					} else {
						if (sum == k && arr[i - 1][j] != 1 && arr[i + k][j] != 1) {
							result++;
						}
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
