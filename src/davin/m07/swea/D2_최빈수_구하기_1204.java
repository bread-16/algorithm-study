package davin.m07.swea;

import java.util.*;
import java.io.*;

public class D2_최빈수_구하기_1204 {
	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int tc = Integer.parseInt(br.readLine());
			
			int[] score = new int[1002];
			int max=0;
			int answer=0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<1000; j++) {
				score[Integer.parseInt(st.nextToken())]++;
			}
			
			for(int j=0; j<=1001; j++) {
				max=Math.max(score[j], max);
			}
			
			for(int j=1001; j>=0; j--) {
				if(score[j]==max) {
					answer = j;
					break;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb);
	}
}
