package jinyoung.m07.swea;
import java.io.*;
import java.util.*;
public class D2_1204 {

	public static int score[];
    public static int result[];
    public static int T;
    public static int n;
     
    public static int findMaxIndex() {
        int maxValue=0;
        int maxIndex=0;
        for(int i=1;i<1001;i++)
        {
            if (maxValue<=result[i]) {
                maxValue=result[i];
                maxIndex=i;
            }
        }
        return maxIndex;
    }
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int idx=0;idx<T;idx++) {
            n=Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            score = new int[1000];
            result= new int[1001];
            for(int i=0;i<1000;i++) {
                score[i]=Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<1000;i++) {
                result[score[i]]++;
            }
            int res=findMaxIndex();
            sb.append("#").append(idx+1).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    }

}
