package graph_traversal.숫자고르기.Uechann;

/*세로 두 줄, 가로로 N개의 칸으로 이루어진 표가 있다.
첫째 줄의 각 칸에는 정수 1, 2, …, N이 차례대로 들어 있고
둘째 줄의 각 칸에는 1이상 N이하인 정수가 들어 있다.
첫째 줄에서 숫자를 적절히 뽑으면,
그 뽑힌 정수들이 이루는 집합과, 뽑힌 정수들의 바로 밑의 둘째 줄에 들어있는 정수들이 이루는 집합이 일치한다.
이러한 조건을 만족시키도록 정수들을 뽑되, 최대로 많이 뽑는 방법을 찾는 프로그램을 작성하시오.

예를 들어, N=7인 경우 아래와 같이 표가 주어졌다고 하자.
1 2 3 4 5 6 7
3 1 1 5 5 4 6

이 경우에는 첫째 줄에서 1, 3, 5를 뽑는 것이 답이다.
첫째 줄의 1, 3, 5
밑에는 각각 3, 1, 5가 있으며 두 집합은 일치한다.
이때 집합의 크기는 3이다.
만약 첫째 줄에서 1과 3을 뽑으면, 이들 바로 밑에는 정수 3과 1이 있으므로 두 집합이 일치한다.
그러나, 이 경우에 뽑힌 정수의 개수는 최대가 아니므로 답이 될 수 없다.

입력
첫째 줄에는 N(1≤N≤100)을 나타내는 정수 하나가 주어진다.
그 다음 줄부터는 표의 둘째 줄에 들어가는 정수들이 순서대로 한 줄에 하나씩 입력된다.

출력
첫째 줄에 뽑힌 정수들의 개수를 출력하고,
그 다음 줄부터는 뽑힌 정수들을 작은 수부터 큰 수의 순서로 한 줄에 하나씩 출력한다.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

//30M
public class Main {
    static int N;
    static int[][] nums;
    static boolean[] visited;
    static Set<Integer> s1 = new TreeSet<>();
    static Set<Integer> s2 = new TreeSet<>();
    static Set<Integer> result = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        Arrays.fill(visited, false);

        nums = new int[3][N + 1];
        for (int i = 1; i <= N; i++) {
            nums[1][i] = i;
            nums[2][i] = Integer.parseInt(br.readLine());
        }

        //숫자하나씩 노드로 설정하고 밑에 행에 있는 숫자를 인접 노드로 설정한다.
        //이때 방향 간선으로 설정
        //1 -> 3
        //3 -> 1 이렇게 순환이 만들어지면 결국 두 집합이 같아진다.
        //이때 만든어진 순환 노드들을 모두 다 더해야 최대 답이 된다.

        for (int i = 1; i <= N; i++) {
            solve(i);
            //두 집합이 일치하면 결과 집합에 추가
            if (s1.equals(s2)) result.addAll(s2);

            s1.clear();
            s2.clear();
            Arrays.fill(visited, false);
        }
        sb.append(result.size()).append("\n");
        result.forEach(a -> sb.append(a).append("\n"));

        System.out.println(sb);
    }

    public static void solve(int start) {
        if (visited[start]) return;

        //s1 집합에 추가
        s1.add(start);
        visited[start] = true;
        //s2 집합에 추가
        s2.add(nums[2][start]);

        if (!visited[nums[2][start]]) solve(nums[2][start]);
    }
}
