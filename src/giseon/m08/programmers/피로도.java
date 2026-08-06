class 피로도 {
    int[][] dungeons; // 던전 배열 매개변수로 주지 않고 멤버에서 지속 참조
    static boolean[] visited; // 방문 여부
    static int answer;

    public int solution(int k, int[][] dungeons) {
        this.dungeons = new int[dungeons.length][2];
        this.dungeons = dungeons;
        visited = new boolean[dungeons.length];

        dfs(k, 0); // 깊이 탐색 시작

        return answer;
    }

    public void dfs(int energy, int count) {
        answer = Math.max(answer, count); // 재귀 깊어질때마다 max 횟수 갱신
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && energy >= dungeons[i][0]) { // 방문하지 않고 에너지가 최소피로도 이상이면
                visited[i] = true; // 방문 상태 활성화 후
                dfs(energy - dungeons[i][1], count + 1); // 소모 피로도만큼 감소시키고 더 깊게 탐색한다.
                visited[i] = false; // 방문이 끝났다면 다시 탐색해야하므로 상태 비활성화
            }
        }

    }
}
