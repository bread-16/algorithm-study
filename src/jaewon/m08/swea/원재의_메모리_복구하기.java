package jaewon.m08.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 원재의_메모리_복구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			String mem = in.readLine();

			int count = 0;
			for (int i = mem.length() - 1; i > 0; i--) {
				if (mem.charAt(i) != mem.charAt(i - 1))
					count++;
			}

			if (mem.charAt(0) == '1')
				count++;

			sb.append("#").append(testCase).append(" ").append(count).append("\n");

		}
		System.out.println(sb);

	}
}
