package bomin.m07.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Millionaire {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());
        for(int tc = 1 ; tc<=T;tc++) {
        		int start = 0;
//        		int price = 0;
        		long benefit = 0;
//        		int max = Integer.MIN_VALUE;
        		int maxIdx = 0;
        		int N = Integer.parseInt(br.readLine());
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		int[] array = new int[N];
        		for(int i=0;i<N;i++) {
        			array[i] = Integer.parseInt(st.nextToken());
        		}
        		while(start<N) {
        			int price = 0;
        			int max = Integer.MIN_VALUE;
        			for(int j = start; j<N;j++) {
        				if(array[j]>=max) {
        					max = array[j];
        					maxIdx = j;
        				}
        			}
        			for(int k = start; k<maxIdx; k++) {
        				price += array[k];
        			}
        			
        			benefit += (long)max * (maxIdx-start) - price;

        			start = maxIdx+1;
 
        			
        		}
        		
        		sb.append("#")
        		.append(tc)
        		.append(" ")
        		.append(benefit)
        		.append("\n");
        		System.out.println(sb);
        }
    }
}

