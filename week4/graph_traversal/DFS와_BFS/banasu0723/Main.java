package graph_traversal.DFS와_BFS.banasu0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] graph;     // 인접 행렬
    static boolean[] visited; // 방문 여부 체크용 배열
    static StringBuilder dfsResult = new StringBuilder(); // DFS 결과 저장용
    static StringBuilder bfsResult = new StringBuilder(); // BFS 결과 저장용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 입력: 정점 수 N, 간선 수 M, 시작 정점 V
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점 수
        int M = Integer.parseInt(st.nextToken()); // 간선 수
        int V = Integer.parseInt(st.nextToken()); // 시작 정점

        // 인접 행렬 초기화 (1-based index 사용)
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향 연결
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        // DFS 실행
        dfs(V);
        System.out.println(dfsResult.toString().trim()); // 결과 출력 (양 끝 공백 제거)

        // 방문 배열 초기화 후 BFS 실행
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(bfsResult.toString().trim()); // 결과 출력
    }

    // 깊이 우선 탐색 (재귀)
    public static void dfs(int v) {
        visited[v] = true; // 방문 처리
        dfsResult.append(v).append(" "); // 결과에 추가

        // 정점 번호가 작은 것부터 탐색
        for (int i = 1; i < graph.length; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                dfs(i); // 재귀 호출
            }
        }
    }

    // 너비 우선 탐색 (큐 사용)
    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        bfsResult.append(v).append(" ");

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 정점 번호가 작은 순서대로 인접 노드 탐색
            for (int i = 1; i < graph.length; i++) {
                if (graph[current][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    bfsResult.append(i).append(" ");
                }
            }
        }
    }
}
