package arom.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num11053 {

    static Save[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        dp = new Save[n];

        st = new StringTokenizer(bf.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = new Save();
        }
        dp[0].num = arr[0];
        dp[0].count = 1;
        int result = 1;

        for (int i = 1; i < n; i++) {
            int count = 0;
            int num = arr[i];
            for (int j = 0; j < i; j++) {
                if(dp[j].count > count && num > dp[j].num){
                    count = dp[j].count;
                }
            }
            dp[i].count = count+1;
            dp[i].num = arr[i];
            if (result < dp[i].count) {
                result = dp[i].count;
            }
        }

        System.out.println(result);
    }

    public static class Save{
        int num;
        int count;
    }
}//30min
