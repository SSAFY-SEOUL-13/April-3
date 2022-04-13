import java.util.Scanner;

public class Boj9251 {
	static String a, b;

	static int dp[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Longest Common SubSequence
		// 두 문자열의 각 자리를 비교하여 일치할 경우 dp [i][j] = dp [i-1][j-1] +1이 되고,
		// 일치하지 않을 경우는 dp [i][j] = Math.max(dp [i-1][j], dp [i][j-1])
		a = sc.nextLine();		//ACAYKP
		b = sc.nextLine();		//CAPCAK

		dp = new int[b.length() + 1][a.length() + 1]; 
		for (int i = 1; i <= b.length(); i++) {
			for (int j = 1; j <= a.length(); j++) {
				
				//CAPCAK를 기준으로 ACAYKP의 char 중 같은 요소가 있는지 판단
				
				if (b.charAt(i - 1) != a.charAt(j - 1)) {	//i-1번째 문자와 j-1번째 문자가 서로 같지 않다면
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);// 이전 열(i-1)과 이전 행(j-1)의 값 중에서 큰 것으로 갱신
				} else {
					dp[i][j] = dp[i - 1][j - 1] + 1;//같다면 대각선위 dp(i-1)(j-1)에 +1해줌
				}
			}
		}

		System.out.println(dp[b.length()][a.length()]);

	}

}
