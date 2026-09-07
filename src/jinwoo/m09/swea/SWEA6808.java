package jinwoo.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA6808 {
	
	static int[] userA;
	static int[] userB;
	static boolean[] visited;
	static int winNum;
	static int loseNum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 
		 int T = Integer.parseInt(in.readLine().trim());
		 for(int t=0; t<T; t++) {
			 StringTokenizer st = new StringTokenizer(in.readLine().trim());
			 
			 boolean[] selected = new boolean[19];
			 userA = new int[10];
			 userB = new int[10];
			 
			 for(int i=1; i<10; i++) {
				 userA[i] = Integer.parseInt(st.nextToken());
				 selected[userA[i]] = true;
			 }
			 
			 int bIdx = 1;
			 for(int i=1; i<19; i++) {
				 if(!selected[i]) {
					 userB[bIdx] = i;
					 bIdx++;
				 }
			 }
			 
			 visited = new boolean[10];
			 
			 winNum = 0;
			 loseNum = 0;
			 dfs(0, 0, 0);
			 
			 sb.append("#").append(t+1).append(" ").append(winNum).append(" ").append(loseNum).append("\n");
		 }
		 System.out.println(sb);
	}
	
	static public void dfs(int depth, int aScore, int bScore) {
		if(depth == 9) {
			
			if(aScore > bScore) {
				winNum++;
			} else {
				loseNum++;
			}
			
			return;
		}
		
		for(int i=1; i<10; i++) {
			if(visited[i])continue;
			
			visited[i] = true;
			
			int sum = userA[depth+1] + userB[i];
			
			if(userA[depth+1] > userB[i]) {
				dfs(depth+1, aScore+sum, bScore);
			} else {
				dfs(depth+1, aScore, bScore+sum);
			}

			visited[i] = false;
		}
	}
}
