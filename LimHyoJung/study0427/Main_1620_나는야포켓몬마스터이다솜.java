package study0427;

import java.io.*;
import java.util.*;

public class Main_1620_나는야포켓몬마스터이다솜 {
	
	static int N; // 포켓몬 수  1-100_000
	static int M; // 맞춰야 하는 문제 수. 1-100_000
	static String[] pkmOrder;
	static HashMap<String, Integer> hm = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		
		pkmOrder = new String[N+1];
		for(int i=1;i<=N;i++) {
			pkmOrder[i]=br.readLine();
			hm.put(pkmOrder[i], i);
		} // input

		for(int i=0;i<M;i++) {
			String str = br.readLine();
			if('0'<=str.charAt(0) && str.charAt(0)<='9') {
				int idx = Integer.parseInt(str);
				sb.append(pkmOrder[idx]).append('\n');
			}
			else {
				sb.append(hm.get(str)).append('\n');
			}
		} // findAnswer for
		
		System.out.println(sb.toString());
	}
}
