package week4.graph_traversal.트리의_부모_찾기._10Hyuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] parent;
    static boolean[] isVisit;

    @SuppressWarnings("unchecked")  // 자바에서는 제너릭 배열 생성을 권장하지 않기에 경고 포함
    static ArrayList<Integer> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        isVisit = new boolean[n + 1];
        list = new ArrayList[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int nodeA, nodeB;

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nodeA = Integer.parseInt(st.nextToken());
            nodeB = Integer.parseInt(st.nextToken());

            list[nodeA].add(nodeB);
            list[nodeB].add(nodeA);
        }

        dfs(1);

        for (int i = 2; i < parent.length; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);

    }

    static void dfs(int start) {
        isVisit[start] = true;
        for (int index : list[start]) {
            if (!isVisit[index]) {
                parent[index] = start;
                dfs(index);
            }
        }
    }

}
