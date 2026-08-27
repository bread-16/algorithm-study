package ohyeon.m08.swea;

import java.util.*;
import java.io.*;

public class swea1228 {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int tc = 1; tc <= 10; tc++) {
            List<Integer> cipherText = new ArrayList<>(); //암호문 원문
            int cipherLen = Integer.parseInt(br.readLine()); //암호문 길이
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < cipherLen; i++) { //암호문 채워넣기
                cipherText.add(Integer.parseInt(st.nextToken()));
            }
            
            int commandSize = Integer.parseInt(br.readLine()); //명령문 크기
            st = new StringTokenizer(br.readLine(), "I"); //I기준으로 토큰 생성
 
            for (int j = 0; j < commandSize; j++) {
                List<Integer> commandCipher = new ArrayList<>(); //삽입할 암호문
                String command = st.nextToken().trim();
                StringTokenizer xys = new StringTokenizer(command, " "); 
                int x = Integer.parseInt(xys.nextToken()); //삽입할 위치
                int y =Integer.parseInt(xys.nextToken()); //삽입할 갯수
                
                for (int k = 0; k < y; k++) {
                	commandCipher.add(Integer.parseInt(xys.nextToken())); //삽입할 암호문 완성 
                }
                
                cipherText.addAll(x, commandCipher); //웜문에 삽입
            }
            sb.append("#").append(tc).append(" ");
            for (int l = 0; l < 10; l++) {
                sb.append(cipherText.get(l)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
	}
}
