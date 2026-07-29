/*
 * 실행시간: 141 ms
 * 메모리: 37,480 kb
 * 전략
   * 2차원 배열의 행, 열, 대각 합을 순회하면서 구함
   * 행은 한 줄 입력마다 합을 구하면서 max 확인
   * 열, 대각은 입력 후 순회하면서 max 확인
   * 행, 열, 대각 중 max 출력
 * 행, 열 계산 시 합 저장 변수 초기화해야 함에 유의
 */


package giseon.m07.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1209 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		int T;		 // 입력하는 테스트 케이스 번호
		int[][] arr;
		int maxRowSum; // 행의 합 MAX
		int rowSum; // 행의 합

		int maxColSum; // 열의 합 MAX
		int colSum; // 열의 합

		int maxDiagSum; // 대각 합 MAX
		int diagSum; // 대각 합

		int answer; // 출력할 답

		for (int tc = 1; tc <= 10; tc++) {
			sb = new StringBuilder();
			maxRowSum = 0;
			maxColSum = 0;
			maxDiagSum = 0;
			diagSum = 0;
			answer = 0;

			arr = new int[101][101];
			st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < 100; i++) { // 입력과 동시에 행 합의 max 구하기
				rowSum = 0;
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					rowSum += arr[i][j];
				}
				maxRowSum = Math.max(maxRowSum, rowSum); // 행의 합 MAX 구하기
			}

			for (int i = 0; i < 100; i++) { // 열의 합, 대각 합 max 구하기
				diagSum += arr[i][i];
				maxDiagSum += arr[99 - i][i];
				colSum = 0;
				for (int j = 0; j < 100; j++) {
					colSum += arr[j][i];
				}
				maxColSum = Math.max(maxColSum, colSum);
			}
			maxDiagSum = Math.max(diagSum, maxDiagSum);

			answer = Math.max(maxRowSum, Math.max(maxColSum, maxDiagSum));

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			System.out.print(sb);
		} // tc end
	}
}
