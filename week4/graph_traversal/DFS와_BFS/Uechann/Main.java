package graph_traversal.DFS와_BFS.Uechann;

/*
* DFS와 BFS로 탐색한 결과를 출력하는 프로그램
* 방문가능한 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
* 정점 번호는 1~N
* 첫째 줄에 정점의 개수 N(1 ~ 1,000), 간선의 개수 M(1 ~ 10,000), 탐색 시작할 정점의 번호 V가 주어진다.
* 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
* 주어진 간선은 양방향 -> 양방향 그래프
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//2H
class Node {
    int verticsNumber;
    Set<Integer> adjNode = new TreeSet<>(); //중복된 인접 노즈 방지 하여 셋으로 자료구조 설정
                                            //자동으로 정렬되어 작은 노드 수부터 실행되도록 설정
    public Node(int verticesNumber) {
        this.verticsNumber = verticesNumber;
    }
}

public class Main {

    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        nodes = new Node[N + 1];            //N + 1 개의 노드클래스 배열 생성
        visited = new boolean[N + 1];       //N + 1 개의 방문배열 할당
        Arrays.fill(visited, false);

        //N개의 노드 생성
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        //간선 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes[u].adjNode.add(v);
            nodes[v].adjNode.add(u);
        }

        //재귀 함수 실행
        DFS(V);
        sb.append("\n");
        Arrays.fill(visited, false);    //visited 배열 false로 초기화
        BFS(V);
        System.out.println(sb);
    }

    //재귀 버전 DFS 구현
    public static void DFS(int start) {
        if (visited[start]) return; //방문했던 노드라면 return

        visited[start] = true;
        sb.append(start).append(" ");

        nodes[start].adjNode.stream()
                .filter(v -> !visited[v])   //방문하지 않은 정점만 순회
                .forEach(v -> DFS(v));
    }

    public static void BFS(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        while(!q.isEmpty()) {
            int u = q.poll();
            sb.append(u).append(" ");
            visited[u] = true;

            nodes[u].adjNode.stream()
                    .filter(v -> !visited[v])   //방문하지 않은 노드에 대해
                    .filter(v -> !q.contains(v))//q에 포함되어 있으면 pass
                    .forEach(v -> q.add(v));
        }
    }
}

/*
* 1. DFS 에서 마지막 값이 여러번 출력이 되어서 초반에 방문 노드 검사
* 2. 양방향이어서 양쪽 노드에 간선 정보 저장
* 3. 인접 노드에 대한 정보가 중복으로 저장될 수 있다 -> set 자료구조로 해결 -> 자동 정렬까지
* 4. BFS에서 q에 중복으로 add되는 현상 -> stream() 연산 과정에서 filter()로 검사후 실행
* 5. DFS 순회 후에 visited[] 배열 false로 초기화 BFS */