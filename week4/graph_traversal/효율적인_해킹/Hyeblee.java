import java.io.*;
import java.util.*;

// 노드의 갯수가 많을수록 bfs가 적합하다.

public class Hyeblee {
	public static int n, m;
	public static int max = 0;
	public static List<Integer>[] adj;
	public static boolean[] visited;
	public static int[] result;

	public static void bfs(int start) {
		visited[start] = true;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		int cnt = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			cnt++;
			for (int val : adj[cur]) {
				if (!visited[val]) {
					queue.offer(val);
					visited[val] = true;
					result[val]++;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		adj = new ArrayList[n + 1];
		result = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		// 인접리스트에 연결하기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
		}

		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			bfs(i);
		}

		ArrayList<Integer> ans = new ArrayList<>();
		int max_value = 0;
		for (int i = 1; i <= n; i++) {
			if (result[i] > max_value) { // 최댓값 갱신
				max_value = result[i];
				ans.clear();
				ans.add(i);
			} else if (result[i] == max_value) { // 최댓값이면 ans에 값 넣어주기
				ans.add(i);
			}
		}

		for (int a : ans) {
			System.out.print(a + " ");
		}

	}
}
