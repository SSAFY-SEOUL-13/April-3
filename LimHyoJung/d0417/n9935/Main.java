package d0417.n9935;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String bomb = br.readLine(); // 폭발 문자열
		
		char lastCh = bomb.charAt(bomb.length()-1); //폭발 문자열 마지막 글자
		
		for(int i=0;i<str.length();i++) {
			char nowCh = str.charAt(i);
			sb.append(nowCh);
			
			boolean judge = false; // 폭발 문자열 확인 변수
			int sblen = sb.length();
			int blen = bomb.length();
			
			if(nowCh==lastCh && sblen>=blen) { // 폭발 문자열의 끝 글자와 현재 글자가 같음
				int idx = sblen-blen;
				
				for(int j=0;j<blen;j++) {
					int nowidx = idx+j;
					if(bomb.charAt(j)!=sb.charAt(nowidx)) break;
					if(j==blen-1) judge=true;// 폭발문자열 존재
				}
				
				if(judge) sb.delete(idx, sblen); // 폭발문자열 제거
			}
		}
		
		// 남아있는 문자 없으면 return FRULA
		if(sb.length()==0) System.out.println("FRULA");
		else System.out.println(sb.toString());
	}
}
