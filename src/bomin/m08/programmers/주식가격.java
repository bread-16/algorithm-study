package bomin.m08.programmers;

import java.util.*;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = {};
        
        answer = new int[prices.length];
        //스택에 시간과 같이 넣음 -> 스택 제일 위보다 숫자가 낮아지면 꺼냄 -> 몇초인지 계산.
        //배열 마지막이면 멈추고, 스택 전체를 꺼내 전부 몇 초인지 계산.
        Stack<int[]> stock = new Stack<>();
        int sec = 1;
        int[] st = new int[3];
        //순서 -> 1초 지날 때 마다 스택 제일 윗 값과 다음 price값 비교 -> 크면  pop 하면서 시간초 계산.
        //while로 스택이 비거나, 스택 제일 윗 값이 다음  price보다 작거나 같으면 stop.
        //배열이 끝으로 가면 스택 전부 꺼내서 시간 계산.
        //시간초를 index순으로 어떻게 배열에 넣지?
        //넣을때 사용하는 prices[i]값대로 return[i] 인덱스에 넣기?
        //인덱스 그냥 따로 하나 더 저장
        
        for(int i=0;i<prices.length;i++){
            while(!stock.isEmpty() && stock.peek()[0]>prices[i]){
                st = stock.pop();
                answer[st[2]] = sec-st[1];
            }
            stock.push(new int[]{prices[i],sec,i});
            sec++;
        }
        //마지막 for문끝나고 나머지 스택 전부 꺼내서 시간 계산 -> 마지막 sec를 빼야하기때문에
        sec--;
        
        while(!stock.isEmpty()){
            st = stock.pop();
            answer[st[2]] = sec-st[1];
        }
        
   
        return answer;
    }
}
