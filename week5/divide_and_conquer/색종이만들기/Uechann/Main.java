package divide_and_conquer.색종이만들기.Uechann;
/*
입력으로 주어진 종이의 한 변의 길이 N과 각 정사각형칸의 색(하얀색 또는 파란색)이 주어질 때 잘
라진 하얀색 색종이와 파란색 색종이의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에는 전체 종이의 한 변의 길이 N이 주어져 있다. N은 2, 4, 8, 16, 32, 64, 128 중 하나이다.
색종이의 각 가로줄의 정사각형칸들의 색이 윗줄부터 차례로 둘째 줄부터 마지막 줄까지 주어진다.
하얀색으로 칠해진 칸은 0, 파란색으로 칠해진 칸은 1로 주어지며,
각 숫자 사이에는 빈칸이 하나씩 있다.

출력
첫째 줄에는 잘라진 햐얀색 색종이의 개수를 출력하고,
둘째 줄에는 파란색 색종이의 개수를 출력한다.

예제 입력 1
8
1 1 0 0 0 0 1 1
1 1 0 0 0 0 1 1
0 0 0 0 1 1 0 0
0 0 0 0 1 1 0 0
1 0 0 0 1 1 1 1
0 1 0 0 1 1 1 1
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1

예제 출력 1
9
7
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1H
public class Main {
    static int[][] paper;
    static int white = 0, blue = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        //색종이 N X N 크기 만큼 헐덩 후 배열에 입력
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0,0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void solve(int row, int col, int size) {
        if (check(row, col, size)) {
            if (paper[row][col] == 0) white++;
            else blue++;
            return;
        }

        int half = size / 2;
        if(half == 0) return;

        solve(row, col, half);                           //왼쪽 위
        solve(row, col + half, half);                //오른쪽 위
        solve(row + half, col, half);               //왼쪽 아래
        solve(row + half, col + half, half);    //오른쪽 아래
    }

    //해당 색종이가 잘려진 부분인지 정사각형 모양의 같은 색깔로 채워져 있는지 확인하는 함수
    public static boolean check(int row, int col, int size) {
        int color = paper[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != color) return false;
            }
        }
        return true;
    }
}
