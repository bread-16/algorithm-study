package giseon.m08.programmers;

// 4.65ms, 84.3MB
class 전력망을둘로나누기 {

    // 전선 정보는 변하지 않는 값이기 때문에 멤버 변수로 정해서 매개변수로 지속적으로 넘기지 않게 하여 메모리 손실 방지
    private int[][] wires;
    
    public int solution(int n, int[][] wires) {
        this.wires = wires;
        int answer = n; // 최솟값을 찾기 때문에 초기값을 상한으로 설정(송전탑 개수 <= n)

        // 모든 전선을 하나씩 끊어본다.
        for (int cut = 0; cut < wires.length; cut++) {

            boolean[] visited = new boolean[n + 1];

            // 첫 번째 송전탑에서 시작해서 한쪽 송전탑의 개수를 센다.
            int count = dfs(1, cut, visited);

            // 나머지 송전탑 개수
            int other = n - count;

            // 두 전력망의 송전탑 개수 차이
            int diff = Math.abs(count - other);

            answer = Math.min(answer, diff);
        }

        return answer;
    }

    public int dfs(int current, int cut,boolean[] visited) {
        visited[current] = true;

        int count = 1;

        // 모든 전선을 확인한다.
        for (int i = 0; i < wires.length; i++) {

            // 현재 끊어놓은 전선은 탐색x
            if (i == cut) {
                continue;
            }

            int a = wires[i][0];
            int b = wires[i][1];

            int next = -1;

            // 현재 정점과 연결된 정점 찾기.
            if (a == current) {
                next = b;
            } else if (b == current) {
                next = a;
            }

            // 연결되지 않은 전선이면 탐색x
            if (next == -1) {
                continue;
            }

            // 이미 방문한 송전탑이면 탐색x
            if (visited[next]) {
                continue;
            }

            // 연결된 송전탑을 계속 탐색
            count += dfs(next, cut, visited);
        }

        return count;
    }
}
