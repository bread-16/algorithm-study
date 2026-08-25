package dana.m08.swea;

import java.util.*; 
import java.io.*; 

public class swea1289 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); 
		
		for (int tc = 1; tc <= T; tc++) {
			
			String line = br.readLine(); 
			// input numbers 
			int[] nums = new int[line.length()]; 
			// filling in numbers 
			for (int n = 0; n < nums.length; n++) {
				nums[n] = line.charAt(n) - '0'; 
			}
			
			// when current number changes from prev, increment counter 
			int answer = 0; 
			for (int n = 0; n < nums.length; n++) {
				
			}
			
			// print answer here 
						
		}
	}

}
