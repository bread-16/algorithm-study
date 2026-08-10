package jinwoo.m08.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockPrice {
	 public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        
	        Deque<Integer> priceDeque = new ArrayDeque<>();
	        
	        for(int price : prices) {
	        	priceDeque.offerLast(price);
	        }
	        
	        int idx = 0;
	        
	        while(!priceDeque.isEmpty()) {
	        	int price = priceDeque.pollFirst();
	        	
	        	if(priceDeque.isEmpty())break;
	        	
	        	for(int i=idx + 1; i<prices.length; i++) {
	        		answer[idx]++;
	        		if(price > prices[i]) break;
	        	}
	        	idx++;
	        }
	        
	        return answer;
	    }
}
