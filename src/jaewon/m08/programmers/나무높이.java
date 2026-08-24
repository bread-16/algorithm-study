package jaewon.m08.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무높이 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			// 나무 개수 N
			int N = Integer.parseInt(in.readLine());

			// 각 나무 높이들 저장할 배열
			int[] trees = new int[N];

			// 나무 높이들 입력 받음 && 나무 중 최대 값 저장
			StringTokenizer st = new StringTokenizer(in.readLine());
			int maxTreeHeight = 0;
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				maxTreeHeight = Math.max(trees[i], maxTreeHeight);
			}

			int oddWater = 0;
			int evenWater = 0;

			for (int i = 0; i < N; i++) {

				int diff = maxTreeHeight - trees[i];

				evenWater += diff / 2;
				oddWater += diff % 2;
			}

			/*
			 * +2 한 번을 +1 두 번으로 바꿀 수 있습니다.
			 *
			 * 짝수 날 작업이 너무 많으면 홀수 날을 활용하지 못하고 기다리는 날이 많아집니다.
			 */
			while (evenWater > oddWater + 1) {
				evenWater--;
				oddWater += 2;
			}

			int date;

			/*
			 * oddWater가 더 많으면
			 *
			 * 1 3 5 7 ...
			 *
			 * 마지막 홀수 날에서 끝나므로 oddWater * 2 - 1
			 */
			if (oddWater > evenWater) {
				date = oddWater * 2 - 1;
			}

			/*
			 * evenWater가 더 많거나 같으면
			 *
			 * 2 4 6 8 ...
			 *
			 * 마지막 짝수 날에서 끝나므로 evenWater * 2
			 */
			else {
				date = evenWater * 2;
			}

			sb.append(date).append("\n");
		}

		System.out.println(sb);

	}

}
