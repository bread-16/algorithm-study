package jinwoo.m08.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3499 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t=0; t<T; t++) {
			
			int cardNum = Integer.parseInt(in.readLine());
			
			String cards = in.readLine();
			
			String[] cardsArr = new String[cardNum];
			
			StringTokenizer st = new StringTokenizer(cards);
			
			for(int i=0; i<cardNum; i++) {
				cardsArr[i] = st.nextToken();
			}
			
			String answer = "";
			
			for(int i=0; i<cardNum/2; i++) {
				if(cardNum % 2 == 1) {
					answer = answer + cardsArr[i] + " " + cardsArr[i + (cardNum/2+1)] + " ";
				} else {
					answer = answer + cardsArr[i] + " " + cardsArr[i + (cardNum/2)] + " ";
				}
				
			}
			
			if(cardNum % 2 == 1) {
				answer += cardsArr[cardNum/2];
			}
			
			sb.append("#").append(t+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}