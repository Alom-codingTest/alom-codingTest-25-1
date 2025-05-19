import java.util.*;
import java.io.*;

public class Hyeblee {
	public static final int MAX_N = 30;
	public static final int MAX_MARBLE_WEIGHT = 40000;
	
	public static int n,m; // 추의 갯수, 구슬의 갯수
	public static int[] w; // 추 무게를 저장할 배열
	public static boolean[][] dp = new boolean[MAX_N+1][MAX_MARBLE_WEIGHT+1];
	
	public static void dp(int cnt, int sum) {
		if(dp[cnt][sum]) // 이전에 탐색했다면 종료
			return;
		dp[cnt][sum] = true;
		if(cnt==n) // 0~n-1까지의 추를 모두 사용했다면 종료
			return;
		
		// 다음 추를 사용하는 재귀를 돌린다.
		dp(cnt+1,Math.abs(sum-w[cnt])); // 추를 왼쪽(구슬쪽)에 올려서 만드는 합 
		dp(cnt+1,sum); // 추를 사용하지 않는 합
		dp(cnt+1,sum+w[cnt]); // 추를 오른쪽에 올려서 만드는 합
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder("");
		n = Integer.parseInt(br.readLine());
		w = new int[n];
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			w[i] = Integer.parseInt(st.nextToken());
		}
	
		dp(0,0);
		
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			int marble = Integer.parseInt(st.nextToken());
			sb.append(dp[n][marble]? "Y " : "N ");
		}

		// System.out.println()이 자동으로 sb.toString()호출 한다고 하여,
		// toString() 메서드는 사용하지 않았습니다 !
		
		System.out.println(sb);
	}
	
}