package net.tookerski.basicstruct;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Dijkstra双栈算术表达式求值
 * @author tookerski
 *
 */
public class Evaluate {

	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		String string = "( 1 + ( 2 + 3 ) * ( 4 * 5 ) )";
//		String[] a = string.split("");
//		for (int i=0;i<a.length;i++)
//			System.out.println(a[i]);
		for (String s:string.split(" ")){
			if (s.equals("("));
			else if (s.equals("+")) ops.push(s);
			else if (s.equals("-")) ops.push(s);
			else if (s.equals("*")) ops.push(s);
			else if (s.equals("/")) ops.push(s);
			else if (s.equals("sqrt")) ops.push(s);
			else if (s.equals(")")){
				String op = ops.pop();
				double v = vals.pop();
				if (s.equals("+")) v = vals.pop()+v;
				else if (op.equals("-")) v = vals.pop()+v;
				else if (op.equals("*")) v = vals.pop()+v;
				else if (op.equals("/")) v = vals.pop()+v;
				else if (op.equals("sqrt")) v = Math.sqrt(v);
				vals.push(v);
			}
			else vals.push(Double.parseDouble(s));
		}
		StdOut.println(vals.pop());
	}

}
