package study0509;

import java.io.*;
import java.util.*;

public class Main_boj15661_링크와스타트 {
	
	static int N, S[][], min_s;
	static boolean v[];
	
	static void cmb(int idx, int cnt, int r) {
		if(cnt==r) {
			int tsum=0,fsum=0;
			
			int[] tlist = new int[r];
			int[] flist = new int[N-r];
			
			int tidx=0, fidx=0;
			for(int i=0;i<N;i++) {
				if(v[i]) tlist[tidx++]=i;
				else flist[fidx++]=i;
			}
			
			for(int i=0;i<tidx;i++) {
				for(int j=i+1;j<tidx;j++) {
					tsum+=S[tlist[i]][tlist[j]];
					tsum+=S[tlist[j]][tlist[i]];
				}
			}
			
			for(int i=0;i<fidx;i++) {
				for(int j=i+1;j<fidx;j++) {
					fsum+=S[flist[i]][flist[j]];
					fsum+=S[flist[j]][flist[i]];
				}
			}
			
			int nowans=Math.abs(tsum-fsum);
			min_s = Math.min(min_s, nowans);
			return;
		}
		
		for(int i=idx;i<N;i++) {
			v[i]=true;
			cmb(i+1,cnt+1,r);
			v[i]=false;
		}
	}

	public static void main(String[] args) throws IOException { //능력치의 차이를 최소로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		S=new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				S[i][j]=Integer.parseInt(st.nextToken());
			}
		} // input
		
		min_s = Integer.MAX_VALUE;
		v = new boolean[N];
		for(int i=1;i<=N/2;i++) {
			cmb(0,0,i);
		} // 조합으로 팀 구하기
		
		System.out.println(min_s);
	}
}
