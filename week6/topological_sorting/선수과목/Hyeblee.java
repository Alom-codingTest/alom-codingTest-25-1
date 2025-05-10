import java.io.*;
import java.util.*;

public class Hyeblee {

  public static int n, m;
  public static List<List<Integer>> adjList; // 인접리스트
  public static Queue<Integer> q = new ArrayDeque<>();
  public static int[] in; // 진입차수 저장하는 배열
  public static int[] dist; // 각 과목을 들을 수 있는 최소 학기 수 저장할 배열

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    adjList = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      adjList.add(new ArrayList<>());
    }

    in = new int[n + 1];
    dist = new int[n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      adjList.get(a).add(b);
      in[b]++;
    }

    for (int i = 1; i <= n; i++) {
      if (in[i] == 0) {
        q.add(i);
        dist[i] = 1;
      }
    }

    while (!q.isEmpty()) {
      int cur = q.poll();
      for (int next : adjList.get(cur)) {
        in[next]--;
        dist[next] = Math.max(dist[next], dist[cur] + 1);
        if (in[next] == 0) {
          q.add(next);
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      System.out.print(dist[i] + " ");
    }
  }
}
