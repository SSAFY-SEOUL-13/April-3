package study0418;

import java.io.*;
import java.util.*;

public class Main_12015_가장긴증가하는부분수열2 {
	
	static int N, arr[], dp[];
	
	static int binarySearch(int l, int r, int n) {
		int mid=0;
		while(l<r) {
			mid = (l+r)/2;
			if(dp[mid]>=n) r=mid;
			else l=mid+1;
		}
		return r;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int len=0;
		for(int i=0;i<N;i++) {
			if(len==0 || (len!=0 && dp[len-1]<arr[i])) {
				dp[len++]=arr[i];
				continue;
			}
			
			int idx = binarySearch(0, len-1, arr[i]);
			dp[idx] = arr[i];
		}
		
		for(int i=0;i<len;i++) {
			sb.append(dp[i]);
			if(i!=len-1) sb.append(" ");
		}
		
		System.out.println(len);
		System.out.println(sb.toString());
	}
}
