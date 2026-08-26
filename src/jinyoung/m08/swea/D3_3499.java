package jinyoung.m08.swea;

import java.util.*;
import java.io.*;

public class D3_3499 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case=1;test_case<=T;test_case++) {
			sb.append("#").append(test_case).append(" ");
			int n = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			
			int len = s.length;
			String[] s1;
			String[] s2;
			if(len%2==0) {
				int half=len/2;
				s1 = new String[half];
				s2 = new String[half];
				for(int i=0;i<half;i++) {
					s1[i]=s[i];
				}
				for(int i=half;i<len;i++) {
					s2[i-half]=s[i];
				}
				for(int i=0;i<half;i++) {
					sb.append(s1[i]).append(" ");
					sb.append(s2[i]).append(" ");
				}				
			} else {
				int half=len/2+1;
				s1 = new String[half];
				s2 = new String[half-1];
				for(int i=0;i<half;i++) {
					s1[i]=s[i];
				}
				for(int i=half;i<len;i++) {
					s2[i-half]=s[i];
				}
				for(int i=0;i<half;i++) {
					sb.append(s1[i]).append(" ");
					if(i==half-1) continue;
					sb.append(s2[i]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
  