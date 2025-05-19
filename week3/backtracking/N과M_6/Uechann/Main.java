package backtracking.N과M_6.Uechann;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//백트래킹
//: 해를 찾아가는 도중, 경로가 해가 될 것 같지 않으면 그 경로를 더이상 가지 않고 되돌아 간다. -> 가지치기
//. 가능한 모든 경우의 수 중 특정한 조건을 만족하는 경우만 살펴보는 것

//N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램
//N개의 자연수는 모두 다른 수이다.

//조건
//N개의 자연수 중에서 M개를 고른 수열
//고른 수열은 오름차순!

//입력
//첫째 출제 N과 M이 주어진다. (1 <= M <= N <= 8)
//둘째 줄에 N개의 수가 주어진다. (10,000보다 작거나 같은 자연수이다.)

//출력
//한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
//중복되는 수열은 한번만 출력하고, 공백으로 구분해서 출력해야 한다.
//수열은 사전 순으로 중가하는 순서로 출력!!!
public class Main {
    static int[] numbers;
    static int[] result;
    static boolean[] visited;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();
        st = new StringTokenizer(input);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N + 1];
        result = new int[M + 1];
        visited = new boolean[N + 1];


        input = br.readLine();
        st = new StringTokenizer(input);
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        start(1);
        System.out.println(sb);
    }

    public static void start(int idx) {
        //재귀 종료 조건
        if(idx == M + 1) {
            for(int i = 1; i <= M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] || result[idx - 1] > numbers[i]) continue;   //방문한 인덱스이거나 더 낮은 수라면 다름 인덱스로 넘어간다.
            visited[i] = true;  //방문한 인덱스로 체크
            result[idx] = numbers[i];   //해당 수는 결과 배열에 추가
            start(idx + 1);
            visited[i] = false;
        }
    }
}
