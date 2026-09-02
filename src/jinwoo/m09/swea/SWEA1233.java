package jinwoo.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1233 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<10; t++) {
			boolean isPosible = true;
			
			int nodeNum = Integer.parseInt(in.readLine().trim());
			
			for(int i=0; i<nodeNum; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine().trim());
				
				if(!isPosible) continue;
				
				st.nextToken();
				
				String node = st.nextToken();
				
				if(!st.hasMoreTokens()) {
					if(node.equals("/") || node.equals("+") || node.equals("-") || node.equals("*")) {
						isPosible = false;
					}
				} else {
					if(!(node.equals("/") || node.equals("+") || node.equals("-") || node.equals("*"))) {
						isPosible = false;
					}
				}
			}
			
			int answer = 0;
			
			if(isPosible) {
				answer = 1;
			}
			
			sb.append("#").append(t+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
