package bomin.m08.programmers;

public class 최소직사각형 {
	public int solution(int[][] sizes) {
		int answer = 0;
		int temp = 0 ;
		int max_row = Integer.MIN_VALUE;
		int max_col = Integer.MIN_VALUE;
		for (int i = 0; i < sizes.length; i++) {
			for(int j=0;j<sizes[i].length;j++) {
				//(i,0)보다 (i,1)이 길면 가로 세로 변경
				if(sizes[i][0]<= sizes[i][1]) {
					temp = sizes[i][0];
					sizes[i][0] = sizes[i][1];
					sizes[i][1] = temp;
				}
				
			}
		}
		for(int i=0; i< sizes.length;i++) {
			if(sizes[i][0]>=max_row)
				max_row = Math.max(sizes[i][0], max_row);
			if(sizes[i][1]>=max_col)
				max_col = Math.max(sizes[i][1], max_col);
		}
		
		answer = max_row * max_col;
		

		return answer;
	}
}
