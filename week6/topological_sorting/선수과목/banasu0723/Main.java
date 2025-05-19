package topological_sorting.선수과목.banasu0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 과목 수
        int M = Integer.parseInt(st.nextToken()); // 선수 조건 수

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N + 1]; // 진입 차수
        int[] semester = new int[N + 1]; // 최소 이수 학기 (정답 배열)

        // 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            semester[i] = 1; // 최소 학기 = 1학기
        }

        // 간선 정보 입력 (선수과목 → 후속과목)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            inDegree[B]++;
        }

        // 위상 정렬
        Queue<Integer> queue = new LinkedList<>();

        // 진입 차수 0인 과목 먼저 큐에 넣기
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // BFS로 위상 정렬 + 학기 계산
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                inDegree[next]--;
                // 다음 과목의 최소 학기 갱신: 이전 과목 + 1
                semester[next] = Math.max(semester[next], semester[current] + 1);

                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(semester[i]).append(" ");
        }

        System.out.println(sb);
    }
}
