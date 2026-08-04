/* 
 * SWEA D2_1954. 달팽이 숫자
 * 실행시간: 81ms
 * 메모리: 25,344 kb
 * 시간 복잡도: O(N ^ 2)
 * 풀이 시간: 60분(힌트 확인)
 * 전략
   * 반복되는 진행 방향: 우 하 좌 상
   * 델타 배열 활용 방향 설정, 범위 초과 시 방향 변경
 * 리뷰
   * 처음에는 수학적인 규칙만을 찾으려 삽질했는데 원초적인 탐색 방법도 염두해두기
   * 2차원 배열 탐색은 델타 배열 활용 생각하기
   * 처음부터 깔끔하게 풀려고 하니 복잡해진 느낌임
 */
package giseon.m07.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1954 {

	// 우 하 좌 상 순서로 델타 배열 정의
	private static final int[] dr = { 0, 1, 0, -1 };
	private static final int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); // 테케 수 입력

		int N; // 달팽이의 크기
		int[][] snail; // 저장할 배열
		int dir; // dr, dc의 방향 결정 변수
		int idr; // 델타 배열값을 더한 행 변수
		int idc; // 델타 배열값을 더한 열 변수
		int r; // 행(세로 순회 변수)
		int c; // 열(가로 순회 변수)

		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append("\n");

			dir = 0; // 방향 처음은 오른쪽으로 시작
			r = 0; // 델타 배열 dr[0] == 0 이므로 초기값 0 되게 설정
			c = -1; // 델타 배열 dc[0] == -1 이므로 초기값 0 되게 설정

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			snail = new int[N][N];
			for (int i = 1; i <= N * N; i++) {
				idr = r + dr[dir];
				idc = c + dc[dir];
				if (0 <= idr && idr < N && 0 <= idc && idc < N && snail[idr][idc] == 0) {
					snail[idr][idc] = i;
					// 위치를 델타 배열 크기만큼 이동
					r = idr;
					c = idc;
				} else {
					dir = (dir + 1) % 4; // 0 1 2 3만 돌게 하도록 모듈러 연산
					i--; // 방향 전환할 경우 i증가 철회
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(snail[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
		} // for tc end
	} // main end
}
