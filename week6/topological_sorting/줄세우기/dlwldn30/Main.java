package dlwldn30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 과목 수
        int m = Integer.parseInt(st.nextToken()); // 선수 조건 수

        List<List<Integer>> array= new ArrayList<>();
        int[]order  = new int[n+1];

        for (int i = 0; i <= n; i++) {
            array.add(new ArrayList<>());
        }


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array.get(a).add(b);     // A → B
            order[b]++;           // B의 진입차수 증가
        }

        // 위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (order[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");

            for (int next : array.get(cur)) {
                order[next]--;
                if (order[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}
