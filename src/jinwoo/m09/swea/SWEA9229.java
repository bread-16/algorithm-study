package jinwoo.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA9229 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine().trim());
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int snackNum = Integer.parseInt(st.nextToken());
			int maxWeight = Integer.parseInt(st.nextToken());
			
			int[] snacks = new int[snackNum];
			
			st = new StringTokenizer(in.readLine().trim());
			for(int i=0; i<snackNum; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 0;
			
			for(int i=0; i<snackNum-1; i++) {
				int nowWeight = 0;
				for(int j=i+1; j<snackNum; j++) {
					nowWeight = snacks[i];
					if(nowWeight == maxWeight) break;
					nowWeight += snacks[j];
					if(nowWeight <= maxWeight && answer < nowWeight) {
						answer = nowWeight;
					}
				}
				if(nowWeight == maxWeight) break;
			}
			
			if(answer == 0) answer = -1;
			
			sb.append("#").append(t+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
