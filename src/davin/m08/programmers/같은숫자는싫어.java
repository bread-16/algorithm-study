package davin.m08.programmers;
import java.util.*;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        int n = arr.length;
        
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        
        for(int i=1; i<n; i++){
            if(arr[i]==arr[i-1]) continue;
            list.add(arr[i]);
        }
        
        return list.stream().mapToInt(x-> x).toArray();
    }
}
