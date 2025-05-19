import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 시간복잡도 : O(n^2logn)
public class subi930 {
    static int N,bcnt,wcnt;
    static boolean[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new boolean[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < N; j++){
                board[i][j] = st.nextToken().equals("1");
            }
        }

        countConfetti(N,0,0);
        System.out.println(wcnt);
        System.out.println(bcnt);
    }

    private static void countConfetti(int size,int r, int c) {
        if(checkColor(size, r, c)){
            boolean color = board[r][c];
            if(color) bcnt++;
            else wcnt++;
            return;
        }
        int half = size/2;
        countConfetti(half,r,c);
        countConfetti(half,r,c+half);
        countConfetti(half,r+half,c);
        countConfetti(half,r+half,c+half);
    }

    private static boolean checkColor(int size, int r, int c) {
        boolean color = board[r][c];

        for(int i = r; i < r + size; i++){
            for(int j = c; j < c + size; j++){
                if(board[i][j]!=color) return false;
            }
        }
        return true;
    }
}