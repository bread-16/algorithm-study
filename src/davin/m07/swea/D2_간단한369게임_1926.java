package davin.m07.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D2_간단한369게임_1926 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			String str = String.valueOf(i);
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if (c == '3' || c == '6' || c == '9')
					count++;
			}

			if (count > 0) {
				for (int k = 0; k < count; k++) {
					sb.append("-");
				}
				sb.append(" ");
			} else {
				sb.append(str).append(" ");
			}
		}
		System.out.println(sb);
	}

}
