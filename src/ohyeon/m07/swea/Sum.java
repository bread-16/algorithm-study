package ohyeon.m07.swea;

import java.util.*;
import java.io.*;

class Sum
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T =10;
        
        for (int i = 1; i<=T; i++) {
            int testCase = Integer.parseInt(br.readLine());
            int maxSum = 0;
            int diag1 = 0;
            int diag2 = 0;
            
            int [][] matrix = new int [100][100];
            for (int row = 0; row<100; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int col = 0; col<100; col++) {
                    matrix[row][col] = Integer.parseInt(st.nextToken());
                }
            }
            
            for (int j = 0; j < 100; j++) {
                int rowSum = 0;
                int colSum = 0;
                for (int k = 0; k <100; k++) {
                    rowSum += matrix[j][k];
                    colSum += matrix[k][j];
                }
                
                maxSum = Math.max(maxSum, rowSum);
                maxSum = Math.max(maxSum, colSum);
                
                diag1 += matrix[j][j];
                diag2 += matrix[j][99-j];
            }
            
            maxSum = Math.max(maxSum, diag1);
            maxSum = Math.max(maxSum, diag2);
        
            
            sb.append("#").append(testCase).append(" ").append(maxSum).append("\n");
		}
        System.out.print(sb);
    }
}