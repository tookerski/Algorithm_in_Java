package net.tookerski.basicstruct;

import java.util.Scanner;

/**
 * ͨ������ʵ���Ƚ��ȳ�����
 * @author apollo
 *
 * @param <Item>
 */
public class Queue<Item> {
	private Node first;//�������node������
	private Node last;//��ĩ���node������
	private int N;//������Ԫ������
	//ͨ���ڲ��ඨ��ڵ�
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
