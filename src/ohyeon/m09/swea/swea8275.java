package ohyeon.m09.swea;

import java.util.*;
import java.io.*;

public class swea8275 {
	static class Record {
		int left, right, sum;
		
		public Record(int left, int right, int sum) {
			this.left = left;
			this.right = right;
			this.sum = sum;
		}
	}
	
	static int N;
	static int X;
	static int M;
	static Record records[];
	static int[] cages;
	static int[] bestCages;
	static int maxSum;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			cages = new int[N+1];
			bestCages = new int [N+1];
			maxSum = -1;
			records = new Record[M];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int I = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				int S = Integer.parseInt(st.nextToken());
				records[i] = new Record(I, R, S);
			}
			
			dfs(1, 0);
			sb.append("#").append(tc).append(" ");
			if (maxSum == -1) {
				sb.append(-1).append("\n");
			} else {
				for (int i = 1; i <= N; i++) {
					sb.append(bestCages[i]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}
	static void dfs(int idx, int currentSum) {
		if(idx == N+1) {
			for (int i = 0; i < records.length; i++) {
				int tempSum = 0;
				
				for (int j = records[i].left; j <= records[i].right; j++) {
					tempSum += cages[j];
				}
				
				if (tempSum != records[i].sum) {
					return;
				}
			}
			
			if (currentSum > maxSum) {
				maxSum = currentSum;
				for (int i = 1; i <= N; i++) {
			        bestCages[i] = cages[i];
				}
			}
			return;
		}
		
		for (int i = 0; i <= X; i++) {
			cages[idx] = i;
			dfs(idx + 1, currentSum + i);
		}
	}
}
