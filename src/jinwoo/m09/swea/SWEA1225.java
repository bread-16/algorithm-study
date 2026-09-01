package jinwoo.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA1225 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < 10; t++) {

			in.readLine();

			StringTokenizer st = new StringTokenizer(in.readLine());

			Deque<Integer> dq = new ArrayDeque<>();

			for (int i = 0; i < 8; i++) {
				dq.offer(Integer.parseInt(st.nextToken()));
			}
			
			boolean isZero = false;
			while (!isZero) {
				for (int i = 1; i <= 5; i++) {
					int num = dq.poll() - i;
					if (num <= 0) {
						num = 0;
						dq.offer(num);
						isZero = true;
						break;
					}
					dq.offer(num);
				}
			}
			
			sb.append("#").append(t + 1).append(" ");
			while (!dq.isEmpty()) {
				sb.append(dq.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
