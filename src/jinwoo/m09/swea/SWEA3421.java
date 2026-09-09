package jinwoo.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3421 {
	
	static int N;
	static int M;
	static int answer;
	static boolean[][] isUnsuitable;
	static boolean[] selected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine().trim());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			isUnsuitable = new boolean[N+1][N+1];
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(in.readLine().trim());
				int i1 = Integer.parseInt(st.nextToken());
				int i2 = Integer.parseInt(st.nextToken());
				isUnsuitable[i1][i2] = true;
				isUnsuitable[i2][i1] = true;
			}
			
			
			answer = 0;
			selected = new boolean[N+1];
				
			dfs(1);
			
			answer++;
			
			sb.append("#").append(t+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static public void dfs(int start) {
		for(int i=start; i<=N; i++) {
			
			boolean possible = true;
			
			for(int j=1; j< i; j++) {
				if(selected[j] && isUnsuitable[j][i]) {
					possible = false;
					break;
				}
			}
			
			if(possible) {
				answer++;
				
				selected[i] = true;
				dfs(i+1);
				selected[i] = false;
			}
			
		}
	}
	
}
