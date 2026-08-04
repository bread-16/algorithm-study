package jinyoung.m07.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1209 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int[][] arr=new int[100][100];
		
		
		
		for(int idx=1;idx<=10;idx++) {
			int T=Integer.parseInt(br.readLine());
			
			for(int i=0;i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			//가로
			int maxValue=0;
			int sumValue=0;
			for(int i=0;i<100;i++) {
				sumValue=0;
				for(int j=0;j<100;j++) {
					sumValue+=arr[i][j];
				}
				maxValue=Math.max(maxValue, sumValue);
			}
			//세로
			sumValue=0;
			for(int i=0;i<100;i++) {
				sumValue=0;
				for(int j=0;j<100;j++) {
					sumValue+=arr[j][i];
				}
				maxValue=Math.max(maxValue, sumValue);
			}
			
			//우측 아래로 대각선
			sumValue=0;
			for(int i=0;i<100;i++) {
				sumValue+=arr[i][i];	
			}
			maxValue=Math.max(maxValue, sumValue);
			
			//좌측 아래로 대각선
			sumValue=0;
			for(int i=0;i<100;i++) {
				sumValue+=arr[i][99-i];	
			}
			maxValue=Math.max(maxValue, sumValue);
			sb.append("#").append(idx).append(" ").append(maxValue).append("\n");
		}
		System.out.println(sb);
	}
}
