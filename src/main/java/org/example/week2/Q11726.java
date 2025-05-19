package org.example.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[] dp = new Integer[N + 1];
        dp[0] = dp[1] = 1;

        System.out.println(recur(N, dp));
    }

    private static int recur(int n, Integer[] dp) {
        if (dp[n] == null) {
            dp[n] = (recur(n - 1, dp) + recur(n - 2, dp)) % 10007;
        }
        return dp[n];
    }
}
