package jinyoung.m08.programmers;

import java.util.Arrays;

public class BruteForce_Carpet {
	public static void main(String[] args) {
		int brown = 95;
		int yellow = 2;
		int sum = brown + yellow;

		int width = 0;
		int height = 0;

		for (int i = 1; i <= Math.sqrt(sum); i++) {
			if (sum % i == 0) {
				height = i;
				width = sum / height;
			}
			if((width*2)+(height-2)*2==brown) {
				break;
			}
		}
		
		if (width < height) {
			int temp = width;
			width = height;
			height = temp;
		}
		
		int[] answer = new int[2];
		answer[0] = width;
		answer[1] = height;
		System.out.println(Arrays.toString(answer));
	}
}
