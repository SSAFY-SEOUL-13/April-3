package d0417.n16953;

import java.io.*;
import java.util.*;

public class Main {
	
	static long B, answer;
	
	static void dfs(long n, int dpt) {
		
		if(dpt>answer || n > B) return;
		if(n==B) {
			answer = Math.min(answer, dpt);
			return;
		}
		
		dfs(n*2,dpt+1);
		dfs(n*10+1,dpt+1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		answer=Integer.MAX_VALUE;
		dfs(A,1);
		
		System.out.println(answer==Integer.MAX_VALUE? -1:answer);
	}
}