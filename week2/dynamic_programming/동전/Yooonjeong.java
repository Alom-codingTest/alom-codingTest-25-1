import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yooonjeong {
    private static int n, m;
    private static int[] arr = new int[21];
    private static int[][] dp = new int[21][10001];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<t; i++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            m = Integer.parseInt(br.readLine());
            for (int j=0; j<=n; j++) {
                for (int k=0; k<=m; k++) {
                    dp[j][k] = -1;
                }
            }
            for (int j=0; j<=m; j++) {
                dp[1][j] = (j%arr[1] == 0) ? 1 : 0;
            }
            sb.append(calDp(n, m)).append("\n");
        }
        System.out.println(sb.toString());
    }
    
    private static int calDp(int idx, int amount) {
        if (amount == 0) return 1;
        if (idx == 1) return dp[1][amount];
        if (dp[idx][amount] != -1) return dp[idx][amount];
        
        int cur = arr[idx];
        int sum = 0;
        for (int c=0; c<=amount/cur; c++) {
            sum += calDp(idx-1, amount-c*cur);
        }
        dp[idx][amount] = sum;
        return sum;
    }
}
