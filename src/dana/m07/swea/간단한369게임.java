package dana.m07.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

/*
 * 전략:
 * - 각 숫자마다 3, 6, 9가 몇개 있는지 카운트 
 * 		-> 인덱싱이 필요 -> 스트링으로 형변환해서 .charAt() 사용하기
 * - 현 숫자가 3, 6, 9를 포함하면 갯수만큼 "-" 프린트하기 
 * - 아니면 원래 숫자 프린트하기 
 * - 각 숫자가 끝나고 나면 간격 붙여주기: " "
 * */

class 간단한369게임
{
	public static void main(String args[]) throws Exception
	{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // N 입력값 
        int N = Integer.parseInt(in.readLine());
            
        for (int i = 1; i <= N; i++) {
    		// 각 숫자마다 3, 6, 9가 몇개 있는지 카운트 
        	// 인덱싱이 필요 -> 스트링으로 형변환해서 .charAt() 사용하기
        	String strNum = String.valueOf(i);
        	int strNumLen = strNum.length();
        	
        	int clapCnt = 0; 
        	for (int n = 0; n < strNumLen; n++) {
        		if (strNum.charAt(n) == '3' || strNum.charAt(n) == '6' || strNum.charAt(n) == '9') {
        			clapCnt++;
        		}
            }
        	// 현 숫자가 3, 6, 9를 포함하면 갯수만큼 "-" 프린트하기 
    		if (clapCnt > 0) {
    			for (int c = 0; c < clapCnt; c++) {
    				System.out.print("-");
    			}
    		// 아니면 원래 숫자 프린트하기 
    		} else {
    			System.out.print(strNum);
    		}
    		// 각 숫자가 끝나고 나면 간격 붙여주기: " "
    		System.out.print(" ");
		}
	}
}