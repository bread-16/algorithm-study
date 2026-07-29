
/*
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
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		int N; // 달팽이의 크기
		int[] snail;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N == 1) {
				System.out.print(1);
				continue;
			}

			snail = new int[N * N];
			for (int i = 0; i < N * N; i++) {

			}

//			sb.append("#").append(tc).append("\n").append(answer).append;
			System.out.print(sb);
		} // for (tc) END

	}

}
