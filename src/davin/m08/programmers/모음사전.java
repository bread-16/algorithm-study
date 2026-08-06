package davin.m08.programmers;

import java.util.*;

public class 모음사전 {
    List<String> list = new ArrayList<>();
    char[] vowels = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        dfs("");
        return list.indexOf(word) + 1;
    }

    void dfs(String current) {
        if (current.length() == 5) return;
        if (current.length() > 0) list.add(current);
        
        for (char c : vowels) {
            dfs(current + c);
        }
    }
}
