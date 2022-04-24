package hw0420;

import java.io.*;
import java.util.*;

public class Main_1197_최소스패닝트리 {

	static int V, E;
	static long answer;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static int root[];
	
	static class Node implements Comparable<Node>{
		int a, b, w;

		public Node(int a, int b, int w) {
			super();
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
	}
	
	static void makeUnion() {
		for(int i=1;i<=V;i++) {
			root[i]=i;
		}
	}
	
	static int findUnion(int n) {
		if (root[n]==n) return n;

		root[n]=findUnion(root[n]);
		return root[n];
	}
	
	static void changeUnion(int x, int y) {
		x = findUnion(x);
		y = findUnion(y);
		
		if(x!=y) root[x]=y; // 집합 합치기
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		root = new int[V+1];
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(a,b,w));
		} //input
		
		makeUnion();
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int a = findUnion(n.a);
			int b = findUnion(n.b);
			
			if(a==b) continue; // cycle
			else {
				answer+=n.w;
				changeUnion(a, b);
			}
		}
		
		System.out.println(answer);
	}
}