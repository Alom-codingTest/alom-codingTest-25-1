import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class subi930 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int orderCnt = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N + 1];
        int[] indegree = new int[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());
            for(int j = 1; j < cnt; j++){
                int singer = Integer.parseInt(st.nextToken());
                graph[before].add(singer);
                before = singer;
                indegree[singer]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()){
            int current = queue.poll();
            sb.append(current+"\n");
            orderCnt++;
            for(int next : graph[current]){
                indegree[next]--;
                if(indegree[next] == 0) queue.offer(next);
            }
        }

        if(orderCnt != N) System.out.println("0");
        else{
            System.out.print(sb);
        }
    }
}