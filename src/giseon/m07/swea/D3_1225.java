package giseon.m07.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1225 {
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
        boolean condition = true; // 사이클 지속할지 결정하는 조건 변수
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

            while (condition) { // 사이클을 반복
                for (int i = 1; i <= 5; i++) { // 사이클
                    data = password[0] - i; // 암호 생성 과정
                    if (data <= 0) { // 암호 생성 과정에서 요소가 0보다 작거나 0이 되면 맨 뒤로 보내고 사이클 종료
                        change(password, 0);
                        condition = false;
                        break;
                    } else {
                        change(password, data);
                    }
                }
            }
            for (int i = 0; i < 8; i++) { // 케이스마다 암호를 양식에 맞춰 sb에 저장
                sb.append(password[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb); // sb에 모아둔 결과값 한꺼번에 출력
    }
}