/*
SWEA D2_1859. 백만 장자 프로젝트
- 시간: 450ms
- 시간복잡도: O(N)
- 푸는 데 걸린 시간: 120분(정답 확인)
- 전략
	- 이익의 최댓값은 어떻게 결정되는가? -> 매매가의 최댓값일때 팔면 이익도 최대가 됨
	- 매매가의 최댓값이 있는 지점을 찾고 이익을 계산
	- 이익을 정방향으로 순회하여 계산하는 것보다 역방향으로 순회하면 계산을 줄일 수 있음
	(미리 알고있다는 가정이므로)
	  - 순회하는 동안 max보다 더 큰 매매가가 나오면 max 갱신한다.
	  - max보다 작으면 사는 시점이므로 이익을 누적으로 더해나간다.
	  (이익 += 판매가 - 매수가)
	- 누적된 이익을 출력하고 다음 테스트케이스가 있으면 위를 반복한다.
	(다음 테스트케이스 때 같은 변수를 쓰면 초기화 필수)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1859 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		StringBuilder sb;

		int N; // 매매가 나열 수
		int[] prices; // 매매가 저장 배열
		long profit; // 이익
		long max; // 최대 판매가

		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			prices = new int[N];
			profit = 0;
			max = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}

			// 개선: i = N-1은 무조건 바뀌므로 미리 저장해서 다음 N-2부터 도는게 계산을 1회 줄일 수 있다.
			max = prices[N - 1];
			for (int i = N - 2; i >= 0; i--) {
				if (prices[i] > max) { // 팔아야하는 시점이면
					max = prices[i]; // 갱신
				} else { // 아니면 사야되는 시점이므로
					profit += max - prices[i]; // 그 시점에 샀을 때 판매 시점에서 팔았을 때 얻는 이익을 계산(누적)
				}
			}

			sb.append("#").append(tc).append(" ").append(profit).append("\n");
			System.out.print(sb);
		}
	}

}
