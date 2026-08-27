package jinwoo.m08.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1229 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<10; t++){
			int passwordLen = Integer.parseInt(in.readLine().trim());
			
			List<Integer> passwords = new ArrayList<>();
			
			StringTokenizer pst = new StringTokenizer(in.readLine().trim());
			
			for(int i=0; i<passwordLen; i++) {
				passwords.add(Integer.parseInt(pst.nextToken().trim()));
			}
			
			int updatePasswordCnt = Integer.parseInt(in.readLine().trim());
			StringTokenizer nst = new StringTokenizer(in.readLine().trim());
			for(int i=0; i<updatePasswordCnt; i++) {
				String updateType = nst.nextToken().trim();
				
				if(updateType.equals("D")) {
					int targetIndex = Integer.parseInt(nst.nextToken());
					int cnt = Integer.parseInt(nst.nextToken());
					
					for(int j=0; j<cnt; j++) {
						passwords.remove(targetIndex);
					}
				} else if(updateType.equals("I")) {
					int targetIndex = Integer.parseInt(nst.nextToken());
					int cnt = Integer.parseInt(nst.nextToken());
					
					for(int j=0; j<cnt; j++) {
						passwords.add(targetIndex, Integer.parseInt(nst.nextToken()));
						targetIndex++;
					}
				}
			}
			
			sb.append("#").append(t+1).append(" ");
			
			for(int i=0; i<10; i++) {
				if(i == 9) {
					sb.append(passwords.get(i)).append("\n");
				} else {
					sb.append(passwords.get(i)).append(" ");
				}
			}
		}
		System.out.println(sb);
	}
}
