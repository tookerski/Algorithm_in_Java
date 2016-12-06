package net.tookerski.basicstruct;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class TestQueue {

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		for (int i=0;i<100;i++)
			q.enqueue(i);
		int N = q.size();
		int[] a = new int[N];
		for (int i=0;i<100;i++){
			a[i] = q.dequeue();
			StdOut.println(a[i]);
		}
	}

}
