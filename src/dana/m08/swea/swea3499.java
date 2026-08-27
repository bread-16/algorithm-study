package dana.m08.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea3499 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		
		int T = Integer.parseInt(br.readLine()); 
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine()); 
			
			// 0. 반절의 반올림이 첫번쩨 큐에 들어갈 아이템 갯수 
			int firstHalfNum = (int) Math.ceil(N / 2.0); 
			
			// 1. 2개의 큐를 사용하기 
			Queue<String> q1 = new ArrayDeque<>(); 
			Queue<String> q2 = new ArrayDeque<>(); 
			
			// 토큰으로 하나씩 가져오기 
			String line = br.readLine(); 
			StringTokenizer st = new StringTokenizer(line);
			for (int n = 0; n < N; n++) {
				if (n < firstHalfNum) {
					q1.offer(st.nextToken()); 
				} else {
					q2.offer(st.nextToken()); 
				}
			}
			
			// 2. 정답을 담을 배열 생성하기 -> 2개의 큐를 번갈아 가며 정답 배열에 넣어준다 
			String[] answer = new String[N];
			for (int n = 0; n < N / 2; n++) {
				answer[2*n] = q1.poll();
				answer[2*n + 1] = q2.poll();
			}
			// 3. 만약 N이 홀수였다면 마지막에 한개 더 넣어주기 (첫 큐가 더 길니까 첫 큐에서 받아오기) 
			if (N % 2 != 0) {
				answer[N - 1] = q1.poll();
			}
			
			// sb 
			sb.append("#").append(tc).append(" ").append(String.join(" ", answer)).append("\n"); 
		}
		System.out.print(sb); 
	}

}
