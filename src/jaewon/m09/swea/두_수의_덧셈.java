package jaewon.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 두_수의_덧셈 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int testCase = 1 ; testCase <= T ; testCase++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			BigInteger x1 = new BigInteger(st.nextToken());
			BigInteger x2 = new BigInteger(st.nextToken());
			BigInteger answer = x1.add(x2);
			
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb);
	}
}
