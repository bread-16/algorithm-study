package jinyoung.m08.swea;

import java.util.*;
import java.io.*;

class Dn_1952_수영장 {
	public static int a, b, c, d, min;
	public static int[] arr;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			arr = new int[12];
			for (int i = 0; i < 12; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			min = d;

			dfs(0, 0);

			System.out.println("#" + test_case + " " + min);

		}
	}

	public static void dfs(int month, int cost) {
        if(month>=12) {
            min=Math.min(min,cost);
            return;
        }
        
        if(arr[month] == 0) {
   			dfs(month + 1, cost);
    		return;
		}
        
        dfs(month+1, cost+arr[month]*a);
        dfs(month+1, cost+b);
        dfs(month+3, cost+c);
	}
}