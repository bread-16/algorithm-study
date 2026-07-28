package bomin.m07.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MostFrequency {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int tcNum = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] student = new int[1000];
			// 최빈수 저장 공간
			int[] cntNum = new int[101];

			for (int i = 0; i < student.length; i++) {
				student[i] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < student.length; j++) {
				cntNum[student[j]]++;
			}
			
			int max = Integer.MIN_VALUE;
			int maxIdx = Integer.MIN_VALUE;
			
			for (int k = 0; k< cntNum.length; k++) {
				if(cntNum[k]>=max) {
					max = cntNum[k];
					maxIdx = k;
				}
			}
			sb.append("#")
			.append(tc)
			.append(" ")
			.append(maxIdx)
			.append("\n");
		}

		System.out.println(sb);
	}
}
