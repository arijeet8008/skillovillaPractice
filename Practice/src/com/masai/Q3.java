package com.masai;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(balancedBracket(str));
	}
	
	public static int balancedBracket(String str) {

		Stack<Character> s = new Stack<>();
		for(int i=0;i<str.length();i++) {
			if(s.isEmpty())
				s.push(str.charAt(i));
			else if(s.peek() == '(' && str.charAt(i) == ')') {
				s.pop();
			}
			else {
				s.push(str.charAt(i));
			}
		}
		
		if(s.isEmpty()) return 1;
		
		return 0;

	}

}
