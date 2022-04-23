package hw0420;

import java.io.*;
import java.util.*;

public class Main_16198_에너지모으기 {

	static int N, marvel[], answer;
	static boolean v[];
	
	static void dfs(int energy, int cnt) {
		
		if (cnt==N-2) {
			answer = Math.max(answer, energy);
			return;
		}
		
		int front=0, back=0;
		for(int i=1;i<N-1;i++) { // 처음과 마지막은 안됨
			if(v[i]) continue; // 이미 제거한 구슬임.
			
			//제거 안한 구슬이라면
			v[i]=true; //x번째 제거하고
			for(int j=i+1;j<N;j++) {
				if(!v[j]) { back=j; break; }
			} // x+1 번째 찾아주고
			
			dfs(energy+(marvel[front]*marvel[back]),cnt+1);
			
			//되돌려주기
			v[i]=false;
			front=i;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		marvel = new int[N];
		v = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			marvel[i]=Integer.parseInt(st.nextToken());
		} // input
		
		answer = 0;
		dfs(0,0);
		System.out.println(answer);
	}
}