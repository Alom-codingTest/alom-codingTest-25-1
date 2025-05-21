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
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 과목 수
        int M = Integer.parseInt(st.nextToken()); // 선수 조건 수

        List<List<Integer>> graph = new ArrayList<>(); // 선수 과목 관계를 담은 인접 리스트
        int[] inDegree = new int[N + 1]; // 진입 차수, inDegree[i]: 과목 i의 선수과목 수
        int[] semester = new int[N + 1]; // 최소 이수 학기, semester[i]: 과목 i를 이수할 수 있는 최소 학기 수

        // 그래프 초기화 및 최소 학기 초기값 설정
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            semester[i] = 1; // 기본적으로 모든 과목은 1학기부터 수강 가능
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

        // 진입 차수 0인 과목(선수과목이 없는 과목) 먼저 큐에 넣기
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 현재 과목을 듣고 나면 다음 과목의 수강 가능 시점(학기)을 갱신
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                inDegree[next]--;
                // 다음 과목의 최소 학기 갱신: 이전 과목 + 1
                semester[next] = Math.max(semester[next], semester[current] + 1);
                // 진입 차수가 0이 되면 큐에 넣어서 계속 탐색
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // 모든 과목의 최소 수강 학기를 출력
        for (int i = 1; i <= N; i++) {
            sb.append(semester[i]).append(" ");
        }

        System.out.println(sb);
    }
}
