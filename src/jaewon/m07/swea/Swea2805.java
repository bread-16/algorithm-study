package jaewon.m07.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(in.readLine());
			int[][] farm = new int[N][N];

			for (int i = 0; i < N; i++) {
				String temp = in.readLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = temp.charAt(j) - '0';
				}
			}

			// 투포인터? 중앙에서 범위 끝까지 갔다 다시 중앙으로
			// 내부 배열은 left ~ right 까지만
			int left=N/2;
			int right=N/2;
			int sum = 0;
			for(int i=0 ; i<N ; i++) {
				
				// left, right 범위 내 값 더함
				for(int j=left ; j<=right ; j++) {
					sum += farm[i][j];
				}
				
				// left 범위 이동
				// i가 N/2 보다 작다면 왼쪽으로, 크다면 오른쪽으로 이동
				if(i<N/2) {
					left--;
					right++;
				}else {
					left++;
					right--;
				}
				
				
			}
			sb.append("#").append(testCase).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
