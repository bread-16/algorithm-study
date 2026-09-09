package jinwoo.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2806 {
	static int N;
    static int[] queens;
    static int answer;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(in.readLine().trim());
        for(int t=0; t<T; t++) {
            N = Integer.parseInt(in.readLine().trim());
            // 퀸 위치(index = 행, value = 열) // 행은 시작부터 다 다르게
            queens = new int[N];
            
            answer = 0;
            
            dfs(0);
            
            sb.append("#").append(t+1).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    
    static public void dfs(int depth) {
        
    	// 모두 통과해서 N개의 퀸을 두었다면 정답 + 1
    	if(depth == N) {
    		answer++;
    		return;
    	}
    	
        for(int i=0; i<N; i++) {
            
        	queens[depth] = i;
        	
        	if(check(depth)) {
        		dfs(depth+1);
        	}
        	
        }
    }
    
    static public boolean check(int depth) {
    	// 그 전까지 두었던 퀸 전부와 비교(같은 열 X, 대각선 X)
    	for(int i=0; i<depth; i++) {
    		// 열이면 false; // index = 행(다 다르게 설정) value = 열(하나씩 순회하며 같은지 조회)
    		if(queens[i] == queens[depth]) {
    			return false;
    		}
    		
    		// 대각선에 있으면 false, 대각선인지? |(X1 - X2)| == |(Y1 - Y2)|
    		if(Math.abs(depth - i) == Math.abs(queens[depth] - queens[i])) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}
