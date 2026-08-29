package giseon.m08.SWEA;

import java.util.*;
import java.io.*;

public class 파리퇴치 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int T = Integer.parseInt(br.readLine().trim());
    	
    	StringTokenizer st;
    	
    	for (int tc = 1; tc <= T; tc++) {
    		sb.append("#").append(tc).append(" ");
    		
    		st = new StringTokenizer(br.readLine());
    		int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	
        	int[][] map = new int[N][N];
        	for (int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for (int j = 0; j < N; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	int answer = -1;
        	// i, j -> 영역의 시작점
        	for (int i = 0; i <= N - M; i++) {
        		for (int j = 0; j <= N - M; j++) {
        			int sum = 0;		
        			for (int k = i; k < i + M; k++) {
        				for (int l = j; l < j + M; l++) {
        					sum += map[k][l];
        				}
        			}
        			if (answer < sum) {
        				answer = sum;        				
        			}
        		} // j end
        	} // i end
        	sb.append(answer).append("\n");
    	} // tc end
    	System.out.print(sb);
    } // main end
}
