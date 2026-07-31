package jinwoo.m07.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PasswordConstructure_D3 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		for(int t=0; t<10; t++) {
			
			in.readLine();
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int[] arr = new int[8];
			
			for(int i=0; i<8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 20분/  num이 0보다 적어질 경우 계산, while 조건 변경하면 끝일듯?
			boolean a = true;
			while(a) {
				for(int i=1; i<=5; i++) {
					int num = arr[0] - i;
					if(num <= 0) {
						num = 0;
						a = false;
						i = 6;
					}
					
					for(int j=0; j<7; j++) {
						arr[j] = arr[j+1];
					}
					
					arr[7] = num;
				}
			}
			
			sb.append("#").append(t+1).append(" ");
			for(int i=0; i<8; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
