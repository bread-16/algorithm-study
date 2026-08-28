package dana.m08.swea;

import java.util.*;
import java.io.*;

public class swea2001 {
	
	// 헬퍼 펑션 
	public static int flyCatch(int startR, int startC, int M, int[][] map) {
		int flies = 0; 
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				int nr = startR + i; 
				int nc = startC + j; 
				
				flies += map[nr][nc];
			}
		}
		return flies;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 맵 사이즈 
			int N = Integer.parseInt(st.nextToken());
			// 파리장 사이즈 
			int M = Integer.parseInt(st.nextToken()); 
			
			int[][] map = new int[N][N]; 
			// 맵 채우기 
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()); 
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			// 전략 시작 
			// 답: 
			int maxFlies = 0; 
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					// 헬퍼 펑션 콜 해주기 
					int currFlies = flyCatch(i, j, M, map); 
					if (currFlies > maxFlies) {
						maxFlies = currFlies;
					}
				}
			}
			// end of test case # 
			sb.append("#").append(tc).append(" ").append(maxFlies).append("\n"); 
		}
		// print 
		System.out.print(sb);
	}
}
