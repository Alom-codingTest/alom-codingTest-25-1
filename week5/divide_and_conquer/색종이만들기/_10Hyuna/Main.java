package week5.divide_and_conquer.색종이만들기._10Hyuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int white = 0;
    private static int blue = 0;
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
        // StringBuilder를 사용하는 게 효율성이 좋다는 건 알지만,
        // 단순 출력일 경우에는 오히려 StringBuilder 패키지를 import 하는 게 더 비효율적일 수 있다는 말을 봐서
        // sout을 이용했습니다.
    }

    private static void partition(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (board[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int half = size / 2;

        partition(row, col, half);
        partition(row, col + half, half);
        partition(row + half, col, half);
        partition(row + half, col + half, half);
    }

    private static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) return false;
            }
        }
        return true;
    }

}
