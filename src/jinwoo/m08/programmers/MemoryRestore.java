package jinwoo.m08.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemoryRestore {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t=0; t<T; t++) {
			String targetMemory = in.readLine();
			int answer = 0;
			int targetNum = 0;
			
			// targetMemory를 하나씩 순회
			// 0으로 시작 1이 나온다면 answer + 1, targetNum = 1로 변경
			// 0이 나오면 answer + 1, targetNum = 0으로 변경
			for(int i=0; i<targetMemory.length(); i++) {
				int n = targetMemory.charAt(i) - '0';
				
				if(n != targetNum) {
					answer++;
					targetNum = (targetNum+1)%2;
				}
			}
			
			sb.append("#").append(t+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
