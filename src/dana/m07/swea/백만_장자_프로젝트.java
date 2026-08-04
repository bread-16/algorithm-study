package dana.m07.swea;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/*
*
* 하루만 앞을 보면 안된다. -> 뒤에서 시작 (오른쪽 -> 왼쪽)
* - 만약 오늘 가격이 모든 미래 가격보다 비싸면 -> maxPrice = prices[i];
* - 아니면 -> profit += maxPrice - prices[i];
*
*/
class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(in.readLine());
			int[] prices = new int[N];
			
			StringTokenizer st = new StringTokenizer(in.readLine());

			for (int i = 0; i < N; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			
			// solution
			long profit = 0; 
			int maxPrice = prices[N-1];
			
			for (int i = N - 2; i >= 0; i--) {
				// 만약 오늘 가격이 모든 미래 가격보다 비싸면 -> maxPrice = prices[i]
				if (prices[i] > maxPrice) {
					maxPrice = prices[i];
				} else {
					profit += maxPrice - prices[i];
				}
			}
			// print answer here
			System.out.println("#" + test_case + " " + profit);
		} 
	}
}