package jinwoo.m07.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;



public class SnailNum {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(in.readLine());
		
		for(int t=0; t<test_case; t++) {
			
			int snailSize = Integer.parseInt(in.readLine());
			int s = snailSize;
			int num = 1;
			boolean d = true;
			int tc = 0;
			int fc = 0;
			
			int[][] snail = new int[snailSize][snailSize];
			
			for(int i=0; i<snailSize; i++) {
				snail[0][i] = num++;
			}
			
			while(num <= snailSize * snailSize) {
				if(d) {
					for(int i=tc+1; i<s; i++) {
						snail[i][s-1] = num++;
					}
					s--;
					
					for(int i=s-1; i>= tc; i--) {
						snail[s][i] = num++;
					}
					tc++;
					d=!d;
				} else {
					for(int i=s-1; i>fc; i--) {
						snail[i][fc] = num++;
					}
					fc++;
					for(int i=fc; i<s; i++) {
						snail[fc][i] = num++;
					}
					d=!d;
				}
			}
			
			sb.append("#").append(t+1).append("\n");
			
			for(int i=0; i<snail.length; i++) {
				for(int j=0; j<snail.length; j++) {
					sb.append(snail[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb.toString());
	}
}
