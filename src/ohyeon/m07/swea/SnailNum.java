package ohyeon.m07.swea;

import java.io.*;

class SnailNum
{
	public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int [] dx = {0, 1, 0, -1};
        int [] dy = {1, 0, -1, 0};
       
        for (int i = 1; i < T+1; i++) {
            int N = Integer.parseInt(br.readLine());
            int x = 0;
        	int y = 0;
            int dir = 0;
            int [][] matrix = new int [N][N];
            
            for (int num = 1; num<N*N+1; num++) {
                matrix[x][y] = num;
                int nx=x+dx[dir];
                int ny=y+dy[dir];
                
                if (nx<0 || nx>=N || ny<0 || ny>=N || matrix[nx][ny] != 0) {
                    dir = (dir+1)%4;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }
                
                x = nx;
                y = ny;
            }
            sb.append("#").append(i).append("\n");
            for (int row = 0; row < N; row++) {
                for(int col = 0; col <N; col++){
                    sb.append(matrix[row][col]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}