package week3.backtracking.N과M_6._10Hyuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
문제:
N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
N개의 자연수는 모두 다른 수이다.
N개의 자연수 중에서 M개를 고른 수열
고른 수열은 오름차순이어야 한다.

입력:
첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

출력:
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며,
각 수열은 공백으로 구분해서 출력해야 한다.
수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */

public class Main {

    private static int n;
    private static int m;
    private static StringBuilder sb = new StringBuilder();
    private static int[] sequence;
    private static int[] selectedSequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sequence = new int[n];
        selectedSequence = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sequence);

        combination(0, 0);

        System.out.println(sb);
    }

    private static void combination(int startedIndex, int count) {
        if (count == m) {
            for (int i = 0; i < count; i++) {
                sb.append(selectedSequence[i]).append(" ");
            }

            sb.append("\n");
            return;
        }
        for (int i = startedIndex; i < n; i++) {
            selectedSequence[count] = sequence[i];
            combination(i + 1, count + 1);
        }
    }
}
