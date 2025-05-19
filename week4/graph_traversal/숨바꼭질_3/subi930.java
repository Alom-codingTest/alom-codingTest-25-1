import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class subi930 {
    static boolean[] visited = new boolean[100001];
    static int[] mintimes = new int[100001]; //  mintimes[idx] : idx 위치의 최소타임
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans = bfs(N,K);
        System.out.println(ans);
    }

    private static int bfs(int N, int K) {

        queue.add(N);
        visited[N] = true;

        while(!queue.isEmpty()){
            int location = queue.poll();
            int time = mintimes[location];

            if(location*2 <= 100000) {
                check(location*2, time);
            }
            if( location - 1 >= 0) {
                check(location-1, time+1);
            }
            if( location + 1 <= 100000){
                check(location+1, time+1);
            }
        }
        return mintimes[K];
    }

    private static void check(int location,int time) {
        if(!visited[location]){
            queue.offer(location);
            visited[location] = true;
            mintimes[location] = time;
        }
        else if(mintimes[location] > time){ // 최소 시간 갱신
            mintimes[location] = time;
        }
    }
}