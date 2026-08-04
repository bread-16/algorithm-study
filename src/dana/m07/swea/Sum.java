package dana.m07.swea;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * - row 끼리 비교 
 * - col 끼리 비교 
 * - 대각선 끼리 비교 
 * 
 * - row, col 비교-> 대각선 비교 
 * 
 * */

class Sum
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
		
			// 입력값 -> 테스트 케이스 순서 
			int tc = Integer.parseInt(in.readLine());
			
			int[][] map = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 전략시작 
			int maxSum = 0;
			
			// row끼리 비교 
			int rowMax = 0; 
			// col끼리 비교 
			int colMax = 0;
			for (int i = 0; i < 100; i++) {
				int rowCurrSum = 0;
				int colCurrSum = 0; 
				for (int j = 0; j < 100; j++) {
					rowCurrSum += map[i][j];
					colCurrSum += map[j][i];
				}
				// 이 시점 -> 한 줄의 sum이 끝난 후. 
				rowMax = Math.max(rowMax, rowCurrSum);
				colMax = Math.max(colMax, colCurrSum);
			}
			
			// 2개의 대각선 	
			int leftDiagMax = 0;
			int rightDiagMax = 0;
			
			int rightDiagC = 99; 
			for (int i = 0; i < 100; i++) {
				leftDiagMax += map[i][i];
				rightDiagMax += map[i][rightDiagC - i];
			}
			
			// row와 col 비교 
			int rowVsCol = Math.max(rowMax, colMax);
			
			// 대각선 2개 비교 
			int rightVsLeft = Math.max(leftDiagMax, rightDiagMax);
			
			maxSum = Math.max(rowVsCol, rightVsLeft);
			
			sb.append("#").append(test_case).append(" ").append(maxSum).append("\n");
		}
		System.out.println(sb.toString());
	}
}