package ohyeon.m08.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea1289 {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= T; i++) {
            int count = 0;
            String memory = br.readLine();
            
            char[] currArr = new char[memory.length()];
            for (int j = 0; j < memory.length(); j++) {
                currArr[j] = '0';
            }
            
            for (int k = 0; k < memory.length(); k++) {
               char target = memory.charAt(k);
                
                if (currArr[k] != target) {
                    count++;
                    for (int j = k; j < memory.length(); j++) {
                        currArr[j] = target;
                    }
                }
            }
            sb.append("#").append(i).append(" ").append(count).append("\n");
        }
        System.out.print(sb.toString());
	}
}
