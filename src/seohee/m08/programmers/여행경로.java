package seohee.m08.programmers;

import java.util.*;

// 통과 (4.12ms, 73.9MB)
public class 여행경로 {
    List<String> result = new ArrayList<>();
    boolean[] visited;
    String[][] tickets;
    int n;

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        n = tickets.length;
        visited = new boolean[n];

        Arrays.sort(tickets, Comparator.comparing(a -> a[1]));

        result.add("ICN");
        dfs(0, "ICN");

        return result.toArray(new String[0]);
    }

    private boolean dfs(int depth, String last) {
        if (depth == n) {
            return true;
        }


        for (int j = 0; j < n; j++) {
            if (tickets[j][0].equals(last) && !visited[j]) {
                result.add(tickets[j][1]);
                visited[j] = true;
                boolean finish = dfs(depth + 1, tickets[j][1]);
                if (finish) return true;
                result.remove(result.size() - 1);
                visited[j] = false;
            }
        }
        return false;
    }
}
