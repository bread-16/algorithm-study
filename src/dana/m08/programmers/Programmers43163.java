/*
- String is not index-able -> use .charAt(index)
- Length of a string -> .length()
- Length of an array -> .length 
*/

/*
내 질문들: 
- bfs 에서 어떻게 가장 짧은 경로를 찾는중인지..? -> 후보들을 동시에 한개씩 이동하며 타겟에 가장 먼저 이르는 것을 반환 
- bfs 사용하면서 단어 후보가 한개 이상일때 어떤걸 골라야 최단 거리일지 알 수 있는지? -> 후보가 여러개면 그걸 다 큐에 넣기 

- 타겟이 array에 있으면 항상 경로가 있는지? 
- 타겟이 array에 없으면 -> 리턴 0 

*/
package dana.m08.programmers;
import java.util.*; 

public class Programmers43163 {
	
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        // queue for bfs 
        Queue<String> queue = new ArrayDeque<>();
        // add begin word in queue 
        queue.offer(begin); 
        // visited array for bfs 
        boolean[] visited = new boolean[words.length]; 
                
        // if target doesn't exist in words, return 0 
        boolean found = false; 
        for (String w : words) {
            if (w.equals(target)) {
                found = true; 
                break; 
            }
        }
        if (found == false) return 0; 
        
        // bfs -> when queue empty, stop 
        while (!queue.isEmpty()) {       
            // 현재 레벨에 있는 단어수 (= 현재 큐에 있는 단어의 수) 만큼 반복 
            int size = queue.size(); 
            
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll(); 
                // 목표 단어에 도착했으면 리턴 
                if (target.equals(currWord)) {
                    return answer; 
                }
                // currWord 다음 올 수 있는 모든 단어 후보들을 검사 
                for (int w = 0; w < words.length; w++) {
                    if (visited[w]) {
                        continue; 
                    }
                    int diffCounter = 0; 
                    for (int j = 0; j < currWord.length(); j++) {
                        if (currWord.charAt(j) != words[w].charAt(j)) {
                            diffCounter++; 
                        }
                    }
                    if (diffCounter == 1) {
                        queue.offer(words[w]);
                        visited[w] = true; 
                    }
                }
            }
            // 한 단계 탐색이 끝났을때 1 증가하는거다. ***
            answer++; 
            

            
//             int diffCounter = 0; 
//             // for each currWord, go over words & count difference 
//             for (int w = 0; w < words.length; w++) {
                
//                 for (int i = 0; i < currWord.length(); i++) {
//                     if (currWord.charAt(i) != words[w].charAt(i)) {
//                         diffCounter++; 
//                     }
//                 }
//                 // if a next word is found, add to queue and increment answer 
//                 if (diffCounter == 1) {
//                     queue.offer(words[w]); 
//                     answer++; 
//                 }
//             }
        }
        return answer;
    }

}
