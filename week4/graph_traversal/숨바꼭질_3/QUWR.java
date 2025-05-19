package arom.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Num13549 {

    static int n;
    static int k;
    static int result;
    static boolean[] visited = new boolean[100001];
    static Deque<Node> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        queue.add(new Node(n, 0));

        BFS();
        System.out.println(result);
    }

    static void BFS(){
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.loc == k) {
                result= poll.count;
                return;
            }
            if(poll.loc-1 >= 0 && !visited[poll.loc-1]){
                queue.add(new Node(poll.loc-1, poll.count+1));
                visited[poll.loc - 1] = true;
            }
            if(poll.loc * 2 < 100001 && !visited[poll.loc*2]){
                queue.add(new Node(poll.loc*2, poll.count));
                visited[poll.loc * 2] = true;
            }
            if(poll.loc+1<100001 && !visited[poll.loc+1]){
                queue.add(new Node(poll.loc + 1, poll.count+1));
                visited[poll.loc + 1] = true;
            }

        }
    }
    static class Node{
        int loc;
        int count;

        public Node(int loc, int count) {
            this.loc = loc;
            this.count = count;
        }
    }
}
//40min