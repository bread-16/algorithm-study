package dana.m08.programmers;

import java.util.*;

public class Programmers42586 {
	
    public int[] solution(int[] progresses, int[] speeds) {
        // queue 생성 
        // ArrayDeque는 방향이 모든 가능 
        Queue<Integer> queue = new ArrayDeque<>();
        // 정답은 몇개인지 모르니 -> 정답 list 생성 
        List<Integer> resultList = new ArrayList<>(); 
        // 몇일 후 배포날인지 계산해서 queue에 넣기 
        int[] daysLater = new int[progresses.length];
        for (int p = 0; p < progresses.length; p++) {            
            int dayWork = (int) Math.ceil( ((double) 100 - progresses[p]) / speeds[p]);
            // queue에 추가할때 offer 사용하기 
            queue.offer(dayWork); 
        }
        // queue에서 하나씩 빼가며 -> 개수 계산하기 -> 만약 전보다 큰게 나오면 stop counting and add to 정답 array 
        // queue는 순서가 없음 -> indexing 불가 -> while loop 사용 
        
        // 첫번째 기능을 기준으로 잡기: 
        int maxDay = queue.poll();
        int count = 1; 
        while(!queue.isEmpty()) {
            int currDays = queue.poll(); 
            
            if (currDays <= maxDay) {
                count++; 
            }
            else {
                resultList.add(count);
                maxDay = currDays;
                count = 1; 
            }
        }
        
        // 마지막에 남아있는 기능들의 개수 추가 
        resultList.add(count);
        // change list to array 
        // to get length of list -> list.size()
        int[] resultArr = new int[resultList.size()];
        int index = 0;
        for (int i = 0; i < resultList.size(); i++) {
            // list의 아이템 가져오려면 -> list.get(index)
            resultArr[index] = resultList.get(i);
            index++;
        }
        
        // return answer 
        return resultArr; 
    }

}
