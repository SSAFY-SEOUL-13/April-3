package study0509;

import java.io.*;
import java.util.*;

public class Main_boj11403_경로찾기 {

	static int N, map[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		} // input
		
		for(int t = 0; t<N;t++) {
			for(int s=0;s<N;s++) {
				for(int e=0;e<N;e++) {
					if(map[s][t]==1 && map[t][e]==1) map[s][e]=1;
				}
			}
		} // 플로이드 와샬
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
