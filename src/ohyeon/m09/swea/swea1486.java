package ohyeon.m09.swea;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class swea1486 {
	static int N; //점원 수
	static int B; //선반 높이
	static int[] BHeight; //점원 키
	static int answer;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	B = Integer.parseInt(st.nextToken());
        	answer = Integer.MAX_VALUE;
        	BHeight = new int[N];
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < N; i++) {
        		BHeight[i] = Integer.parseInt(st.nextToken());
        	}
        	dfs(0, 0);
        	sb.append("#").append(tc).append(" ").append(answer - B).append("\n");
        }
        System.out.print(sb.toString());
	}
	
	static void dfs(int depth, int sum) {
		if (sum > answer) { //가지치기
			return;
		}
		if (depth == N) { //종료조건
			if (sum >= B && answer > sum) {
				answer = sum;
			}
			return;
		}
		dfs(depth+1, sum); //점원 미포함
		dfs(depth+1, sum+BHeight[depth]); //점원 포함
	}
}
