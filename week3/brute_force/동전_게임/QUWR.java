package arom.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    static char[][] board = new char[3][3];
    static int minFlips;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n > 0) {
            for (int i = 0; i < 3; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 3; j++) {
                    board[i][j] = st.nextToken().charAt(0);
                }
            }

            minFlips = Integer.MAX_VALUE;
            solve(0, 0);
            System.out.println(minFlips == Integer.MAX_VALUE ? -1 : minFlips);
            n--;
        }
    }

    static void solve(int step, int flips) {
        if (check()) {
            minFlips = Math.min(minFlips, flips);
            return;
        }
        if (step >= 8) return;

        char[][] original = copyBoard();

        flipRow(step % 3);
        solve(step + 1, flips + 1);
        restoreBoard(original);

        flipColumn(step % 3);
        solve(step + 1, flips + 1);
        restoreBoard(original);

        if (step < 2) {
            flipMainDiagonal();
            solve(step + 1, flips + 1);
            restoreBoard(original);

            flipAntiDiagonal();
            solve(step + 1, flips + 1);
            restoreBoard(original);
        }

        solve(step + 1, flips);
    }

    static boolean check() {
        char first = board[0][0];
        for (char[] row : board) {
            for (char c : row) {
                if (c != first) return false;
            }
        }
        return true;
    }

    static void flipRow(int row) {
        for (int i = 0; i < 3; i++) {
            board[row][i] = board[row][i] == 'H' ? 'T' : 'H';
        }
    }

    static void flipColumn(int col) {
        for (int i = 0; i < 3; i++) {
            board[i][col] = board[i][col] == 'H' ? 'T' : 'H';
        }
    }

    static void flipMainDiagonal() {
        for (int i = 0; i < 3; i++) {
            board[i][i] = board[i][i] == 'H' ? 'T' : 'H';
        }
    }

    static void flipAntiDiagonal() {
        for (int i = 0; i < 3; i++) {
            board[i][2 - i] = board[i][2 - i] == 'H' ? 'T' : 'H';
        }
    }

    static char[][] copyBoard() {
        char[][] copy = new char[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, 3);
        }
        return copy;
    }

    static void restoreBoard(char[][] original) {
        for (int i = 0; i < 3; i++) {
            System.arraycopy(original[i], 0, board[i], 0, 3);
        }
    }
}
//1h30min
//chatgpt 참고
