package jinyoung.m07.swea;

/** 전략
 	완전탐색
 	n*n 배열을 탐색하면서
 	m*m 배열의 합 중 max 출력
 */

import java.io.*;
import java.util.*;

public class D2_2001 {
	public static int[][] arr;
	public static int maxValue=0;
	public static int n;
	public static int m;
	
	
	public static int check4(int x, int y) {
		int sumValue=0;
		for(int i=x;i<x+m;i++) {
			for(int j=y;j<y+m;j++) {
				sumValue+=arr[i][j];
			}
		}
		return sumValue;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int idx=1;idx<=T;idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			
			arr=new int[n][n];
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			maxValue=0;
			for(int i=0;i<n-m+1;i++) {
				for(int j=0;j<n-m+1;j++) {
					maxValue=Math.max(check4(i,j), maxValue);
				}
			}
			sb.append("#").append(idx).append(" ").append(maxValue).append("\n");
		}
		System.out.println(sb);
	}

}
