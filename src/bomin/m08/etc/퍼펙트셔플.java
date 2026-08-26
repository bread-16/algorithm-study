package bomin.m08.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퍼펙트셔플 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] cards = new String[N];
			String[] results = new String[N];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				cards[i] = st.nextToken();
			}
			int center = (cards.length+1)/2;
			for(int i = 0; i< N/2; i++) {
				results[idx++] = cards[i];
				results[idx++] = cards[i+center];
			}
			if(N%2 == 1) {
				results[N-1] = cards[center-1];
			}
			sb.append("#").append(tc).append(" ");
			for(int i=0; i< results.length;i++) {
				sb.append(results[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
