package jinwoo.m08.programmers;

public class TargetNumber {
	
	int[] arr;
	int targetNum;
	int answer;
	
	public int solution(int[] numbers, int target) {
		
		arr = numbers;
		targetNum = target;
		answer = 0;
		
		dfs(0, 0);
	
        return answer;
    }
	
	// r은 idx, n은 더하거나 뺀 결과, ???
	public void dfs(int r, int n) {
		
		if(r == arr.length) {
			if(n == targetNum) answer++;
			return;
		}
		
		for(int i=0; i<2; i++) {
			if(i == 0) {
				dfs(r+1, n + arr[r]);
			} else {
				dfs(r+1, n - arr[r]);
			}
		}
		
	}
}
