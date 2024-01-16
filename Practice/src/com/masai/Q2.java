package com.masai;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] str = new String[2];
		for (int i = 0; i < str.length; i++) {
			str[i] = sc.next();
		}
		System.out.println(diff(str));
	}
	
	public static int diff(String[] str) {
		
		String str1 = str[0];
		String str2 = str[1];
		int count = 0;
		
		if(str1.length() != str2.length())
			return count;
		
		for (int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i) != str2.charAt(i)) count++;
		}
		return count;
	}

}
