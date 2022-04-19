package study0418;

import java.io.*;
import java.util.*;

public class Main_2502_떡먹는호랑이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int day[][]=new int[D+1][2]; //a b
		day[1][0]=1; day[1][1]=0;
		day[2][0]=0; day[2][1]=1;
		
		for(int i=3;i<=D;i++) {
			day[i][0] = day[i-2][0]+day[i-1][0];
			day[i][1] = day[i-2][1]+day[i-1][1];
		}
		
		int a = day[D][0], b = day[D][1]; // -> ax+by=K
		int x=1, y=1;
		while(true) {
			if((K-a*x)%b==0) { //K-ax가 b의 배수인 경우
				y = (K-a*x)/day[D][1];
				break;				
			}
			x++;
		}
		System.out.println(x);
		System.out.println(y);
	}
}
