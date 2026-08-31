package jinwoo.m08.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class EatAppleGame {
	
	static PriorityQueue<Apple> apples;
	// 처음 시작시 무조건 1번 턴
	static int turnCnt;
	// 좌하우상
	static int mode;
	
	static int[] turnNum = {1, 2, 3, 3};
	
	public static class Apple implements Comparable<Apple>{
		int r;
		int c;
		int num;
		
		public Apple(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
		
		@Override
		public int compareTo(Apple apple) {
			return this.num - apple.num;
		};
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine().trim());
		
		for(int t=0; t<T; t++) {
			apples = new PriorityQueue<Apple>();
			turnCnt = 1;
			mode = 2;
			
			int mapLen = Integer.parseInt(in.readLine().trim());
			
			for(int i=0; i<mapLen; i++) {
				String node = in.readLine().trim();
				for(int j=0; j<mapLen; j++) {
					if(node.charAt(j)- '0' != 0) {
						apples.offer(new Apple(i,j,node.charAt(j)- '0'));
					}
				}
			}
			
			while(apples.size() != 1) {
				Apple nowApple = apples.poll();
				
				int idx = (location(nowApple) + 3*(mode - 1)) % 4;
				turnCnt += turnNum[idx];
				
				mode = (mode -1 + turnNum[idx]) % 4 + 1;
			}
			sb.append("#").append(t+1).append(" ").append(turnCnt).append("\n");
		}
		System.out.println(sb);
	}
	
	
	
	static public int location(Apple apple) {
		
		if(apples.peek().r - apple.r > 0) {
			if(apples.peek().c - apple.c > 0) {
				// ++
				return 0;
			} else {
				// +-
				return 1;
			}
		} else {
			if(apples.peek().c - apple.c > 0) {
				// -+
				return 3;
			} else {
				// --
				return 2;
			}
		}
	}

}
