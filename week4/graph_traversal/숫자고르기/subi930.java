import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class subi930 {
    static int N,ans = 0;
    static int[] graph; // 첫째줄 숫자 i, 둘째줄 숫자 graph[i] 매핑
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            graph[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]) {
                boolean[] pathVisited = new boolean[N + 1];
                dfs(i,i,pathVisited);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=N;i++){
            if(visited[i]){
                ans++;
                sb.append(i).append("\n");
            }
        }
        System.out.println(ans);
        System.out.println(sb.toString());

    }

    private static void dfs(int start, int current,boolean[] pathVisited) {
        if(pathVisited[current]){
           if(current == start) { // 집합 조건이 맞을 시, 카운트 세기
                for(int i = 1; i <= N; i++){ // 카운트 세기 : visited 갱신
                    if(pathVisited[i] && !visited[i]) visited[i] = true;
                }
            }
            return;
        }

        pathVisited[current] = true;
        int next = graph[current];
        dfs(start,next,pathVisited);

    }
}