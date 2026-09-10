package giseon.m09.SWEA;

import java.util.*;
import java.io.*;
 
public class 장훈이의높은선반 {
    static int[] heights; // 직원 키 배열
    static int N;
    static int B;
    static int minHeight;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
 
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
 
            heights = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }
 
            minHeight = 200000; // 높이 최대 200,000
            dfs(0, 0);
             
            sb.append('#').append(tc).append(' ').append(minHeight - B).append('\n');
        } // tc end
        System.out.print(sb);
    } // main end
 
    // height: 탑의 높이
    static void dfs(int height, int index) {
        if (height >= B) { // B 이상이 되는 순간 확인
            if (minHeight < height) return; // 이전 최솟값보다 커져버리면 더이상 계산x
 
            minHeight = height; // 최솟값 갱신
        }
         
        if (index == N) return;
         
        // 안뽑는 가짓수
        dfs(height, index + 1);
        // 뽑는 가짓수
        dfs(height + heights[index], index + 1);
         
    } // dfs end
 
} // class end