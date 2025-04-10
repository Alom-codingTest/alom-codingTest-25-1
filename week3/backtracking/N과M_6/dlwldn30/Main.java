package N과M_6.dlwldn30;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static List<Integer> output = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 사전순 출력을 위해 정렬

        solve(0, 0);

        System.out.print(sb);
    }

    static void solve(int start, int depth) {
        if (depth == M) {
            for (int num : output) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < N; i++) {
            output.add(arr[i]);
            solve(i + 1, depth + 1);
            output.remove(output.size() - 1);
        }
    }
}


