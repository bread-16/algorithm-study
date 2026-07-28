package dana.m07.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class View {
	public static void main(String args[]) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
						
		for(int test_case = 1; test_case <= 10; test_case++) {
			// N = 건물수 
			int N = Integer.parseInt(in.readLine());
			// 건물의 높이 array 
			int[] heights = new int[N];
			// 건물의 높이 입력받기 (Tokenizer사용하기)
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			
			// 전략 시작 
			int answer = 0;
			
			for (int i = 2; i < N-2; i++) {
				int currHeight = heights[i];
				int maxHeight = 0;
				if (heights[i-2] < currHeight && heights[i-1] < currHeight && heights[i+1] < currHeight && heights[i+2] < currHeight ) {
					// 양방향 2개의 빌딩 중 (총 4빌딩) 가장 높은 빌딩 찾기
					maxHeight = Math.max(Math.max(heights[i-2], heights[i-1]), Math.max(heights[i+1], heights[i+2]));
					answer += currHeight - maxHeight;
				}
			}
		
			/*
			이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			*/
			// 프린트 
			System.out.println("#" + test_case + " " + answer);
		
		}
	}
}