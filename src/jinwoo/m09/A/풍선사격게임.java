package jinwoo.m09.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 풍선사격게임 {
	
	static int[] balloons;
	static int balloonNum;
	static int answer;
	static int[] right;
	static int[] left;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine().trim());
		for(int t=0; t<T; t++) {
			balloonNum = Integer.parseInt(in.readLine().trim());
			
			balloons = new int[balloonNum];
			right = new int[balloonNum];
			left = new int[balloonNum];
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			for(int i=0; i<balloonNum; i++) {
				balloons[i] = Integer.parseInt(st.nextToken());
				right[i] = i + 1;
				left[i] = i - 1;
			}
			visited = new boolean[balloonNum];
			answer = 0;
			// depth, score
			dfs(0, 0);
			
			sb.append("#").append(t+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static public void dfs(int depth, int score) {
		if(depth == balloonNum) {
			if(answer < score) answer = score;
			return;
		}
		
		for(int i=0; i<balloonNum; i++) {
			
			if(visited[i]) continue;
			
			visited[i] = true;
			int r = right[i];
			int l = left[i];
			
			// 터졌을경우 right left idx 조절
			if(r < balloonNum) {				
				left[r] = l;
			}
			if(l >= 0) {				
				right[l] = r;
			}
			
			if(r < balloonNum && l >= 0) {
				dfs(depth+1, score + (balloons[r]*balloons[l]));
			} else if(r < balloonNum) {
				dfs(depth+1, score + balloons[r]);
			} else if(l >= 0) {
				dfs(depth+1, score + balloons[l]);
			} else {
				dfs(depth+1, score + balloons[i]);
			}
			
			// 백트래킹
			if(r < balloonNum) {				
				left[r] = i;
			}
			if(l >= 0) {				
				right[l] = i;
			}
			visited[i] = false;
		}
	}
	
//	static public void dfs(int depth, int score) {
//		
//		
//		for(int i=0; i<balloonNum; i++) {
//			
//			if(visited[i]) continue;
//			
//			visited[i] = true;
//			dfs(depth+1, score + getScore(i));
//			visited[i] = false;
//		}
//	}
//	
//	static public int getScore(int idx) {
//		
//		boolean rightCheck = false;
//		int rightIdx = 0;
//		boolean leftCheck = false;
//		int leftIdx = 0;
//		for(int i = idx+1; i<balloonNum; i++) {
//			if(!visited[i]) {
//				rightCheck = true;
//				rightIdx = i;
//				break;
//			}
//		}
//		
//		for(int i = idx-1; i>=0; i--) {
//			if(!visited[i]) {
//				leftCheck = true;
//				leftIdx = i;
//				break;
//			}
//		}
//		
//		if(rightCheck && leftCheck) {
//			return balloons[rightIdx] * balloons[leftIdx];
//		} else if(rightCheck) {
//			return balloons[rightIdx];
//		} else if(leftCheck) {
//			return balloons[leftIdx];
//		} else {
//			return balloons[idx];
//		}
//	}
}
