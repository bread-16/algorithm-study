/* 
 * SWEA D2_1954. 달팽이 숫자
 * 실행시간: ms
 * 메모리: KB
 * 시간 복잡도: O()
 * 풀이 시간: 60분 
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
	private static final int[] dy = { 0, 1, 0, -1 };
	private static final int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); // 테케 수 입력

		int N; // 달팽이의 크기
		int[][] snail;
		int dir;
		int idy;
		int idx;
		int num; // 수
		int sanghan; // 방향 트는 타이밍 변수

		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append("\n");

			dir = 0;
			num = 1;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N == 1) {
				sb.append(1);
				System.out.print(sb);
				continue;
			}
			sanghan = N;

			snail = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					idy = i + dy[dir]; 
					idx = j + dx[dir];
					if (0 <= idy && idy < sanghan && 0 <= idx && idx < sanghan) { 
						snail[idy][idx] = num++;
						sb.append(snail[idy][idx]).append(" ");			
					} else { // 방향 트는 조건: 범위 상한까지 갔을때, 다음 값이 0이 아니면 
						dir = (dir++) % 4;	
					}
				}
				
				sb.append("\n");
			}
			
			System.out.print(sb);
		} // for tc END

	}

}
