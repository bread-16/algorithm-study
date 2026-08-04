package ohyeon.m07.swea;

import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int [][] farm = new int [N][N];
            
            for (int row = 0; row < N; row++) {
                String line = br.readLine();
                for (int col = 0; col < N; col++) {
                    farm[row][col] = line.charAt(col)-'0';
                }
            }
            
            int up = (N/2)+1;
            int down = N-up;
            int sum = 0;
            
            for (int j = 0; j < up; j++){
                for (int k = -j; k <= j; k++){
                	sum+=farm[j][(N/2)+k];
                }
            }
            
            for (int j =up; j < N; j++) {
                for(int k = N-j-1; k>=-(N-j-1); k--){
                    sum += farm[j][(N/2)+k];
                }
            }
            
            sb.append("#").append(i).append(" ").append(sum).append("\n");
        }
        System.out.print(sb);
	}
}
public class CropsHarvest {

}
