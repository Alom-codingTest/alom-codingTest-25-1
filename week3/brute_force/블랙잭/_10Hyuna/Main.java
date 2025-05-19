package week3.brute_force.블랙잭._10Hyuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
입력:
첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다.
합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.

출력:
첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] cards = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(searchBlackJack(cards, n, m));

        System.out.println(sb);
    }

    private static int searchBlackJack(int[] cards, int n, int m) {
        int max = 0, sum;

        for (int i = 0; i < n - 2; i++) {
            if (cards[i] > m) continue;
            for (int j = i + 1; j < n - 1; j++) {
                if (cards[i] + cards[j] > m) continue;
                for (int k = j + 1; k < n; k++) {
                    sum = cards[i] + cards[j] + cards[k];
                    if (sum == m) return sum;
                    if (max < sum && sum < m) max = sum;
                }
            }
        }

        return max;
    }

}
