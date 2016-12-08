package net.tookerski.basicstruct;

import java.util.Scanner;

/**
 * 一个通过链表实现stack的demo
 * @author tookerski
 *
 */
public class Stack<Item> {
	private Node first;
	private int N;
	//通过内部类实现链表基本数据结构
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void push(Item item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public Item pop(){
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner("to be or not to - be - - that - - - is");
		while (sc.hasNext()){
			String item = sc.next();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty()){
				System.out.print(s.pop()+" ");
			}
		}
		System.out.println("("+s.size()+" left in stack)");
	}

}
