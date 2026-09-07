package jinwoo.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA8275 {

	static int[][] record;
	static int[] cases;
	static int answer;
	static int caseNum;
	static int caseMaxNum;
	static int recordNum;
	static int[] answerCase;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine().trim());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());

			caseNum = Integer.parseInt(st.nextToken());
			caseMaxNum = Integer.parseInt(st.nextToken());
			recordNum = Integer.parseInt(st.nextToken());

			record = new int[recordNum][3];

			for (int i = 0; i < recordNum; i++) {
				st = new StringTokenizer(in.readLine().trim());
				record[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()) };
			}

			cases = new int[caseNum];
			answerCase = new int[caseNum];

			for (int i = 0; i < caseNum; i++) {
				cases[i] = -1;
			}

			answer = -1;
			
			dfs(0);
			
			sb.append("#").append(t+1).append(" ");
			if(answer == -1) {
				sb.append(answer);
			} else {
				for(int i=0; i<caseNum; i++) {
					sb.append(answerCase[i]).append(" ");
				}
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int depth) {
		if(depth == caseNum) {
			// 조건 충족하는지 검사
			if(check()) {
				int newHamsterNum = 0;
				
				for(int i=0; i<caseNum; i++) {
					newHamsterNum += cases[i];
				}
				
				if(newHamsterNum > answer) {
					answer = newHamsterNum;
					for(int i=0; i<caseNum; i++) {
						answerCase[i] = cases[i];
					}
				}
			} 
			return;
		}
		
		for(int i=0; i<=caseMaxNum; i++) {
			cases[depth] = i;
			dfs(depth+1);
		}
	}
	
	static boolean check() {
		boolean isCheck = true;
		for(int[] r : record) {
			
			int hamsterNum = 0;
			
			for(int i = r[0]-1; i<r[1]; i++) {
				hamsterNum += cases[i];
			}
			
			if(hamsterNum != r[2]) {
				isCheck = false;
				break;
			}
		}
		return isCheck;
	}
}
