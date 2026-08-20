package dana.m08.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea14510 {
	
	/*
	 * inputs:
	 * 
	 * 1. test case numbers 
	 * 2. for each test case:
	 * 	-> number of trees N 
	 * 	-> tree heights 
	 * 
	 * */
	public static void main(String[] args) throws IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			// tree numbers 
			int N = Integer.parseInt(br.readLine()); 
			
			// tree heights 
			int[] tree = new int[N];
			
			// max height 
			int maxHeight = 0; 

			StringTokenizer st = new StringTokenizer(br.readLine()); 
			
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken()); 
				maxHeight = Math.max(maxHeight, tree[i]); 
			}
			// end of inputs 
			
			// 전략 시작 
			
			// number of odd, even days 
			int odd = 0; 
			int even = 0; 
			
			// calculate number of odd and even days required to become maxHeight 
			for (int i = 0; i < N; i++) {
				if (tree[i] == maxHeight) continue;
				
				odd += tree[i] % 2;
				even += tree[i] / 2; 
			}
			
			// distribute the number of even days to odd days 
			while (even - odd >= 2) {
				even -= 1; 
				odd += 2; 
			}
			
			int answer = 0;
			
			if (odd > even) {
				answer = odd * 2 - 1;
			} else {
				answer = even * 2; 
			}
			
			// print answer 
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");  
		}
		
		// when using stringbuilder, it builds the whole string throughout the test case,
		// so print sb after for loop has ended. 
		System.out.println(sb); 

	}

}
