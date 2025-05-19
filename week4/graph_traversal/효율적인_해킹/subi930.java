import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class subi930 {
    static List<Integer>[] graph; // idx를 신뢰하는 컴퓨터 list 그래프
    static int[] comcnt; // 해킹 가능한 컴퓨터 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        comcnt = new int[N + 1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
           graph[b].add(a); // b를 해킹하면 a도 가능하다
        }

        int max = 0;
        comcnt = new int[N + 1];

        for(int i = 1;i<=N;i++){
            int count = bfs(i,N);
            comcnt[i] = count;
            max = Math.max(max, count);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (comcnt[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static int bfs(int node, int N) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(node);

        int cnt = 1;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : graph[cur]){
                if(!visited[next]){
                    queue.offer(next);
                    cnt++;
                    visited[next] = true;
                }
            }
        }

        return cnt;
    }
}