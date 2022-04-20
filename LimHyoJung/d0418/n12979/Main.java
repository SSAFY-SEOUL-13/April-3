package d0418.n12979;

import java.io.*;
import java.util.*;

public class Main {
	
	static int W, H, A, answer;
	
	static int Origami(int now, int goal) {
		
		if(now==goal) return 0;
		
		int cnt=-1;		
		while(now>goal) {
			if(now>goal*2) { //반 접을 수 있는가
				cnt = cnt<0? cnt+2: cnt+1;
				if(now%2==0) now/=2;
				else now=(now/2)+1;
			}
			else { //반 접을 수 없음
				cnt = cnt<0? cnt+2: cnt+1;
				break; //도착
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		
		// A가 될 수 있는 쌍 찾기
		Queue<int[]> q = new LinkedList<>();
		for(int i=1;i<=Math.sqrt(A);i++) {
			if(i>W || i>H || A%i!=0) continue;
			int j=A/i;
			if(j>W && j>H) continue;
			q.add(new int[] {i,j});
		}
		
		// 돌면서 가능한지 확인
		answer = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			int[] n = q.poll();
			
			int a = Origami(H,n[0]);
			int b = Origami(W,n[1]);
			if(a>=0 && b>=0) answer=Math.min(answer, a+b);
			
			a = Origami(H,n[1]);
			b = Origami(W,n[0]);
			if(a>=0 && b>=0) answer=Math.min(answer, a+b);
		}
		
		System.out.println(answer==Integer.MAX_VALUE? -1: answer);
	}
}
