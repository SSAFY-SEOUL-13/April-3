package hw0505;

import java.io.*;
import java.util.*;

public class Main_boj1202 {

	static int N, K, bag[];
	
	static class Jewelry implements Comparable<Jewelry>{
		int w, cost;

		public Jewelry(int w, int cost) {
			super();
			this.w = w;
			this.cost = cost;
		}

		@Override
		public int compareTo(Jewelry o) {
			return this.w-o.w;
		} // 무게로 오름차순 정리
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Jewelry jew[] = new Jewelry[N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int w=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			jew[i]=new Jewelry(w, c);
		}
		Arrays.sort(jew);
		
		bag = new int[K];
		for(int i=0;i<K;i++) {
			bag[i]=Integer.parseInt(br.readLine());
		} // input : 가방에는 최대 1개의 보석만 넣을 수 있다.
		Arrays.sort(bag); // 무게 순 오름차순
		
		Queue<Integer> pq = new PriorityQueue<>(); // 담을 수 있는 무게들을 담을 우선순위 큐
		long sum=0;
		int jewIdx=0;
		for(int k=0;k<K;k++) {
			while(jewIdx<N && jew[jewIdx].w<=bag[k]) {
				pq.add((-1)*jew[jewIdx].cost); // 내림차순 효과
				jewIdx++;
			}// 해당 가방에 담을 수 있는 보석들 pq에 넣기
			
			if(!pq.isEmpty()) 
				sum+=Math.abs(pq.poll());
		}
		
		System.out.println(sum);
	}
}
