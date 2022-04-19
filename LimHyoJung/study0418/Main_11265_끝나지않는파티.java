package study0418;

import java.io.*;
import java.util.*;

public class Main_11265_끝나지않는파티 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		} // input map
		
		for(int t=1;t<=N;t++) {
			for(int s=1;s<=N;s++) {
				if(t==s) continue;
				for(int e=1;e<=N;e++) {
					if(t==e||s==e) continue;
					if(map[s][e]>map[s][t]+map[t][e])
						map[s][e]=map[s][t]+map[t][e];
				}
			}
		} // 플로이드와샬
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			if (map[s][e]<=t) sb.append("Enjoy other party").append("\n");
			else sb.append("Stay here").append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
