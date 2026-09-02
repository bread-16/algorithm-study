package bomin.m08.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사칙연산유효성검사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int answer = 1;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				if(answer == 0)
					continue;
				if(st.countTokens() == 4) {
					st.nextToken();
					String operator = st.nextToken();
					if(Character.isDigit(operator.charAt(0))) {
						answer = 0;
						continue;
					}
					while(st.hasMoreTokens()) {
						st.nextToken();
					}
				}
				else if(st.countTokens() == 2) {
					st.nextToken();
					String number = st.nextToken();
					if(!Character.isDigit(number.charAt(0))) {
						answer = 0;
						continue;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
