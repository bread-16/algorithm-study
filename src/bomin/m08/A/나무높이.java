package bomin.m08.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무높이 {

	static int[] height;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			height = new int[N];

			int max = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, height[i]);
			}

			int sum = 0;
			int oddCnt = 0;

			for (int i = 0; i < N; i++) {

				int gap = max - height[i];
				sum += gap;
				// 반드시 필요한 홀수 개수 계산
				if (gap % 2 == 1) {
					oddCnt++;
				}
			}

			int dayCnt = (sum / 3) * 2;

			if (sum % 3 == 1) {
				dayCnt++;
			}

			if (sum % 3 == 2) {
				dayCnt += 2;
			}

			while (true) {
				int oneDay = (dayCnt + 1) / 2;
				int twoDay = dayCnt / 2;
				// 반드시 필요한 홀수 개수 넘겨야 함.
				if (oneDay >= oddCnt) {
					// 홀수가 2일 이상 남으면 짝수로 하루에 처리 가능
					if (twoDay + (oneDay - oddCnt) / 2 >= (sum - oddCnt) / 2)
						break;
				}

				dayCnt++;
			}

			sb.append("#").append(tc).append(" ").append(dayCnt).append("\n");
		}

		System.out.println(sb);
	}
}