package hw0420;

import java.io.*;
import java.util.*;

public class Main_14888_연산자끼워넣기 {
	
	static int N, arr[], op[];
	static int maxans, minans, opCnt;
	
	static void dfs(int n, int nidx) {
		
		if(nidx==N) {
			maxans = Math.max(maxans, n);
			minans = Math.min(minans, n);
			return;
		}
		
		for(int i=0;i<4;i++) {
			if (op[i]==0) continue;
			
			op[i]--;
			
			if(i==0) dfs(n+arr[nidx],nidx+1);
			else if(i==1) dfs(n-arr[nidx],nidx+1);
			else if(i==2) dfs(n*arr[nidx],nidx+1);
			else dfs(n/arr[nidx],nidx+1);
			
			op[i]++;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr=new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		op = new int[4];
		opCnt=0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			op[i] = Integer.parseInt(st.nextToken());
			opCnt+=op[i];
		}
		
		maxans=Integer.MIN_VALUE;
		minans=Integer.MAX_VALUE;
		// input fin
		
		dfs(arr[0],1);
		System.out.println(maxans);
		System.out.println(minans);
	}
}
