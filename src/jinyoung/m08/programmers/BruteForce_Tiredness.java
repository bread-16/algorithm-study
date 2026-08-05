package jinyoung.m08.programmers;

class Solution {
    public static boolean[] visited;
    public static int answer=0;
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        generate(k,dungeons,0);
        return answer;
    }      
    
    public void generate(int k, int[][] dungeons, int depth) {
        answer=Math.max(depth,answer);
        
        for(int i=0;i<dungeons.length;i++) {
            if(visited[i]==true) {
                continue;
            }
            if(dungeons[i][0]<=k) {
                visited[i]=true;
                generate(k-dungeons[i][1],dungeons,depth+1);
                visited[i]=false;
            }
        }
    }
}
