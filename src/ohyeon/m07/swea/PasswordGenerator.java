package ohyeon.m07.swea;

import java.util.*;
import java.io.*;

public class PasswordGenerator {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int testCase = 1; testCase<=10; testCase++) {
        	int T = Integer.parseInt(br.readLine());    
            Deque <Integer> num = new ArrayDeque <Integer> ();
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i<8; i++) {
                num.add(Integer.parseInt(st.nextToken()));
            }
            
            outer:
            while(true) {
                for(int minusNum = 1; minusNum <= 5; minusNum++) {
                	num.offer(num.poll()-minusNum);
                    if (num.peekLast() <= 0) {
                        num.pollLast();
                        num.add(0);
                        break outer;
                    }
                }
            }
            sb.append("#").append(T).append(" ");
            while (!num.isEmpty()) {
                sb.append(num.poll()).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
	}
}
