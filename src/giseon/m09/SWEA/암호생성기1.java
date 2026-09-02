package giseon.m09.SWEA;

import java.io.*;
import java.util.*;

public class 암호생성기1 {
    public static void change(int[] arr, int data) {
        arr[0] = data;
        arr[8] = arr[0];
        for (int i = 1; i < 9; i++) {
            arr[i - 1] = arr[i];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int num; // 테케 번호 입력 변수
        int[] password; // 암호 배열
        boolean condition = true;
        int data; // 사이클 진행하면서 저장할 임시 변수
        
        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine());
            
            num = Integer.parseInt(st.nextToken());
            password = new int[9];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                password[i] = Integer.parseInt(st.nextToken());
            }
            
            condition = true;
            while (condition) {
                for (int i = 1; i <= 5; i++) {
                    data = password[0] - i;
                    if (data <= 0) {
                        change(password, 0);
                        condition = false;
                        break;
                    } else {
                        change(password, data);
                    }
                }
            }
            
            for (int i = 0; i < 8; i++) {
                sb.append(password[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
