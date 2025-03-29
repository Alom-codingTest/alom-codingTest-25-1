package week2.dynamic_programming.돌게임._10Hyuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문제:
돌 게임은 두 명이서 즐기는 재밌는 게임이다.
탁자 위에 돌 N개가 있다. 상근이와 창영이는 턴을 번갈아가면서 돌을 가져가며, 돌은 1개 또는 3개 가져갈 수 있다. 마지막 돌을 가져가는 사람이 게임을 이기게 된다.
두 사람이 완벽하게 게임을 했을 때, 이기는 사람을 구하는 프로그램을 작성하시오. 게임은 상근이가 먼저 시작한다.

입력:
첫째 줄에 N이 주어진다. (1 ≤ N ≤ 1000)

출력:
상근이가 게임을 이기면 SK를, 창영이가 게임을 이기면 CY을 출력한다.

n == 1: 상근
n == 2: 창영
n == 3: 상근
n == 4: 창영
n == 5: 상근
n == 6: 창영
n == 7: 상근
n == 8: 창영
n == 9: 상근
n == 10: 창영
n이 홀수 -> SK, n이 짝수 -> CY
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int stoneCount = Integer.parseInt(br.readLine());

        sb.append(stoneCount % 2 == 0 ? "CY": "SK");

        System.out.println(sb);
    }

}
