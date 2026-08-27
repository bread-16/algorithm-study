package dana.m08.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea1229 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		
		// 테케수 = 10으로 지정
		for (int tc = 1; tc <= 10; tc++) {
			
			// N = 원본 암호문의 길이 
			int N = Integer.parseInt(br.readLine());
			
			// String 으로 받아서 토크나이저로 빼오기 
			String originalLine = br.readLine(); 
			StringTokenizer st = new StringTokenizer(originalLine); 
			
			// 1. List로 원본 받기 
			List<Integer> original = new ArrayList<>(); 
			for (int i = 0; i < N; i++) {
				original.add(Integer.parseInt(st.nextToken())); 
			}
			
			// M = 명령어의 수 
			int M = Integer.parseInt(br.readLine()); 
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < M; i++) {
				// 현재 opperation이 뭔지 
				String opperation = st.nextToken();
				// "I" 면 추가 
				if (opperation.equals("I")) {
					
					int startIndex = Integer.parseInt(st.nextToken());
					int numCommand = Integer.parseInt(st.nextToken());
					List<Integer> commands = new ArrayList<>();
					
					for (int j = 0; j < numCommand; j++) {
						commands.add(Integer.parseInt(st.nextToken())); 
					}
					
					original.addAll(startIndex, commands); 
				// "D" 면 지우기 
				} else if (opperation.equals("D")) {
					
					int startIndex = Integer.parseInt(st.nextToken());
					int numOpperations = Integer.parseInt(st.nextToken());
					
					original.subList(startIndex, startIndex + numOpperations).clear();
				}
			}
			// sb 
			sb.append("#").append(tc); 
			
			// [ ] 없애기 & 10개만 답에 넣기 
			for (int n = 0; n < 10; n++) {
				int currNum = original.get(n); 
				sb.append(" ").append(currNum); 
			}
			
			sb.append("\n"); 
		}
		System.out.println(sb);
	}

}
