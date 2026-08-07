package giseon.m08.programmers;

class 모음찾기 {
    
    static final char[] alphabets = {'A', 'E', 'I', 'O', 'U'};
    static int count = 0;
    static boolean pause;
    static String word;
    
    public int solution(String word) {
        this.word = word;
        
        dfs(new StringBuilder());
        
        return count;
    }
    
    public void dfs(StringBuilder vowels) {
        if (word.contentEquals(vowels)) {
            pause = true;
            return;
        }
        
        if (vowels.length() == 5) {
            return;
        }
        
        
        for (int i = 0; i < alphabets.length; i++) {
            if (!pause) {
                count++;
                dfs(vowels.append(alphabets[i]));   
                vowels.deleteCharAt(vowels.length() - 1);
            }
        }
        
        
    }
}
