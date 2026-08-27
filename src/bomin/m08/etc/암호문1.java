package bomin.m08.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 암호문1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> secrets = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				secrets.add(Integer.parseInt(st.nextToken()));
			}
			int commandCounts = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < commandCounts; i++) {
				if (st.nextToken().equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());

					for (int j = 0; j < y; j++) {
						secrets.add(x,Integer.parseInt(st.nextToken()));
						x++;
					}
				}
			}
			sb.append("#").append(tc).append(" ");
			for(int i = 0 ; i < 10 ; i++) {
				sb.append(secrets.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
