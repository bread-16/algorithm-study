package jinyoung.m08.swea;

import java.util.*;
import java.io.*;

class D2_14510 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			// max 값 확인
			int k = arr[0];
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				if (max < arr[i])
					max = arr[i];
			}
			// 남은 나무 높이 배열 생성
			int[] arrGrow = new int[n];
			for (int i = 0; i < n; i++) {
				arrGrow[i] = max - arr[i];
			}
			int odd = 1;
			int even = 2;
			int flag = 0;
			int day = 0;

			while (true) {
				// 남은 나무 높이가 0이 아닐 때 -> flag = 1
				for (int i = 0; i < n; i++) {
					if (arrGrow[i] != 0)
						flag = 1;
				}
				// flag == 0이면 종료
				if (flag == 0) {
					break;
				} else {
					flag = 0;
				}
				// 하루 지남
				day++;
				// 홀수날
				if (day % 2 == 1) {
					// 일단 남은 나무높이가 홀수인 경우만 -1
					int flag2 = 0;
					for (int i = 0; i < n; i++) {
						if (arrGrow[i] > 0) {
							if (arrGrow[i] % 2 == 1) {
								arrGrow[i] -= odd;
								flag2 = 1;
								break;
							}
						}
					}
					// 모든 남은 나무높이가 짝수인 경우는 아무곳에서나 -1
					if (flag2 == 0) {
						for (int i = 0; i < n; i++) {
							if (arrGrow[i] > 0 && arrGrow[i] != 2) {
								arrGrow[i] -= odd;
								break;
							}
						}
					}

				} else {
					// 짝수날
					for (int i = 0; i < n; i++) {
						if (arrGrow[i] > 1) {
							arrGrow[i] -= even;
							break;
						}
					}
				}
			}
			sb.append(day).append("\n");
		}
		System.out.println(sb);
	}
}
