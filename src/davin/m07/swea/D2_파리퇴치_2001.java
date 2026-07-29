package davin.m07.swea;

import java.util.*;
import java.io.*;

public class D2_파리퇴치_2001 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] nums = new int[n+1][n+1];

			for (int j = 1; j <= n; j++) {
				StringTokenizer stt = new StringTokenizer(br.readLine());
				for (int k = 1; k <= n; k++) {
					nums[j][k] = Integer.parseInt(stt.nextToken());
				}
			}

			// 누적합
			int[][] prefix = new int[n + 1][n + 1];
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					prefix[j][k] = prefix[j][k - 1] + prefix[j - 1][k] - prefix[j - 1][k - 1] + nums[j][k];
				}
			}

			// m부터 N까지 가로/세로 개수= N-m+1
			int range = n - m + 1;
			int max = 0;

			for (int j = 1; j <= range; j++) {
				for (int k = 1; k <= range; k++) {
					// (j,k)부터 (j+m-1, k+m-1)까지 합
					int sum = prefix[j + m - 1][k + m - 1] - prefix[j - 1][k + m - 1] - prefix[j + m - 1][k - 1]
							+ prefix[j-1][k-1];
					max = Math.max(max, sum);
				}
			}

			sb.append("#").append(i + 1).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}

//package davin.m07.swea;
//
//import java.util.*;
//import java.io.*;
//
//public class D2_파리퇴치_2001 {
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//
//		int t = Integer.parseInt(br.readLine());
//		for (int i = 0; i < t; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int n = Integer.parseInt(st.nextToken());
//			int m = Integer.parseInt(st.nextToken());
//
//			int[][] nums = new int[n][n];
//
//			for (int j = 0; j < n; j++) {
//				StringTokenizer stt = new StringTokenizer(br.readLine());
//				for (int k = 0; k < n; k++) {
//					nums[j][k] = Integer.parseInt(stt.nextToken());
//				}
//			}
//
//			// m부터 N까지 가로개수= N-m+1
//			int range = n - m + 1;
//			
//			int max = 0;
//
//			for (int j = 0; j < range; j++) {
//				for (int k = 0; k < range; k++) {
//					int sum = 0;
//					for (int p = 0; p < m; p++){
//						for (int q = 0; q < m; q++) {
//							sum += nums[j + p][k + q];
//						}
//					}	
//					max = Math.max(max, sum);
//				}
//			}
//
//			sb.append("#").append(i + 1).append(" ").append(max).append("\n");
//		}
//		System.out.println(sb);
//	}
//
//}
