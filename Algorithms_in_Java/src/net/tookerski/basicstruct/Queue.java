package net.tookerski.basicstruct;

import java.util.Scanner;

/**
 * 通过链表实现先进先出队列
 * @author apollo
 *
 * @param <Item>
 */
public class Queue<Item> {
	private Node first;//最早添加node的引用
	private Node last;//最末添加node的引用
	private int N;//队列中元素数量
	//通过内部类定义节点
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
	public void enqueue(Item item){
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty())
			first = last;
		else
			oldlast.next = last;
		N++;
	}
	public Item dequeue(){
		Item item = first.item;
		first = first.next;
		if (isEmpty())
			last = null;
		N--;
		return item;
	}

	public static void main(String[] args) {
		Queue<String> q = new Queue<String>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner("to be or not to - be - - that - - - is");
		while (sc.hasNext()){
			String item = sc.next();
			if (!item.equals("-"))
				q.enqueue(item);
			else if (!q.isEmpty()){
				System.out.print(q.dequeue()+" ");
			}
		}
		System.out.println("("+q.size()+" left in stack)");
	}

}
