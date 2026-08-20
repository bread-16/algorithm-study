package dana.m08.programmers;

import java.util.*;

public class Programmers43164 {
	

    boolean[] visited;
    List<String> route = new ArrayList<>();

    public String[] solution(String[][] tickets) {

        // 1. Sort tickets alphabetically by destination
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        // 2. visited array
        visited = new boolean[tickets.length];

        // 3. Always start at ICN
        route.add("ICN");

        // 4. DFS
        dfs("ICN", tickets);

        // 5. Convert List<String> → String[]
        return route.toArray(new String[0]);
    }

    boolean dfs(String currAirport, String[][] tickets) {

        // Base case:
        // If we've visited every ticket, we're done.
        if (route.size() == tickets.length + 1) {
            return true;
        }

        // Try every ticket
        for (int i = 0; i < tickets.length; i++) {

            // Can we use this ticket?
            if (!visited[i] && tickets[i][0].equals(currAirport)) {

                // Use ticket
                visited[i] = true;

                // Move to destination
                route.add(tickets[i][1]);

                // Continue DFS
                if (dfs(tickets[i][1], tickets)) {
                    return true;
                }

                // Backtrack
                route.remove(route.size() - 1);
                visited[i] = false;
            }
        }

        // No valid route from here
        return false;
    }

}
