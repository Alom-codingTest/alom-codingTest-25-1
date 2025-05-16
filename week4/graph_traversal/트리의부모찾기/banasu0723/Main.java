package graph_traversal.트리의부모찾기.banasu0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] tree; // 트리(그래프)를 인접 리스트로 표현
    static int[] parent;         // 각 노드의 부모를 저장할 배열
    static boolean[] visited;    // 방문 여부 체크 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드 개수

        // 배열 초기화
        tree = new ArrayList[n + 1]; // 1번부터 사용하므로 +1
        parent = new int[n + 1];
        visited = new boolean[n + 1];

        // 인접 리스트 초기화
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // 간선 입력 받기 (n-1개)
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향 연결
            tree[a].add(b);
            tree[b].add(a);
        }

        // BFS로 탐색하면서 부모 찾기
        bfs(1); // 루트를 1번 노드로 시작

        // 2번 노드부터 N번 노드까지 부모 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }

    // BFS를 이용한 부모 찾기
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true; // 루트 방문 처리

        while (!queue.isEmpty()) {
            int current = queue.poll(); // 현재 노드

            for (int next : tree[current]) {
                if (!visited[next]) {
                    visited[next] = true;    // 방문 처리
                    parent[next] = current;  // 부모 기록
                    queue.add(next);         // 다음 노드 탐색
                }
            }
        }
    }
}
