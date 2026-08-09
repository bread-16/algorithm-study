package dana.m08.programmers;

/*

dfs 사용해서 가능한 단어를 한개씩 만듦. 
만들때마다 카운터를 +1씩 더한다. 

이 과정에서 매개변수로 주어진 단어를 찾으면 dfs를 그만두고 
카운터를 리턴한다. 

*/

public class Programmers86971 {
    String word; 
    int counter = 0;
    char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    boolean found = false; 

    void dfs(StringBuilder currWord) {
        if (currWord.length() > 0) {
            counter++; 
            
            if (currWord.toString().equals(word)) {
                found = true;
                return; 
            }
        }
        if (currWord.length() == 5) {
            return;
        }
        for (char c : vowels) {
            
            if (found) {
                break;
            }
            
            currWord.append(c);
            dfs(currWord);
            currWord.deleteCharAt(currWord.length() - 1);
        }
        
    }
    public int solution(String word) {
        
        this.word = word; 
        
        dfs(new StringBuilder());
        
        return counter;
    }

}
