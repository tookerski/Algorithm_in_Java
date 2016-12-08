package net.tookerski.basicstruct;

import java.util.Iterator;
import java.util.Scanner;

/**
 * ͨ������ʵ��bag���ݽṹ������ʵ��iterable�ӿ�
 * @author apollo
 *
 */
public class Bag<Item> implements Iterable<Item> {

	private Node first;
	private int N;
	//ͨ���ڲ���ʵ������������ݽṹ
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
	public void add(Item item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner("a b c d e f g h");
		Bag<String> bags = new Bag<String>();
		while(sc.hasNext()){
			bags.add(sc.next());
		}
		for (String bag:bags){
			System.out.println(bag);
		}
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{

		private Node current = first;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
		public void remove(){}
		
	}


}
