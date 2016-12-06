package net.tookerski.basicstruct;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestBag {

	public static void main(String[] args) {
		Bag<Double> bag = new Bag<Double>();
		while (!StdIn.isEmpty())
			bag.add(StdIn.readDouble());
		int N = bag.size();
		double sum = 0.0;
		for (double x:bag)
			sum += x;
		double mean = sum/N;
		StdOut.println("Mean: "+mean);
	}

}
