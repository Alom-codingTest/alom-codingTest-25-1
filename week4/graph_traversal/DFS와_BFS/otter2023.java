import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, v;
    static List<Integer>[] edge;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        edge = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            edge[i] = new ArrayList<>();
        }

        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge[a].add(b);
            edge[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(edge[i]);
        }

        dfs(v);
        bw.write("\n");

        for (int i = 1; i <= n; i++) {
            visited[i] = false;
        }

        bfs(v);

        bw.flush();
        bw.close();
    }

    static void dfs(int node) throws IOException {

        visited[node] = true;
        bw.write(node + " ");

        for (int x : edge[node]) {
            if (!visited[x]) {
                dfs(x);
            }
        }
    }

    static void bfs(int node) throws IOException {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()){
            int current = queue.poll(); // 꺼내기
            bw.write(current + " ");

            for (int x : edge[current]) {
                if (!visited[x]) {
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }

    }

}
