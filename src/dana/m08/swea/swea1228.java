package dana.m08.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea1228 {
	
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
			
			// 2. 명령어 포멧 정리하기 
			
			// 3개의 리스트 -> 시작, 갯수, 명령어들 
			List<Integer> startIndexes = new ArrayList<>(); 
			List<Integer> numCommands = new ArrayList<>();
			List<List<Integer>> commands = new ArrayList<>(); 
			
			// String 으로 받아서 토크나이저로 빼오기 
			String line = br.readLine(); 
			st = new StringTokenizer(line); 
			
			for (int i = 0; i < M; i++) {
				// "|"
				st.nextToken(); 
				
				// startIndex 
				int startIndex = Integer.parseInt(st.nextToken());
				// numCommands
				int numCommand = Integer.parseInt(st.nextToken());
				
				// commands 
				List<Integer> command = new ArrayList<>(); 
				for (int c = 0; c < numCommand; c++) {
					command.add(Integer.parseInt(st.nextToken())); 
				}
				
				startIndexes.add(startIndex);
				numCommands.add(numCommand);
				commands.add(command);
			}
			
			// 3. 명령어 만큼 for문 반복 
			for (int i = 0; i < M; i++) {
				int startIndex = startIndexes.get(i); 
				int cmdNums = numCommands.get(i); 
				List<Integer> cmds = commands.get(i); 
				
				original.addAll(startIndex, cmds);
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
