package com.masai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Q1 {

	public static void main(String[] args) {
		
//		int[] arr = {4, 2, 8, 1, 3, 6, 100, 9};
		int[] arr = {6, 7, 3, 1, 100, 102, 6, 12};
		lCS(arr);
	}
	
	public static void lCS(int[] arr) {
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int last = arr[0],size = 0,max=1;
		Stack<Integer> s = new Stack<>();
//		s.add(last);
		int n = arr.length;
		for(int i=1;i<n;i++) {
			if(last+1 == arr[i]) {
				
				size++;
			}
			else if(last == arr[i]) {
				continue;
			}
			else {
				max = Math.max(max, size+1);
				size = 0;
				
			}
			last = arr[i];
		}

		System.out.println(Math.max(max, size+1) +" "+ s);
	}

}
