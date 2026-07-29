package dana.m07.swea;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * Directions:
 * - right, down, left, up
 * 
 * Walls:
 * - right: N - 1 (col)
 * - down: N - 1 (row)
 * - left: 0 (col)
 * - up: 0 (row)
 * 
 * Right로 시작해 벽을 만날때마다 direction을 바꾼다. 
 * 
 * Direction == right 
 * - yIdx++
 * 
 * Direction == down 
 * - xIdx++
 * 
 * Direction == left 
 * - yIdx--
 * 
 * Direction == up 
 * - xIdx-- 
 * */

// 벽을 부딛히거나 (이미 숫자가 있는 다음 칸) snail의 range의 끝이면 -> direction 바꾸기 
// hit down wall -> direction change to left 
// hit left wall -> direction change to up
// hit up wall -> direction change to right 

class 달팽이_숫자
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// N을 받는다 
			int N = Integer.parseInt(in.readLine());
			
			// 달팽이 숫자를 넣을 배열을 만든다 N x N
			int[][] snail = new int[N][N];
			
			
			// 모두 1 부터 시작하고 N x N만큼 돌아간다 -> 0 ~ N x N - 1
			int value = 1; 
			// 4개의 벽
			int right = N - 1;
			int down = N - 1;
			int left = 0;
			int up = 0; 
			
			// 4 방향 
			// 범위 안에 있을동안...
			while (left <= right && up <= down) {
				// right -> col change 
				for (int col = left; col <= right; col++) {
					snail[up][col] = value++;
				}
				up++;
				// down
				for (int row = up; row <= down; row++) {
					snail[row][right] = value++;
				}
				right--;
				// left 
				if (up <= down) {
					for (int col = right; col >= left; col--) {
						snail[down][col] = value++;
					}
					down--; 
				}
				// up 
				if (left <= right) {
					for (int row = down; row >= up; row--) {
						snail[row][left] = value++;
					}
					left++;
				}
			}
			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}