package seohee.m08.programmers;

public class 모음사전 {
    int answer;
    String word;
    char[] arr = { 'A', 'E', 'I', 'O', 'U' };

    public int solution(String word) {
        this.word = word;
        dfs(0, new StringBuilder());
        return answer;
    }

    private int dfs(int depth, StringBuilder sb) {

        if (sb.toString().equals(word)) {
            return answer;
        }

        if (depth == 5) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            answer++;
            int result = dfs(depth + 1, sb.append(arr[i]));
            if (result != -1)
                return answer;
            sb.deleteCharAt(sb.length() - 1);
        }

        return -1;
    }
}