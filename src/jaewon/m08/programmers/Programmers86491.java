package jaewon.m08.programmers;

public class Programmers86491 {
	class Solution {
		public int solution(int[][] sizes) {
			int answer = 0;
			
			int leftMax=0;
			int rightMax=0;

			for (int[] x : sizes) {
				if(x[0] >= x[1]) {
					leftMax = Math.max(x[0], leftMax);
					rightMax = Math.max(x[1], rightMax);
				}
				else {
					leftMax = Math.max(x[1], leftMax);
					rightMax = Math.max(x[0], rightMax);
				}
			}
			
			answer = leftMax * rightMax;

			return answer;
		}
	}
}
