package 합분해.dlwldn30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] dp= new int[K+1][N+1];

        for (int i = 0; i <= N; i++){
            dp[1][i] = 1;
        }

        for (int i = 2; i <= K; i++){
            for (int n = 0; n <= N; n++){
                dp[i][n] = (dp[i][n-1] + dp[i-1][n]) % 1000000000;
            }
        }
        System.out.println(dp[K][N]);
    }

}
