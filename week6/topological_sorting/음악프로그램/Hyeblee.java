import java.io.*;
import java.util.*;

public class Hyeblee {

  public static int size;
  public static int n, m;
  public static List<List<Integer>> adjList; // 인접리스트
  public static Queue<Integer> q = new ArrayDeque<>();
  public static int[] inDegree; // 진입차수 저장하는 배열
  public static int[] dist;
  public static List<Integer> result = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    adjList = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      adjList.add(new ArrayList<>());
    }
    inDegree = new int[n + 1];
    dist = new int[n + 1];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      st.nextToken(); // 맡은 가수 수 넘기기
      int cur = Integer.parseInt(st.nextToken());
      int next = Integer.parseInt(st.nextToken());
      adjList.get(cur).add(next);
      inDegree[next]++;
      while (st.hasMoreTokens()) {
        cur = next;
        next = Integer.parseInt(st.nextToken());
        inDegree[next]++;
        adjList.get(cur).add(next);
      }
    }

    for (int i = 1; i <= n; i++) {
      if (inDegree[i] == 0) {
        q.add(i);
        dist[i] = 1;
      }
    }

    while (!q.isEmpty()) {
      int cur = q.poll();
      result.add(cur);
      for (int next : adjList.get(cur)) {
        inDegree[next]--;
        dist[next] = Math.max(dist[next], dist[cur] + 1);
        if (inDegree[next] == 0) {
          q.add(next);
        }
      }
    }

    if (result.size() == n) {
      for (int v : result) {
        System.out.println(v);
      }
    } else {
      System.out.println("0");
    }

  }
}
