package bomin.m08.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 원재의메모리복구하기 {
	static int bits[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String line = br.readLine();
			bits = new int[line.length()];
			for (int i = 0; i < line.length(); i++) {
				bits[i] = line.charAt(i) - '0';
			}
			int[] start = new int[bits.length];
			int count = 0;
			for(int left = 0; left<start.length; left++) {
				if(start[left] != bits[left]) {
					count++;
					tradeoff(start, left);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}

	static void tradeoff(int[] bits, int index) {
		if (bits[index] == 0) {
			for (int i = index; i < bits.length; i++) {
				bits[i] = 1;
			}
		} else {
			for (int i = index; i < bits.length; i++) {
				bits[i] = 0;
			}
		}
	}
}
