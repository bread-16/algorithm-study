package giseon.m08.SWEA;

import java.util.*;
import java.io.*;

public class 원재의메모리복구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int count = 0;
			String bits = br.readLine();
			if (bits.charAt(0) == '1') count++;
			for (int i = 1; i < bits.length(); i++) {
				if (bits.charAt(i)!= bits.charAt(i-1)) {
					count++;
				}
			}
			
			sb.append(count).append("\n");
		}
		
		System.out.print(sb);
	}
}
