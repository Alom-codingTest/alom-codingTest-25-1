import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class subi930 {
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(pooling(N,0,0));
    }

    private static int pooling(int n, int r, int c) {
        if(n==2){
            int[] arr = new int[4];
            int idx = 0;
            for(int i = r; i < r+2; i++){
                for(int j = c; j < c+2; j++){
                    arr[idx++] = board[i][j];
                }
            }
            Arrays.sort(arr);
            return arr[2];
        }
        int half = n/2;
        int[] arr = new int[4];

        arr[0] = pooling(half, r, c);
        arr[1] = pooling(half, r+half, c);
        arr[2] = pooling(half, r, c+half);
        arr[3] = pooling(half, r+half, c+half);

        Arrays.sort(arr);
        return arr[2];
    }
}