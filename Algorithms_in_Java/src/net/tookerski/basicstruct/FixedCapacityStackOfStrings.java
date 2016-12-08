package net.tookerski.basicstruct;

import java.util.Scanner;

public class FixedCapacityStackOfStrings<Item> {
	
	private Item[] a;// stack entries
	private int N; // size
	@SuppressWarnings("unchecked")
	public FixedCapacityStackOfStrings(int cap){
		a = (Item[]) new Object[cap];
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void push(Item item){
		if (N==a.length) resize(2*a.length);
		a[N++] = item;
	}
	public Item pop(){
		Item item = a[--N];
		a[N]=null;
		if (N>0 && N==a.length/4) resize(a.length/2);
		return item;
	}
	
	//实现动态数组
	//一个将栈移动到另一个大小为max的数组
	private void resize(int max){
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[max];
		for (int i=0;i<N;i++){
			temp[i] = a[i];
		}
		a = temp;
	}
	

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		FixedCapacityStackOfStrings<String> s = new FixedCapacityStackOfStrings<String>(100);
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
