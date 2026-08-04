package dana.m08.programmers;

public class Programmers86491 {
    public int solution(int[][] sizes) {
        /*
        
        가로: sizes[i][0], sizes[i][1] 끼리 비교해서 가장 큰 수 찾기 -> 이 중에서 가장 큰 수 찾기 
        세로: sizes[i][0], sizes[i][1] 끼리 비교해서 가장 작은 수 찾기 -> 이 중에서 가장 큰 수 찾기 
        
        */
        int size = sizes.length;
        int[] widthCandidates = new int[size];
        int[] heightCandidates = new int[size];
        int width = 0;
        int height = 0;
        for (int i = 0; i < size; i++) {
            widthCandidates[i] = Math.max(sizes[i][0], sizes[i][1]);
            heightCandidates[i] = Math.min(sizes[i][0], sizes[i][1]);
        }
        
        
        for (int i = 0; i < size; i++) {
            if (widthCandidates[i] > width) width = widthCandidates[i];
            if (heightCandidates[i] > height) height = heightCandidates[i];
        }
        
        int answer = width * height;
        return answer;
    }
}


