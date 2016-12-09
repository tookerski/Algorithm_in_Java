package net.tookerski.basicstruct;

import java.util.Scanner;

/**
 * 模拟网络连通模型的算法
 * @author tookerski
 *
 */
public class UnionFind {
	private int[] id;//分量id，以触点作为索引
	private int count;//分量数量
	
	public UnionFind(int N){
		count = N;
		id = new int[N];
		for (int i = 0;i < N;i++){
			id[i] = i;
		}
	}
	
	public int count(){
		return count;
	}
	public boolean connected(int p,int q){
		return find(p) == find(q);
	}
	
	public int find(int p){
		//pending
		return 0;
	}
	public void union(int p, int q){
		//pending
	}

	public static void main(String[] args) {
		int N = 100;
		UnionFind uf = new UnionFind(N);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner("");
		while (sc.hasNext()){
			int p = sc.nextInt();
			int q = sc.nextInt();
			if (uf.connected(p, q)) continue;
			System.out.println( p + " " + q );
		}
		System.out.println(uf.count + " components");
	}

}
