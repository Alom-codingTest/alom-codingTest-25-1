package arom.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1463 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        dp = new int[n+5];
        dp[1] = 0;

        for (int i = 2; i <= n ; i++) {
            int min = 1000000;
            if (i % 2 == 0) {
                min = Math.min(min, dp[i/2]);
            }
            if(i%3 == 0){
                min = Math.min(min, dp[i/3]);
            }
            min = Math.min(min, dp[i-1]);
            dp[i] = min+1;
        }


        System.out.println(dp[n]);

    }


}
//40min
