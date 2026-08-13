package giseon.m08.programmers;

class 단어변환 {
    
    String begin;
    String target;
    String[] words;
    int answer;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        this.words = words;
        this.target = target;
        this.answer = words.length;
        this.visited = new boolean[words.length];
        // words 내에 target이 있다면 break
        boolean found = false;
        for (String w : words) {
            if (target.equals(w)) {
                found = true;
                break;
            }
        }
        // words내에 target이 없다면 return 0
        if (!found) {return 0;}
        
        // begin과 한글자만 다른 단어를 찾는다.
        // 찾았으면 dfs로 그 단어에서 words 내 한글자만 다른 단어가 있는지 찾는다.
        answer = dfs(begin, 0);
        return answer;
    }
    
    public int dfs(String w, int step) {
        // target과 같으면 현재 단계 수 반환
        if (w.equals(target)) {
            return step;
        }
        
        int min = words.length;
        
        // 한 글자만 다른 거를 count == 1인 경우를 찾는다.
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            if (!visited[i]) { // 방문하지 않았다면 한글자만 다른지 검사
                for (int j = 0; j < w.length(); j++) {
                    if (w.charAt(j) != words[i].charAt(j)) { // 다른 부분 count
                        count++;
                    }
                }
                // 만약 한 글자만 다르다면 방문 처리 및 다음 단계로
                if (count == 1) {
                    visited[i] = true;
                    int result = dfs(words[i], step+1);
                    min = Math.min(min, result);
                    visited[i] = false;
                }
            }
        }
        return min;
    }
}
