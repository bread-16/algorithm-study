package ohyeon.m09.swea;

import java.util.*;
import java.io.*;

public class swea1225 {
	public static void main(String args[]) throws Exception {
       	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
        for (int T = 0; T < 10; T++) {
            int tc = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<Integer>password = new ArrayDeque<>();
            for (int i = 0; i < 8; i++) {
                password.offer(Integer.parseInt(st.nextToken()));
            }
            boolean check = true;
            while (check) {
            	for (int num = 1; num <= 5; num++) {
                	password.offer(password.poll() - num);
                	if (password.peekLast() <= 0) {
                    	password.pollLast();
                    	password.offer(0);
                    	check = false;
                    	break;
                    }
                }
            }
            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < 8; i++) {
                sb.append(password.poll()).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
	}
}
