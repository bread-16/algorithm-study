package davin.m07.swea;

import java.util.*;
import java.io.*;

public class D2_달팽이_숫자_1954 {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int j=1; j<=T; j++) {
			int n = Integer.parseInt(br.readLine());
			int[][] nums = new int[n][n];
			int x=0;
			int y=0;
			int dir = 0; //0, 1, 2, 3
			
			for(int i=1; i<=(n*n); i++) {
				nums[x][y]=i;
				int nx = x+dx[dir];
				int ny = y+dy[dir];
				
				if(nx>=n || ny>=n || nx<0 || ny<0 || nums[nx][ny]!=0 ) {
					dir = (dir+1)%4;
					nx = x+dx[dir];
					ny = y+dy[dir];
				}
				
				x=nx;
				y=ny;
			}
			
			sb.append("#").append(j).append("\n");
			
			for(int i=0; i<n; i++) {
				for(int k=0; k<n; k++) {
					sb.append(nums[i][k]).append(" ");
				}
				sb.append("\n");
			}
			
		}
		
		System.out.println(sb);
	}

}
