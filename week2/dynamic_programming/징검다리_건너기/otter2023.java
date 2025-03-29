import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] energy = new int[n + 1][2];

        for (int i = 2; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            energy[i][0] = Integer.parseInt(st.nextToken());
            energy[i][1] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][2];

        int INF = 5000 * n;
        for(int i = 0; i <= n; i++) {
            dp[i][0] = INF;
            dp[i][1] = INF;
        } // 슈퍼 점프 하기 이전의 값은 모두 INF

        dp[1][0] = 0;
        if (n >= 2) dp[2][0] = energy[2][0];

        for (int i = 3; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + energy[i][0], dp[i - 2][0] + energy[i - 1][1]);
            dp[i][1] = Math.min(dp[i - 1][1] + energy[i][0], dp[i - 2][1] + energy[i - 1][1]);

            if (i >= 4) {
                /** dp[i][1]에 k를 더하는 경우는 없으므로 슈퍼점프는 한번만 가능하다는 조건에 충족 */
                dp[i][1] = Math.min(dp[i][1], dp[i - 3][0] + k); // 슈퍼점프 사용, dp[i][1]에 처음으로 INF가 아닌 값이 들어간다.
            }
        }

        bw.write(String.valueOf(Math.min(dp[n][0], dp[n][1])));

        bw.flush();
        bw.close();
    }
}