package giseon.m09.SWEA;

import java.util.*;
import java.io.*;

public class 암호생성기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			Queue<Integer> q = new ArrayDeque<>();
			br.readLine();
			sb.append("#").append(tc).append(" ");
			int count = 0;

			// 입력 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}

			// q에서 꺼낸 수를 count만큼 감소시키면서 뒤로 넣고 count를 1씩 증가시키기
			while (true) {
				int num = q.poll();
				count = count % 5 + 1;
				if (num - count <= 0) {
					q.offer(0);
					break;
				}
				q.offer(num - count);
			}

			for (int n : q) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
		} // tc end
		System.out.print(sb);
	} // main end
}
