import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class subi930 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T;i++){
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N ; j++){
                coins[j] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M+1];
            dp[0] = 1;

            for(int coin : coins){
                for(int m = coin; m <= M;m++){
                    dp[m] += dp[m - coin];
                }
            }

            sb.append(dp[M]).append("\n");
        }
        System.out.println(sb);
    }
}