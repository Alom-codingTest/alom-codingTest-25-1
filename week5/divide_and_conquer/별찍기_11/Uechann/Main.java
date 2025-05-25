package divide_and_conquer.별찍기_11.Uechann;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        //k값에 따라 행과 열에 해당하는 만큼 동적 할당
        result = new char[N + 1][2 * N]; // 11 + 1 -> 23  + 1-> 35 + 1// 2*N
        solve(1, N, N);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 2 * N - 1; j++) {
                sb.append(result[i][j] == '*' ? '*' : " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void solve(int row, int col, int N) {
        if (N == 3) {
            result[row][col] = '*';
            result[row + 1][col - 1] = result[row +1 ][col + 1] = '*';
            for (int i = 0; i < 5; i++) {
                result[row + 2][col - 2 + i] = '*';
            }
            return;
        }

        solve(row, col, N / 2);                              //위
        solve(row + N / 2, col - N / 2, N / 2);    //왼족 아래
        solve(row + N / 2, col + N / 2, N / 2);    //오른쪽 아래
    }
}
