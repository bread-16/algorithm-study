package jinwoo.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1952 {
	
	static int[] prices;
	static int[] schedule;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine().trim());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			
			prices = new int[4];
			
			for(int i=0; i<4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			
			schedule = new int[12];
			
			st = new StringTokenizer(in.readLine().trim());
			for(int i=0; i<12; i++) {
				schedule[i] = Integer.parseInt(st.nextToken());
			}
			
			answer = prices[3];
			
			dfs(0, 0);
			
			sb.append("#").append(t+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static public void dfs(int depth, int cost) {
		if(cost >= answer) return;
		
		if(depth >= 12) {
			answer = cost;
			return;
		}
		
		for(int i=0; i<3; i++) {
			
			if(i == 0) {
				dfs(depth+1, cost + schedule[depth]*prices[i]);
			} else if(i == 1) {
				dfs(depth+1, cost + prices[i]);
			} else if(i == 2) {
				dfs(depth+3, cost + prices[i]);
			}
		}
	}
}
