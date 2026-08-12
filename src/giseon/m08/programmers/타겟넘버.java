package giseon.m08.programmers;

// 3.92ms, 81.8MB
class 타겟넘버 {

    int[] numbers;
    int answer;
    int target;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        dfs(0, 0);

        return answer;
    }

    public void dfs(int idx, int current) {
        if (idx == numbers.length) {
            if (current == target) {
                answer++;
            }
            return;
        }

        dfs(idx + 1, current + numbers[idx]);

        dfs(idx + 1, current - numbers[idx]);
    }
}
