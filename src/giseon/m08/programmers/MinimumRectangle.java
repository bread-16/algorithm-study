package giseon.m08.programmers;

public class MinimumRectangle {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };

        System.out.println(solution.solution(sizes));

    }
}

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int wmax = 0;
        int hmax = 0;

        for (int i = 0; i < sizes.length; i++) {
            wmax = Math.max(wmax, Math.max(sizes[i][0], sizes[i][1]));
            hmax = Math.max(hmax, Math.min(sizes[i][0], sizes[i][1]));
        }
        answer = wmax * hmax;

        return answer;
    }
}

// 통과 (0.01ms, 72.9MB)
