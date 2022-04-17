package study0413;

import java.io.*;
import java.util.*;

public class Main_11404_플로이드 {

	static int N, M, map[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); 
		M = Integer.parseInt(br.readLine()); 
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==j) map[i][j]=0;
				else map[i][j] = 100_000_000;
			}
		}
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			if(map[a][b]>w) map[a][b]=w;
		} // input
		
		for(int t=0;t<N;t++) {
			for(int s=0;s<N;s++) {
				if(s==t) continue;
				for(int e=0;e<N;e++) {
					if(t==e||s==e) continue;
					if(map[s][e]>map[s][t]+map[t][e]) {
						map[s][e]=map[s][t]+map[t][e];
					}
				}
			}
		} //플로이드워셜
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==100_000_000) map[i][j]=0; // 갈 수 없는 곳
				sb.append(map[i][j]).append(" ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
}
