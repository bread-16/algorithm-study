package jinwoo.m09.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class SWEA3260 {
	public static void main(String args[]) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine().trim());
        
        for(int t=0; t<T; t++){
        	StringTokenizer st = new StringTokenizer(in.readLine().trim());
            BigInteger a = new BigInteger(st.nextToken());
            BigInteger b = new BigInteger(st.nextToken());

            BigInteger result = a.add(b);
            sb.append("#").append(t+1).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
     }
}
