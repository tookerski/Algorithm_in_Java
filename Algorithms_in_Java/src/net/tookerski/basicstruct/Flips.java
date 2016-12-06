package net.tookerski.basicstruct;

/**
 *  The {@code Flips} class provides a model for counting coin`s head and tail
 *  and compare them.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/11model">Section 1.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author tookerski
 */

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Flips {
	
	public static Counter max(Counter c1, Counter c2){
		if (c1.tally() > c2.tally())
			return c1;
		else
			return c2;
	}
	/**
     * Reads in a integer of count times.
     * out through standard output.
     *
     * @param T the count times
     */
	public static void main(String[] args) {
		//Scanner in = new Scanner(System.in);
		int T = 1000000; 
		Counter heads = new Counter("heads");
		Counter tails = new Counter("tails");
		//counting times.
		for (int i=0;i<T;i++){
			if (StdRandom.bernoulli(0.5)){
				heads.increment();
			}else{
				tails.increment();
			}
		}
		//print out the larger one.
		if (heads.tally()==tails.tally()){
			StdOut.println("Tie");
		}else{
			StdOut.println(max(heads,tails) + " win");
		}
	}

}
