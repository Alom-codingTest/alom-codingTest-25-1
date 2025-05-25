package graph_traversal.트리의부모찾기.Uechann;

/*
트리의 특징
- 계층적 구조를 표현하는 그래프의 일종
- 싸이클이 없는 연결 그래프
- N개 노드를 N-1개의 간선으로 연결한 구조
- 부모 자식 관계가 명확함
*/

/*
* 첫째 줄에는 노드의 개수 N이 주어진다.
* 둘째 줄부터 N-1개의 줄에 트리 상의 연결된 두 정점이 주어진다.
* 7
* 1 6
* 6 3
* 3 5
* 4 1
* 2 4
* 4 7
*
* 출력
* 첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력
* 2번 노드의 부모 -> 4
* 3번 노드의 부모 -> 6
* 4번 노드의 부모 -> 1
* 5번 노드의 부모 -> 3
* 6번 노드의 부모 -> 1
* 7번 노드의 부모 -> 3
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Node {
    int verticsNumber;
    int depth;
    int parent;

    Set<Integer> adjNode = new TreeSet<>(); //중복된 인접 노즈 방지 하여 셋으로 자료구조 설정
                                            //자동으로 정렬되어 작은 노드 수부터 실행되도록 설정
    public Node(int verticesNumber) {
        this.verticsNumber = verticesNumber;
    }
}

//30M
public class Main {
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(visited, false);

        //노드 생성
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }
        //1번 노드의 깊이 0으로 설정
        nodes[1].depth = 0;

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes[u].adjNode.add(v);
            nodes[v].adjNode.add(u);
        }
        DFS(1);

        for (int i = 2; i <= N; i++) {
            sb.append(nodes[i].parent + "\n");
        }
        System.out.println(sb);
    }

    //재귀 버전 DFS
    public static void DFS(int start) {
        if (visited[start]) return; //방문했던 노드라면 return

        int currentDepth = nodes[start].depth;
        visited[start] = true;

        //strea() 방식
        nodes[start].adjNode.stream()
                .filter(v -> !visited[v])   //방문하지 않은 정점만 순회
                .peek(v -> nodes[v].depth = currentDepth + 1)   //값 업데이트
                .peek(v -> nodes[v].parent = start)             //값 업데이트
                .forEach(v -> DFS(v));

        //for문 방식
        /*
        for (int adjNode : nodes[start].adjNode) {
            if (!visited[adjNode]) {
                nodes[adjNode].depth = currentDepth + 1;
                nodes[adjNode].parent = start;
                DFS(adjNode);
            }
        }*/
    }
}
