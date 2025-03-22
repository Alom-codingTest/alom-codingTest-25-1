package arom.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2629 {

    static boolean[][] dp;
    static int[] weight;
    static int[] beads;
    static int n;
    static int beadCount;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(bf.readLine());
        weight = new int[n];
        dp = new boolean[n+1][40001];

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
            dp[0][weight[i]] = true;
        }

        beadCount = Integer.parseInt(bf.readLine());
        beads = new int[beadCount];
        st = new StringTokenizer(bf.readLine(), " ");

        for (int i = 0; i < beadCount; i++) {
            beads[i] = Integer.parseInt(st.nextToken());
        }
        recursive(0, 0);


        for (int i = 0; i < beadCount; i++) {
            boolean exist = false;
            for (int j = 0; j <= n; j++) {
                if (dp[j][beads[i]]) {
                    System.out.print("Y ");
                    exist = true;
                    break;
                }
            }
             if(!exist){
                System.out.print("N ");
            }
        }
    }

    static void recursive(int x, int y) {
        if (x > n || dp[x][y]) return;

        dp[x][y] = true;

        if(x < n) {
            recursive(x + 1, y);
            recursive(x + 1, weight[x] + y);
            recursive(x + 1, Math.abs(weight[x] - y));
        }

    }
}//2h 30min
