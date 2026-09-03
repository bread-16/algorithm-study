package jaewon.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 한빈이와SpotMart {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(in.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] snack = new int[N];

			st = new StringTokenizer(in.readLine());

			for (int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(snack);

			int left = 0, right = N - 1;
			int ans = -1;

			while (left < right) {

				int weight = snack[left] + snack[right];

				if (weight > M) {
					right--;
				} else if (weight == M) {
					ans = weight;
					break;
				} else {
					if (weight > ans) {
						ans = weight;
					}
					left++;
				}

			}

			sb.append("#").append(testCase).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}
}
