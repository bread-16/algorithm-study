package davin.m07.swea;

import java.util.*;
import java.io.*;

public class D2_어디에단어가_들어갈수있을까_1979 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[][] nums = new int[n][n];

			for (int j = 0; j < n; j++) {
				StringTokenizer stt = new StringTokenizer(br.readLine());
				for (int r = 0; r < n; r++) {
					nums[j][r] = Integer.parseInt(stt.nextToken());
				}
			}

			int ans = 0;
			for (int j = 0; j < n; j++) {
				int count = 0;
				for (int r = 0; r < n; r++) {
					if (nums[j][r] == 1) {
						count++;
					}
					if (r == n - 1 || nums[j][r + 1] == 0) {
						if (count == k) {
							ans++;
							count=0;
						}
						else
							count = 0;
						
//						if (count == k) ans++;
//						count = 0;
					}
				}
			}

			for (int j = 0; j < n; j++) {
				int count = 0;
				for (int r = 0; r < n; r++) {
					if (nums[r][j] == 1) {
						count++;
					}
					if (r == n - 1 || nums[r + 1][j] == 0) {
						if (count == k) {
							ans++;
							count=0;
						}
						else
							count = 0;
						
//						if (count == k) ans++;
//							count = 0;
					}
				}
			}

			sb.append("#").append(i).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}