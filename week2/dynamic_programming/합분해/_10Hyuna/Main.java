package week2.dynamic_programming.합분해._10Hyuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제:
0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.
덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.

입력:
첫째 줄에 두 정수 N(1 ≤ N ≤ 200), K(1 ≤ K ≤ 200)가 주어진다.

출력:
첫째 줄에 답을 1,000,000,000으로 나눈 나머지를 출력한다.

 */

public class Main {

    static int[][] memoization = new int[201][201];
    // 이미 계산한 값을 저장해 두고, 두 번 계산하지 않도록 해서 스택오버플로우가 나는 일을 방지하고자 선언

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        sb.append(calculate(n, k));
        System.out.println(sb);
    }

    private static int calculate(int n, int k) {
        if (k == 1) return 1;
        if (n == 0) return 1;

        if (memoization[n][k] != 0) return memoization[n][k];

        memoization[n][k] = (calculate(n, k - 1) + calculate(n - 1, k)) % 1000000000;

        return memoization[n][k];
    }

}
