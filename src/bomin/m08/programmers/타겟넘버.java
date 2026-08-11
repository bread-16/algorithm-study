package bomin.m08.programmers;

public class 타겟넘버 {

	int target;
	int count;
	int[] numbers;

	public int solution(int[] numbers, int target) {
		// dfs로 depth가 5인거 찾음
		this.numbers = numbers;
		this.target = target;
		count = 0;
		dfs(0, 0, '+');
		dfs(0, 0, '-');

		return count;
	}

	public void dfs(int start, int depth, char plma) {
		//처음에 depth == numbers.length로 종료조건을 맨 위에 넣었는데,
		//계산은 numbers.length -1에서 이미 배열안의 숫자가 전부 계산된 상황 -> +,- dfs를 한번씩 더 돌아서 count가 두배로 나옴.
		//밑으로 옮김
		
		if (plma == '+') {
			start += numbers[depth];
		}
		if (plma == '-') {
			start -= numbers[depth];
		}

		if (depth == numbers.length - 1) {
			if (start == target)
				count++;
			return;
		}

		dfs(start, depth + 1, '+');
		dfs(start, depth + 1, '-');

	}
}
