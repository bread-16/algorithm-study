package jinwoo.m08.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class TravelRoute {
	
	String[][] tickets;
    String[] answer;
    boolean[] visited;
     public String[] solution(String[][] tickets) {
         this.tickets = tickets;
         visited = new boolean[tickets.length];
         List<String> cities = new ArrayList<>();
         cities.add("ICN");
         dfs(0, cities);

        return answer;
    }

     public void dfs(int depth, List<String> cities) {
         //if(depth >= tickets.length) return;
         if(depth == tickets.length) {
             if(answer == null) {
                 answer = new String[cities.size()];
                 for(int i=0; i<cities.size(); i++) {
                     answer[i] = cities.get(i);
                 }
             } else {
                 for(int i=0; i<cities.size(); i++) {
                     if(answer[i].equals(cities.get(i))) continue;
                     if(answer[i].compareTo(cities.get(i)) > 0) {
                         for(int j=0; j<cities.size(); j++) {
                             answer[j] = cities.get(j);
                         }
                         break;
                     } else {
                         break;
                     }
                 } 
             }
             return;
         }
         for(int i=0; i<tickets.length; i++) {
             if(visited[i]) continue;

             visited[i] = true;

             List<String> beforeCities = new ArrayList<>();
             beforeCities.addAll(cities);
             if(tickets[i][0].equals(cities.getLast())) {
                 cities.add(tickets[i][1]);
                 dfs(depth+1, cities);
             }

             cities.clear();
             cities.addAll(beforeCities);
             visited[i] = false;
         }
     }
}
