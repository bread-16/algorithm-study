package dana.m08.programmers;

public class Programmers42842 {
	
    public int[] solution(int brown, int yellow) {
        
        int[] ans = new int[2];
        // yellow가 가질 수 있는 w, h 고려해보기 (yellow의 약수찾기 -> 제곱근 까지만 구하면 두 쌍을 다 찾은것.)
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
        	// yellow의 약수면: 
            if (yellow % i == 0) { 
                int a = i;
                int b = yellow / i;
                // yellow의 가로, 세로를 이용해 예비 카펫 사이즈 계산해보기. 
                int yellowW = Math.max(a, b);
                int yellowH = Math.min(a, b);
        
                int carpW = yellowW + 2;
                int carpH = yellowH + 2; 

                int totalSquares = carpW * carpH;
                int actualTotalSquares = brown + yellow;
                // 실제 카펫 네모 갯수와 예비 카펫 네모 갯수 같으면, 정답: 
                if (totalSquares == actualTotalSquares) {
                    ans[0] = carpW;
                    ans[1] = carpH;
                    break;
                }
            }
        }
        return ans;
    }
}
