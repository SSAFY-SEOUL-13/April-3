package d0419.n11509;

import java.io.*;
import java.util.*;

public class Main {

	static int N, arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} //input
		
		int arrow[] = new int[1_000_001];
		int answer=0;
		for(int i=0;i<N;i++) {
			int nowh = arr[i];
			if(arrow[nowh]==0) answer++;
			else arrow[nowh]--;
			arrow[nowh-1]++;
		}
		
		System.out.println(answer);
	}
}
