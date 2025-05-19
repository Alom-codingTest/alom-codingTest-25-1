package brute_force.블랙잭.Uechann;

//카드의 합이 21을 넘지 않는 한도 내에서 카드의 합을 최대한 크게 만드는 게임
//상근, 창영이와 게임한다.

//각 카드에는 양의 정수가 쓰여 있다. 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다.
//이후에 딜러는 숫자 M을 크게 외친다.
//플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 고른다.
//플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.

//입력
//첫째 줄에 카드의 개수 N(3 <= N <= 100)과 M(10 <= M <= 300,000)이 주어진다.
//두째 줄은 카드에 쓰여 있는 수가 주어지고, 이 값은 100,000을 넘지 않는 양의 정수이다.
//합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.

//출력
//M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] cards;
        int max = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input = br.readLine();
        st = new StringTokenizer(input);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        cards = new int[N + 1];

        input = br.readLine();
        st = new StringTokenizer(input);
        for (int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                for (int k = j + 1; k <= N; k++) {
                    if (cards[i] + cards[j] + cards[k] > M) continue;
                    if(max < cards[i] + cards[j] + cards[k]) max = cards[i] + cards[j] + cards[k];
                }
            }
        }

        System.out.println(max);
    }
}
