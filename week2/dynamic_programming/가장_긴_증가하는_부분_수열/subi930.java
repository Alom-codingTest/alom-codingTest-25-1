import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class subi930 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int length = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }

            length = Math.max(length, dp[i]);
        }

        System.out.println(length);
    }
}