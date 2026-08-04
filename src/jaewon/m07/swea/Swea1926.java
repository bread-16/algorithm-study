package jaewon.m07.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea1926 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int N = Integer.parseInt(in.readLine());
 
        for (int i = 1; i <= N; i++) {
            String output = Integer.toString(i);
             
            if(output.contains("3") || output.contains("6") || output.contains("9")) {
                int count = 0;
                for(int j=0;j<output.length() ; j++) {
                    if(output.charAt(j)=='3' || output.charAt(j)=='6' || output.charAt(j)=='9') {
                        sb.append('-'); 
                    }
                }
                sb.append(' ');
            }else {
                sb.append(i).append(' ');
            }
             
        }
        System.out.println(sb.toString());
	}
}
