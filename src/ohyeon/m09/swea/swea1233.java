package ohyeon.m09.swea;

import java.util.*;
import java.io.*;

public class swea1233 {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            int check = 1;
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                String mid = st.nextToken();
                if (st.hasMoreTokens()) {
                	if (!(mid.equals("+") || mid.equals("-") || mid.equals("*") || mid.equals("/"))) {
                    	check = 0;
                	}
                	while (st.hasMoreTokens()) {
                        st.nextToken();
                    }
            	} else {
           			if (mid.equals("+") || mid.equals("-") || mid.equals("*") || mid.equals("/")) {
                    	check = 0;
                	}
            	}
            }
            sb.append("#").append(tc).append(" ").append(check).append("\n");
        }
        System.out.print(sb.toString());                        
	}
}
