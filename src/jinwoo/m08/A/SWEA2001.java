package jinwoo.m08.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {
	static int flySwatter;
	static int[][] flyArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t=0; t<T; t++) {
			String arrNum = in.readLine().trim();
			StringTokenizer arrSt = new StringTokenizer(arrNum);
			
			int arrLen = Integer.parseInt(arrSt.nextToken());
			flySwatter = Integer.parseInt(arrSt.nextToken());
			
			flyArr = new int[arrLen][arrLen];
			
			for(int i=0; i<arrLen; i++) {
				String flyNum = in.readLine().trim();
				StringTokenizer fSt = new StringTokenizer(flyNum);
				for(int j=0; j<arrLen; j++) {
					flyArr[i][j] = Integer.parseInt(fSt.nextToken());
				}
			}
			
			int answer = 0;
			
			for(int i=0; i<=arrLen - flySwatter; i++) {
				for(int j=0; j<=arrLen - flySwatter; j++) {
					int catchNum = catchFly(i,j);
					
					if(catchNum > answer) answer = catchNum;
				}
			}
			
			sb.append("#").append(t+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static public int catchFly(int r, int c) {
		
		int cnt = 0;
		
		for(int i=r; i<r+flySwatter; i++) {
			for(int j=c; j<c+flySwatter; j++) {
				cnt += flyArr[i][j];
			}
		}
		
		return cnt;
	}
}
