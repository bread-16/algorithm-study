package jaewon.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 암호생성기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#").append(testCase).append(" ");
			int T = Integer.parseInt(in.readLine());

			Queue<Integer> q = new ArrayDeque<>();
			int maxNum = 0;
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 8; i++) {
				int temp = Integer.parseInt(st.nextToken());
				q.add(temp);
			}

			int minusValue = 1;

			while (true) {
				int current = q.poll();

				current -= minusValue;

				if (current <= 0) {
					current = 0;
					q.add(current);
					break;
				}

				q.add(current);

				minusValue++;

				if (minusValue > 5) {
					minusValue = 1;
				}
			}

			while (q.size() != 0) {
				sb.append(q.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
