package net.tookerski.basicstruct;

import edu.princeton.cs.algs4.Stack;

public class TestStack {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < 100; i++)
			s.push(i);
		int N = s.size();
		int[] a = new int[N];
		for (int i=0;i<100;i++){
			a[i] = s.pop();
			System.out.println(a[i]);
		}
	}

}
