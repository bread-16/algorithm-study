package jaewon.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사칙연산_유효성_검사 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 총 10개의 테스트케이스
		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#").append(testCase).append(" ");
			int N = Integer.parseInt(in.readLine());

			boolean flag = true;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());

				if (st.countTokens() == 4 || st.countTokens() == 3) {
					st.nextToken(); // 첫 입력 버림
					char node = st.nextToken().charAt(0);

					if (Character.isDigit(node)) {
						flag = false;
					}

				}
				else {
					st.nextToken(); // 첫 입력 버림
					char node = st.nextToken().charAt(0);
					if (!(Character.isDigit(node))) {
						flag = false;
					}
				}

			}
			if (flag) {
				sb.append("1").append("\n");
			} else {
				sb.append("0").append("\n");
			}
			
			flag = true;
		}
		System.out.println(sb);
	}

}
