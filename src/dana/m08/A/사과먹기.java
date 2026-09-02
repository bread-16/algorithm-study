package dana.m08.A;

import java.io.*;
import java.util.*;

public class 사과먹기 {
	
	static class Apple {
		int r;
		int c;
		
		Apple(int r, int c) {
			this.r = r; 
			this.c = c; 
		}
	}
	
	// 헬퍼 펑션 getRequiredDir = 사과의 디렉션 알아내기 
	/*
	 * right -> down -> left -> up 
	 * 1        2        3      4 
	 * 
	 * */
	static int getRequiredDir(int curR, int curC, Apple next) {
		
		if (next.r < curR) {
			// 사과가 위에 있다 
			return 4;
		}
		if (next.r > curR) {
			// 사과가 아래 있다 
			return 2; 
		}
		if (next.c < curC) {
			// 사과가 왼쪽에 있다 
			return 3; 
		}
		// 사과가 오른쪽에 있다 
		return 1; 
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		
		int T = Integer.parseInt(br.readLine()); 
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine()); 
			// 10개의 사과까지 있을수 있다고 함. 
			Apple[] apples = new Apple[11]; 
			
			// 사과 위치 저장 
			for (int r = 0; r < N; r++) {
				
				String line = br.readLine();
				
				for (int c = 0; c < N; c++) {
					
					int num = line.charAt(c) - '0'; 
					
					if (num >= 1 && num <= 10) {
						apples[num] = new Apple(r, c); 
					}
				}
			}
			
			// 탐색 시작 위치 
			int curR = 0; 
			int curC = 0; 
			
			// 시작은 오른쪽을 보고있음 
			// right -> down -> left -> up 
			// 1        2        3      4 
			int dir = 1; 
			
			int answer = 0; 
			
			// 사과를 1번부터 순서대로 먹음 
			for (int i = 1; i <= 10; i++) {
				// 해당 번호의 사과가 없으면 종료  
				if (apples[i] == null) break; 
				
				Apple next = apples[i];
				// 다음 사과 먹기 위해 필요한 방향 
				int reqDir = getRequiredDir(curR, curC, next);
				// 오른쪽 회전 횟수 구하기 
				int turns = (reqDir - dir + 4) % 4; 
				answer += turns; 
				// 현재 방향 업데이트 해주기 
				dir = reqDir; 
				// 사과 위치로 이동 
				curR = next.r;
				curC = next.c; 
			}
			// sb 
			sb.append("#").append(tc).append(" ").append(answer).append("\n"); 
		}
		// print 
		System.out.print(sb);
	}

}
