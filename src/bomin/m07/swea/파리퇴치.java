package bomin.m07.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파리퇴치 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] array = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = killNum(array, N, M);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}

	static int killNum(int[][] array, int N, int M) {

		// 시작점 기준으로 -> 행 +M-1/ 열 +M-1까지 합.
		// 시작점 -> 0,0/N-M,N-M 내부 모든 점.
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i <= N - M; i++) {
			for (int j = 0; j <= N - M; j++) {
				for (int k = 0; k < M; k++) {
					for (int l = 0; l < M; l++) {
						sum += array[i+k][j+l];
					}
				}
				if(sum>=max) {
					max = sum;
				}
				sum = 0;
			}
		}

		return max;
	}
}
