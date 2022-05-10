package hw0505;
import java.io.*;
import java.util.*;

public class Main_11000_강의실배정 {
	
	static int N;
	static PriorityQueue<Node> pq;
	
	static class Node implements Comparable<Node>{
		int s,e;

		public Node(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Node o) {
			return this.s-o.s;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		pq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			pq.add(new Node(s,e));
		}
		
		PriorityQueue<Integer> room = new PriorityQueue<>();
		room.add(0);
		int roomCnt = 0;
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if (n.s>=room.peek()) {
				room.poll();
			}
			room.add(n.e);
			roomCnt = Math.max(roomCnt, room.size());
		}
		System.out.println(roomCnt);
	}
}
