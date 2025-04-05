package arom.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1325 {

    static int n;
    static int m;
    static List<List<Integer>> graph;
    static int[] count;
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        count = new int[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            count[i] = BFS(i);
            maxCount = Math.max(maxCount, count[i]);
        }
        for (int i = 1; i <=n ; i++) {
            if(maxCount == count[i]){
                System.out.print(i + " ");
            }
        }

    }

    public static int BFS(int i){
        boolean[] visted = new boolean[n+1];

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        int count = 1;
        visted[i] = true;

        while(!queue.isEmpty()){
            int x = queue.poll();
            for (int node : graph.get(x)) {
                if(!visted[node]){
                    queue.add(node);
                    visted[node] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
//40min