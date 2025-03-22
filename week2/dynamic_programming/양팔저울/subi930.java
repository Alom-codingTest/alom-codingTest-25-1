import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class subi930 {
    static boolean[][] dp;
    static boolean[] visited;
    static int[] weights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int wCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        weights = new int[wCnt];
        for(int i = 0; i < wCnt;i++){
            weights[i] = Integer.parseInt(st.nextToken());
        }

        int bCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] beads = new int[bCnt];
        for(int i = 0; i < bCnt;i++){
            beads[i] = Integer.parseInt(st.nextToken());
        }
        dp = new boolean[wCnt + 1][40001];
        visited = new boolean[40001];

        // 가능한 무게 조합 계산
        dfs(0, 0);

        StringBuilder sb = new StringBuilder();
        for (int bead : beads) {
            if (dp[wCnt][bead]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }

        System.out.println(sb);
    }

    static void dfs(int idx, int sum) {
        if (dp[idx][sum]) return;

        dp[idx][sum] = true;
        if (idx == weights.length) return;
        int weight = weights[idx];
        dfs(idx + 1, sum); // 추 사용 안함
        dfs(idx + 1, sum + weight); // 오른쪽 접시에 놓음
        dfs(idx + 1, Math.abs(sum - weight)); // 왼쪽 접시에 놓음
    }
}