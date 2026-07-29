package jinwoo.m07.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class sum_D3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < 10; t++) {
			
			int test_case = Integer.parseInt(in.readLine());

			int[][] arr = new int[100][100];

			for (int i = 0; i < 100; i++) {
				String numbers = in.readLine();
				StringTokenizer st = new StringTokenizer(numbers);
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int answer = 0;
			int cMaxNum = 0;
			int dMaxNum = 0;
			for (int i = 0; i < 100; i++) {
				int aMaxNum = 0;
				int bMaxNum = 0;
				for (int j = 0; j < 100; j++) {
					aMaxNum += arr[i][j];
					bMaxNum += arr[j][i];
				}
				answer = Math.max(answer, Math.max(aMaxNum, bMaxNum));

				cMaxNum += arr[i][i];
				dMaxNum += arr[i][99 - i];

			}

			answer = Math.max(answer, Math.max(cMaxNum, dMaxNum));

			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
