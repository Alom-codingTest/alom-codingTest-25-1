package arom.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Num9084 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int t = Integer.parseInt(st.nextToken());


        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine(), " ");
            int[] arr = new int [n];

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(st.nextToken());

            int[] dp  = new int[m+1];
            dp[0] = 1;

            for (int j = 0; j < n; j++) {
                for (int k = arr[j]; k <= m; k++) {
                    dp[k] = dp[k]+dp[k-arr[j]];
                }
            }

            System.out.println(dp[m]);
        }
    }


}//2h
