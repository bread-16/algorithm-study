package seohee.m08.programmers;

import java.util.*;

// 	통과 (0.59ms, 84.7MB)
public class 여행경로_2 {
    List<String> result = new ArrayList<>();
    Map<String, List<String>> graph = new HashMap<>();
    int n;

    public String[] solution(String[][] tickets) {
        n = tickets.length;

        for (String[] t : tickets) {
            graph.computeIfAbsent(t[0], k -> new ArrayList<>()).add(t[1]);
        }
        for (List<String> list : graph.values()) {
            Collections.sort(list);
        }

        result.add("ICN");
        dfs(0, "ICN");

        return result.toArray(new String[0]);
    }

    private boolean dfs(int depth, String last) {
        if (depth == n) {
            return true;
        }

        List<String> nexts = graph.get(last);
        if (nexts == null) return false;

        for (int i = 0; i < nexts.size(); i++) {
            String next = nexts.get(i);
            nexts.remove(i);
            result.add(next);
            if (dfs(depth + 1, next)) return true;
            result.remove(result.size() - 1);
            nexts.add(i, next);
        }

        return false;
    }
}