package jinwoo.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA6808 {
	
	static int[] userA;
	static int[] userB;
	static boolean[] visited;
	static List<Integer> randomB;
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
			 
			 randomB = new ArrayList<>();
			 visited = new boolean[10];
			 
			 randomB.add(0);
			 winNum = 0;
			 loseNum = 0;
			 dfs(0);
			 
			 sb.append("#").append(t+1).append(" ").append(winNum).append(" ").append(loseNum).append("\n");
		 }
		 System.out.println(sb);
	}
	
	static public void dfs(int depth) {
		if(depth == 9) {
			
			int aScore = 0;
			int bScore = 0;
			
			for(int i=1; i<10; i++) {
				if(userA[i] > randomB.get(i)) {
					aScore += (userA[i] + randomB.get(i)); 
				} else {
					bScore += (userA[i] + randomB.get(i)); 
				}
			}
			
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
			randomB.add(userB[i]);
			
			dfs(depth+1);
			
			randomB.remove(randomB.size()-1);
			visited[i] = false;
		}
	}
}
