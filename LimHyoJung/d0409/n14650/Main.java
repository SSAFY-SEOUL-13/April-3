package d0409.n14650;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, answer;
	
	static void dfs(int n, int sum, int dpt) {
		if(dpt==N) {
			if(sum%3==0) answer++;
			return;
		}
		
		for(int i=0;i<3;i++) {
			dfs(i,sum+i,dpt+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dfs(1,1,1);
		dfs(2,2,1);
		
		System.out.println(answer);
	}
}
