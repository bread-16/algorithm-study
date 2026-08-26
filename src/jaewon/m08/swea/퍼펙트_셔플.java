package jaewon.m08.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 퍼펙트_셔플 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());

			Queue<String> front = new ArrayDeque<>();
			Queue<String> back = new ArrayDeque<>();

			int half = (N + 1) / 2;
			for (int i = 0; i < half; i++) {
				front.offer(st.nextToken());
			}
			for (int i = half; i < N; i++) {
				back.offer(st.nextToken());				
			}

			sb.append('#').append(testCase);
			while (!back.isEmpty()) {
				sb.append(' ').append(front.poll());
				sb.append(' ').append(back.poll());
			}
			if (!front.isEmpty())
				sb.append(' ').append(front.poll());
			sb.append('\n');
		}

		System.out.print(sb);
	}
}