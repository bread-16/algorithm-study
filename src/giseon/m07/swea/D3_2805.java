package giseon.m07.swea;

import java.io.*;
import java.util.StringTokenizer;

public class D3_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); // 테케 수 입력
		int N; // 농장 크기
		int[][] values; // 농작물 가치 저장 배열
		int profit; // 출력할 수익
		int range; // 수확할 범위 제어 변수
		int col; // 열 제어 변수
		int count; // 수확 횟수 제어
		int half; // N의 절반 반복 사용으로 변수화
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 농장 크기 입력

			values = new int[N][N]; // 농장 가치 배열 입력: 공백없이 입력받으므로 한줄마다 문자로 분해하고 int로 변환 후 배열에 저장한다.
			for (int i = 0; i < N; i++) {
				String temp = br.readLine().trim();
				for (int j = 0; j < N; j++) {
					values[i][j] = temp.charAt(j) - '0'; // 정수로 변환하여 저장
				}
			}

			range = 0;
			col = 0;
			profit = 0;
			count = 0;
			half = N / 2;
			while (col < N) {
				for (int i = half - range; i <= half + range; i++) { // 행마다 수확
					profit += values[col][i];
				}
				if (count < half + 1 && range < half) {
					range++;
				} else {
					range--;
				}
				count++;
				col++;
			}
			sb.append("#").append(tc).append(" ").append(profit).append("\n");
		}
		System.out.print(sb);

	}
}
