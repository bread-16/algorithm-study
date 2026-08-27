package jinwoo.m08.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1228 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<10; t++){
			int passwordLen = Integer.parseInt(in.readLine().trim());
			
			List<Integer> passwords = new ArrayList<>();
			
			StringTokenizer pst = new StringTokenizer(in.readLine().trim());
			
			for(int i=0; i<passwordLen; i++) {
				passwords.add(Integer.parseInt(pst.nextToken()));
			}
			
			int insertPasswordCnt = Integer.parseInt(in.readLine().trim());
			String newPasswords = in.readLine().trim();
			StringTokenizer nst = new StringTokenizer(newPasswords, "I");
			for(int i=0; i<insertPasswordCnt; i++) {
				StringTokenizer st = new StringTokenizer(nst.nextToken().trim());
				int targetIndex = Integer.parseInt(st.nextToken());
				int newPasswordLen = Integer.parseInt(st.nextToken());
				
				for(int j=0; j<newPasswordLen; j++) {
					passwords.add(targetIndex, Integer.parseInt(st.nextToken()));
					targetIndex++;
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
