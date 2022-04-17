package study0413;

import java.io.*;
import java.util.*;

public class Main_18111_마인크래프트 {

	static int N, M, B, map[][], answerTime, answerHeight;
	static int minHeight = 256, maxHeight = 0;
	
	static void makeFlat(int height) {
		int time=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]>height) {
					time+=(map[i][j]-height)*2;
				}
				else if(map[i][j]<height) {
					time+=(height-map[i][j]);
				}
			}
		}
		
		if(answerTime>time) {
			answerTime = time;
			answerHeight = height;
		}
		else if(answerTime==time && answerHeight<height)
			answerHeight = height;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		answerTime=Integer.MAX_VALUE;
		int totalGround = B;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				totalGround+=map[i][j];
				minHeight = Math.min(minHeight, map[i][j]);
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}// input
		if(totalGround<maxHeight*(N*M)) 
			maxHeight = totalGround/(N*M);
		
		for(int i=minHeight;i<=maxHeight;i++) {
			makeFlat(i);
		}
		System.out.println(answerTime+" "+answerHeight);
	}
}
