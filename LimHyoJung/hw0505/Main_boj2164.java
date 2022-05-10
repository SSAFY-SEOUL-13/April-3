package hw0505;

import java.util.*;
import java.io.*;

public class Main_boj2164 {

	static int N;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		q = new LinkedList<>();
		for(int i=1;i<=N;i++)
			q.add(i);
		
		while(q.size()!=1) {
			q.poll();
			q.add(q.poll());
		}
		
		System.out.println(q.poll());
	}
}
