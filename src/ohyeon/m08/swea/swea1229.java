package ohyeon.m08.swea;

import java.util.*;
import java.io.*;

public class swea1229 {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
        	int cipherLen = Integer.parseInt(br.readLine()); //암호문 길이
        	List<Integer>cipherText = new ArrayList<>(); //암호문 원문
            StringTokenizer st = new StringTokenizer(br.readLine());
        	
            for (int i = 0; i < cipherLen; i++) { //암호문 채워넣기
                cipherText.add(Integer.parseInt(st.nextToken()));
            }
            
            int commandSize = Integer.parseInt(br.readLine()); //명령문 크기
            StringTokenizer cst = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < commandSize; j++) {
                String command = cst.nextToken(); //D인지 I인지 확인
                
                if (command.equals("D")) {//D이면
                    int x = Integer.parseInt(cst.nextToken()); //삭제할 위치
                    int y = Integer.parseInt(cst.nextToken()); //삭제할 갯수
                    for (int k = 0; k < y;  k++) {
                        cipherText.remove(x);//제거
                    }
                } else {
                    int x = Integer.parseInt(cst.nextToken()); //삽입할 위치
                    int y = Integer.parseInt(cst.nextToken()); //삽입할 갯수
                    
                    for (int l = 0; l < y; l++) {
                        cipherText.add(x++, Integer.parseInt(cst.nextToken())); //원문에 삽입
                    }
                }
            }
            sb.append("#").append(tc).append(" ");
            for (int k = 0; k < 10; k++) {
                sb.append(cipherText.get(k)).append(" ");
            }
        }
        System.out.print(sb.toString());                                       
	}
}
