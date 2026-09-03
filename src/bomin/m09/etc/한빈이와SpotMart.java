package bomin.m09.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 한빈이와SpotMart {
	static List<Integer> snacks;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			snacks = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++) {
				snacks.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(snacks);
			int left = 0;
			int right = snacks.size()-1;
			int answer = -1;
			while(left<right) {
				int weight = snacks.get(left) + snacks.get(right);
				if(weight>M) {
					right--;
				}
				else if(weight == M) {
					answer = weight;
					break;
				}else {
					answer = Math.max(answer,  weight);
					left++;
				}

			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		
	}
}
