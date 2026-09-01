package ohyeon.m08.swea;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class swea3260 {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger A = new BigInteger(st.nextToken());
            BigInteger B = new BigInteger(st.nextToken());
            BigInteger result = A.add(B);
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.print(sb.toString());
    }
}
