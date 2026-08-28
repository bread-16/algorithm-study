package giseon.m08.SWEA;

import java.util.*;
import java.io.*;

public class 암호문1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(tc).append(" ");
            // 암호문 길이 입력
            int N = Integer.parseInt(br.readLine().trim());
            List<String> list = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            // 원본 암호문 연결리스트에 추가
            for (int i = 0; i < N; i++) {
                list.add(st.nextToken());
            }

            // 명령어 개수 입력
            int numInst = Integer.parseInt(br.readLine());

            // 삽입 명령어 실행
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < numInst; i++) {
                st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                for (int j = x; j < x + y; j++) {
                    list.add(j, st.nextToken());
                }
            }
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        } // tc end
        System.out.print(sb);
    } // main end
}
