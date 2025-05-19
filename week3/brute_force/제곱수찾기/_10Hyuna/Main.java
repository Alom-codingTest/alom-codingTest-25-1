package week3.brute_force.제곱수찾기._10Hyuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
문제:
N행 M열의 표 A가 있고, 표의 각 칸에는 숫자가 하나씩 적혀있다.
연두는 서로 다른 1개 이상의 칸을 선택하려고 하는데, 행의 번호가 선택한 순서대로 등차수열을 이루고 있어야 하고, 열의 번호도 선택한 순서대로 등차수열을 이루고 있어야 한다.
이렇게 선택한 칸에 적힌 수를 순서대로 이어붙이면 정수를 하나 만들 수 있다.
연두가 만들 수 있는 정수 중에서 가장 큰 완전 제곱수를 구해보자. 완전 제곱수란 어떤 정수를 제곱한 수이다.

입력:
첫째 줄에 N, M이 주어진다. 둘째 줄부터 N개의 줄에는 표에 적힌 숫자가 1번 행부터 N번 행까지 순서대로 한 줄에 한 행씩 주어진다.
한 행에 적힌 숫자는 1번 열부터 M번 열까지 순서대로 주어지고, 공백없이 모두 붙여져 있다.

출력:
첫째 줄에 연두가 만들 수 있는 가장 큰 완전 제곱수를 출력한다. 만약, 완전 제곱수를 만들 수 없는 경우에는 -1을 출력한다.

 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] squareNumber = new int[10][10];

        String command;
        int result = 1;

        for (int i = 0; i < n; i++) {
            command = br.readLine();

            for (int j = 0; j < m; j++) {
                squareNumber[i][j] = Integer.parseInt(String.valueOf(command.charAt(j)));
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                for (int x = -n; x < n; ++x) {
                    for (int y = -m; y < m; ++y) {
                        if(x == 0 && y == 0) continue;

                        int k = 0;
                        int newI = i;
                        int newJ = j;

                        while (newI >= 0 && newI < n && newJ >= 0 && newJ < m)
                        {
                            k = 10 * k + squareNumber[newI][newJ];
                            if (Math.abs(Math.sqrt(k) - (int)Math.sqrt(k)) < 1e-10){
                                result = Math.max(result, k);
                            }
                            newI += x;
                            newJ += y;
                        }
                    }
                }
            }
        }


        sb.append(result);

        System.out.println(sb);
    }

}
