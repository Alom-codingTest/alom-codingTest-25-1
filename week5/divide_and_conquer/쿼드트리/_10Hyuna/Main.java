package week5.divide_and_conquer.쿼드트리._10Hyuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[][] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        compress(0, 0, n);
        System.out.println(sb.toString());
    }

    private static void compress(int row, int col, int size) {
        if (isSame(row, col, size)) {
            sb.append(arr[row][col]);
            return;
        }

        int half = size / 2;
        sb.append("(");
        compress(row, col, half);                // 왼쪽 위
        compress(row, col + half, half);         // 오른쪽 위
        compress(row + half, col, half);         // 왼쪽 아래
        compress(row + half, col + half, half);  // 오른쪽 아래
        sb.append(")");
    }

    private static boolean isSame(int row, int col, int size) {
        int value = arr[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != value) return false;
            }
        }
        return true;
    }

}
