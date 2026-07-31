package jinwoo.m08.programmers;

public class MinimumRectangle {
	public static void main(String[] args) {

		Solution solution = new Solution();
		int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };

		System.out.println(solution.solution(sizes));

	}
}

class Solution {
	public int solution(int[][] sizes) {

		int maxSize = 0;
		int secondSize = 0;

		for (int i = 0; i < sizes.length; i++) {
			for (int j = 0; j < 2; j++) {
				maxSize = Math.max(maxSize, sizes[i][j]);
			}
			secondSize = Math.max(secondSize, Math.min(sizes[i][0], sizes[i][1]));
		}

		int answer = maxSize * secondSize;

		return answer;
	}
}
