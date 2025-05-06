package week5.divide_and_conquer.별찍기_11._10Hyuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static char[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        stars = new char[n][n * 2 - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(stars[i], ' ');
        }

        drawTriangle(0, n - 1, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void drawTriangle(int row, int col, int size) {
        if (size == 3) {
            stars[row][col] = '*';
            stars[row + 1][col - 1] = stars[row + 1][col + 1] = '*';
            for (int i = -2; i <= 2; i++) {
                stars[row + 2][col + i] = '*';
            }
            return;
        }

        int half = size / 2;
        drawTriangle(row, col, half);                   // 위쪽 삼각형
        drawTriangle(row + half, col - half, half);     // 왼쪽 아래 삼각형
        drawTriangle(row + half, col + half, half);     // 오른쪽 아래 삼각형
    }

}
