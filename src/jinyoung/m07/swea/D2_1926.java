package jinyoung.m07.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D2_1926 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int cnt=0;
		int k=0;
		for(int i=1;i<=n;i++) {
			cnt=0;
			k=i;
			while(k>=1) {
				if((k%10)%3==0 && k%10!=0) {
					cnt++;
				}
				k/=10;
			}
			switch(cnt) {
			case 0:
				sb.append(i);
				break;
			case 1:
				sb.append("-");
				break;
			case 2:
				sb.append("--");
				break;
			case 3:
				sb.append("---");
				break;
			}
			sb.append(" ");
		}
		System.out.println(sb);
	}

}
