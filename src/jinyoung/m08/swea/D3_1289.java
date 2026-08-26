package jinyoung.m08.swea;

import java.io.*;

class D3_1289
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] s = br.readLine().split("");
			int[] arr = new int[s.length];
            int[] zero = new int[s.length];
            for(int i=0;i<s.length;i++) {
               arr[i]=s[i].charAt(0)-'0';
            }
            int cnt=0;
            for(int i=0;i<arr.length;i++) {
            	if(arr[i]!=zero[i]) {
                	for(int j=i;j<zero.length;j++) {
                    	if(zero[j]==0) zero[j]=1;
                        else zero[j]=0;
                    }
                    cnt++;
                }
            }
            System.out.println("#"+test_case+" "+cnt);
		}
	}
}