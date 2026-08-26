package ohyeon.m08.swea;

import java.util.*;
import java.io.*;

public class swea3499 {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Queue<String> front = new ArrayDeque<>(); //앞 카드 덱 큐 생성
        Queue<String> back = new ArrayDeque<>();  //뒷 카드 덱 큐 생성
        
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
           	StringTokenizer st = new StringTokenizer(br.readLine());
            int frontLen = 0;
            
            if (N % 2 == 0) {
                frontLen = N / 2; //앞 카드 덱 크기
            } else {
                frontLen = (N / 2) + 1; //앞 카드 덱 크기
            }
            int backLen = N - frontLen; //뒷 카드 덱 크기
            
            for (int i = 0; i < frontLen; i++) {
                front.offer(st.nextToken()); //앞 카드 덱 형성 
            }
            for (int i = 0; i < backLen; i++) {
                back.offer(st.nextToken()); //뒷 카드 덱 형성
            }
            
            sb.append("#").append(tc).append(" ");
            
            for (int i = 0; i < backLen; i++) {
                sb.append(front.poll()).append(" ").append(back.poll()).append(" "); // 번갈아서 넣기
            }
            if (!front.isEmpty()) {
                sb.append(front.poll()); // 앞 카드 덱이 많은 경우 한번 더 실행
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
	}
}
