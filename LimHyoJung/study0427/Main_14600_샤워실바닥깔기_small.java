package study0427;

import java.io.*;
import java.util.*;

public class Main_14600_샤워실바닥깔기_small {

	static int K, N, hr, hc;
	static int map[][];
	static boolean judge;
	
	static boolean isRange(int r, int c) {
		return 0<=r && r<N && 0<=c && c<N;
	}
	
	static void makeMap(int r1, int c1, int r2, int c2, int r3, int c3, int cnt) {
		map[r1][c1]=cnt;
		map[r2][c2]=cnt;
		map[r3][c3]=cnt++;
		
		if ((K==1 && cnt==2)||(K==2&&cnt==6)) {
			judge=true;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++)
					System.out.print(map[i][j]+" ");
				System.out.println();
			}
			
			return;
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(judge) break;
				if(map[i][j]!=0) continue; // 간 적 없는 위치만
				dfs(i,j,cnt);
			}
		}
		
		map[r1][c1]=0;
		map[r2][c2]=0;
		map[r3][c3]=0;
	}
	
	static void dfs(int r, int c, int cnt) {
		if(judge) return;
		
		if(isRange(r-1,c-1) && isRange(r-1,c) && map[r-1][c-1]==0 && map[r-1][c]==0)
			makeMap(r-1,c-1,r-1,c,r,c,cnt);
		if(isRange(r-1,c-1) && isRange(r,c-1) && map[r-1][c-1]==0 && map[r][c-1]==0)
			makeMap(r-1,c-1,r,c-1,r,c,cnt);
		if(isRange(r-1,c+1) && isRange(r-1,c) && map[r-1][c+1]==0 && map[r-1][c]==0)
			makeMap(r-1,c+1,r-1,c,r,c,cnt);
		if(isRange(r-1,c+1) && isRange(r,c+1) && map[r-1][c+1]==0 && map[r][c+1]==0)
			makeMap(r-1,c+1,r,c+1,r,c,cnt);
		if(isRange(r+1,c-1) && isRange(r+1,c) && map[r+1][c-1]==0 && map[r+1][c]==0)
			makeMap(r+1,c-1,r+1,c,r,c,cnt);
		if(isRange(r+1,c-1) && isRange(r,c-1) && map[r+1][c-1]==0 && map[r][c-1]==0)
			makeMap(r+1,c-1,r,c-1,r,c,cnt);
		if(isRange(r+1,c) && isRange(r+1,c+1) && map[r+1][c+1]==0 && map[r+1][c]==0)
			makeMap(r+1,c,r+1,c+1,r,c,cnt);
		if(isRange(r,c+1) && isRange(r+1,c+1) && map[r+1][c+1]==0 && map[r][c+1]==0)
			makeMap(r,c+1,r+1,c+1,r,c,cnt);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		N = (K==1)? 2: 4; // K는 1 or 2
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tmpx = Integer.parseInt(st.nextToken());
		int tmpy = Integer.parseInt(st.nextToken()); //input
		
		map = new int[N][N];
		hr = N-tmpy;
		hc = tmpx-1;
		map[hr][hc]=-1;
		
		int cnt=1;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(judge) break;
				if(map[i][j]!=0) continue; // 간 적 없는 위치만
				dfs(i,j,cnt);
			}
		}
		
	}// main
}
