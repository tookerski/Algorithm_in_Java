package net.tookerski.basicstruct;

import java.util.Scanner;

public class FixedCapacityStackOfStrings {
	
	private String[] a;// stack entries
	private int N; // size
	public FixedCapacityStackOfStrings(int cap){
		a = new String[cap];
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void push(String s){
		a[N++] = s;
	}
	public String pop(){
		return a[--N];
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()){
			String item = scan.next();
			if (!item.equals("-")){
				s.push(item);
			}else if(!s.isEmpty()){
				System.out.println(s.pop()+" ");
			}
		}
		System.out.println("("+s.size()+"left on stack )");
	}

}
