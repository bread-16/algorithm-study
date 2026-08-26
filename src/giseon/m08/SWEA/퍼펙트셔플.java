package giseon.m08.SWEA;

import java.util.*;
import java.io.*;
 
public class 퍼펙트셔플 {
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // 출력 형식 맞추기
            sb.append("#").append(tc).append(" ");
             
            int N = Integer.parseInt(br.readLine());
            String[] cards = new String[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cards[i] = st.nextToken();
            }
            // 투 포인터로 범위 나눠서 번갈아가면서 넣어서 출력하기
            int p1 = 0;
            int p2;
            
            // 카드 하나면 빠르게 처리
            if (N == 1) {
                sb.append(cards[0]).append(" ");
                continue;
            }
            // N이 짝수면 p1: 0~N/2-1 | p2: N/2 ~ N-1
            else if (N % 2 == 0) {
                p2 = N/2;
                while (p2 <= N - 1) {
                    sb.append(cards[p1++]).append(" ");
                    sb.append(cards[p2++]).append(" ");
                }
            } else { // N이 홀수면 p1: 0~N/2 | p2: N/2+1 ~ N-1
                p2 = N/2 + 1;
                while (p1 <= N/2) {
                    if (p2 != N-1) {
                        sb.append(cards[p1++]).append(" ");                     
                        sb.append(cards[p2++]).append(" ");     
                    } else {
                        sb.append(cards[p1++]).append(" ");
                        sb.append(cards[p2++]).append(" ").append(cards[p1++]).append(" ");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
