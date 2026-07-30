package bomin.m07.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 삼육구게임 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=N;i++) {
			String st = String.valueOf(i);
			
			//3,6,9 포함되어있으면 -로 변경, 나머지는 공백으로 변경.
			if(st.contains("3")|| st.contains("6")||st.contains("9")) {
				st = st.replaceAll("[369]", "-");
				st = st.replaceAll("[1245780]", "");
			}
			
			sb.append(st + " ");

		}
		
		System.out.println(sb);
	}
}
