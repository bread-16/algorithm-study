package giseon.m08.programmers;

import java.util.*;

class 여행경로 {
    String[][] tickets;
    boolean[] visited;
    List<String> route;

    public String[] solution(String[][] tickets) {
        this.visited = new boolean[tickets.length];
        this.route = new ArrayList<>();
        // 미리 티켓들을 정렬해놓으면 앞선 순서의 경우부터 비교하게 되므로 정렬
        Arrays.sort(tickets, (a, b) -> {
            // 만약 출발지가 같다면 목적지를 비교해서 알파벳 순서 앞선것을 택한다.
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        this.tickets = tickets;

        route.add("ICN");
        dfs("ICN");

        String[] answer = new String[route.size()];
        for (int i = 0; i < route.size(); i++) {
            answer[i] = route.get(i);
        }

        return answer;
    }

    public boolean dfs(String cur) {
        // 모든 티켓을 사용했다면 성공
        if (route.size() == tickets.length + 1) { // route.size는 노드들의 개수이므로 경로 개수보다 1 크면
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            // 아직 방문하지 않은 티켓의 출발지가 current인 것을 찾는다.
            if (!visited[i] && tickets[i][0].equals(cur)) {
                // 티켓 선택
                visited[i] = true;

                // 경로에 도착 공항 추가
                route.add(tickets[i][1]);

                // 다음 공항으로 이동
                if (dfs(tickets[i][1])) {
                    return true;
                }

                // 실패했으므로 원상복구
                route.remove(route.size() - 1);
                visited[i] = false;
            }
        }

        return false;
    }
}
