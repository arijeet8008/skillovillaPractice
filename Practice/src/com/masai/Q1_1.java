package com.masai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Q1_1 {

	public static void main(String[] args) {
		
//		int[] arr = {4, 2, 8, 1, 3, 6, 100, 9};
		int[] arr = {6, 7, 3, 1, 100, 102, 6, 12};
		lCS(arr);
	}
	
	public static void lCS(int[] arr) {
		
		HashSet<Integer> s =new HashSet<>();
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			s.add(arr[i]);
		}
		System.out.println(s);
		
		for (int i = 0; i < arr.length; i++) {
			if(!s.contains(arr[i]- 1)) {
				int x = arr[i];
				while(s.contains(x)) {
					s.remove(Integer.valueOf(x));
					x++;
				}
				if(ans < (x-arr[i])) {
					ans = (x-arr[i]);
				}
			}
		}
		System.out.println(ans);
	}

}
