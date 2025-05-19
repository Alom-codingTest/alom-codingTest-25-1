import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class subi930 {
    static int N,M;
    static List<Integer>[] graph; // graph[a] = a를 선수과목으로 갖는 과목 리스트
    static int[] indegree; // indegree[i] = 과목 i의 진입 차수(=선수과목 수)
    static int[] orders; // orders[i] = 과목 i를 수강할 수 있는 최소 학기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1]; 
        orders = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b); // 선수과목 a -> 수강 가능 과목 b
            indegree[b]++; // b의 선수과목 갯수 증가
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0) { // 선수과목이 없는 경우
                queue.offer(i); // 큐에 i 추가
                orders[i] = 1; // i 수강가능학기 = 1
            }

        }

        // 위상 정렬
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int next : graph[current]){
                indegree[next]--; // current를 이수했으므로 next의 선수과목 수 감소
                if(indegree[next] == 0) queue.offer(next); // 모든 선수과목을 들었으면 큐에 추가
                orders[next] = Math.max(orders[next], orders[current] + 1); // next 과목을 듣기 위한 최소 학기는 current + 1
            }
        }

        for(int i = 1; i <= N; i++) sb.append(orders[i] + " ");
        System.out.println(sb);
    }

}