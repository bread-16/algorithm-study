package giseon.m08.programmers;

import java.util.HashSet;

class 소수찾기 {

    // 중복으로 생성되는 숫자를 제거하기 위한 Set 사용
    HashSet<Integer> set = new HashSet<>();
    // 각 자리의 숫자를 사용했는지 체크
    boolean[] visited;

    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];

        // 현재 만든 숫자는 0부터 시작(dfs 내에서만 로직 구현하기 위함)
        dfs(0, numbers);

        // 만들어진 숫자들 중 소수의 개수만 카운트
        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    // current : 지금까지 만든 숫자
    void dfs(int current, String numbers) {

        // 현재까지 만든 숫자를 저장
        // (0도 저장되지만 isPrime()에서 걸러짐
        set.add(current);

        // 모든 숫자를 하나씩 선택
        for (int i = 0; i < numbers.length(); i++) {

            // 이미 사용한 숫자는 패스
            if (visited[i])
                continue;

            // 1. 선택
            visited[i] = true;

            // 문자 -> 숫자로 변환
            int digit = numbers.charAt(i) - '0';
            // 새로운 순열 만들기(자릿수 올리고 뒷자리에 붙이기)
            dfs(current * 10 + digit, numbers);

            // 2. 선택 취소(백트래킹)
            visited[i] = false;
        }
    }

    // 소수 판별
    boolean isPrime(int n) {
        // 소수는 2부터 시작하므로 0, 1 제외
        if (n < 2)
            return false;

        // √n까지 검사 : n 이하인 m에서 m = ab 일떄 a, b 중 적어도 하나는 √n이하이기 때문이다.
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
