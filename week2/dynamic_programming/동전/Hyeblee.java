import java.util.*;
import java.io.*;

public class Hyeblee {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] coins = new int[n];
			int[] dp = new int[10001];

			for (int j = 0; j < n; j++) {
				coins[j] = Integer.parseInt(st.nextToken());
			}
			int m = Integer.parseInt(br.readLine());

			dp[0] = 1;
			
			// 각 동전을 사용하여 dp 배열 업데이트
			for (int coin : coins) {
				for (int j = coin; j <= m; j++) {
					dp[j] += dp[j - coin];
				}
			}

			System.out.println(dp[m]);
		}
	}
}