package study0509;

import java.io.*;
import java.util.*;

public class Main_boj16234_인구이동 {
	
	static int N, L, R, map[][], answer;
	static int d[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean judge,v[][];
	
	static class Node{
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static boolean isRange(int r, int c) {
		return 0<=r && r<N && 0<=c && c<N;
	}
	
	static void bfs(int r, int c) {
		Queue<Node> union = new LinkedList<>();
		Queue<Node> bfsq=new LinkedList<>();
		
		bfsq.add(new Node(r,c));
		union.add(new Node(r,c));
		int sum=map[r][c];
		v[r][c]=true;
		
		while(!bfsq.isEmpty()) {
			Node n = bfsq.poll();
			
			for(int i=0;i<4;i++) {
				int nr = n.r+d[i][0];
				int nc = n.c+d[i][1];
				
				if(!isRange(nr,nc)) continue;
				if(v[nr][nc]) continue;
				int dif = Math.abs(map[n.r][n.c]-map[nr][nc]);
				if (L<=dif&&dif<=R) {
					Node now = new Node(nr,nc);
					union.add(now);
					bfsq.add(now);
					v[nr][nc]=true;
					sum+=map[nr][nc];
				}
			}
		} // bfs while
		
		if(union.size()>1) { // 연합이 존재한다면
			judge=true; // 하루가 지나야하는게 맞음
			
			int population = sum/union.size();
			while(!union.isEmpty()) {
				Node n = union.poll();
				map[n.r][n.c]=population;
			} // 연합 인구수 변경
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		} // input
		
		while(!judge) {
			v = new boolean[N][N]; // 하루의 시작은 방문 배열 초기화
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!v[i][j]) {
						bfs(i,j);
					}
				}
			} // bfs를 위해 for문 돌면서 연합국 찾기
			
			if(judge) {
				answer++;
				judge=false;
			}
			else break; // 하루가 지났으면 다음 날로 안지났으면  break
		}
		
		System.out.println(answer);
	}
}
