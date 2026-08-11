package dana.m08.programmers;

public class Programmers43165 {
	
    int answer = 0;        

    // dfs 
    void dfs(int index, int currSum, int[] numbers, int target) {
        // base case -> 모든 숫자를 다 탐험 했을때 
        if (index == numbers.length) {
            // target과 같은지 체크. 
            if (currSum == target) {
                answer++; 
            }
            // 숫자를 index까지 탐험했으면 멈춰야된다. 
            return; 
        }
        // add number 
        dfs(index + 1, currSum + numbers[index], numbers, target);
        // subtract number 
        dfs(index + 1, currSum - numbers[index], numbers, target); 
    }
    
    public int solution(int[] numbers, int target) {
        // call dfs 
        dfs(0, 0, numbers, target);
        
        return answer;
    }

}
