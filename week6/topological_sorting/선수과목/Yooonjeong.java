import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yooonjeong {
	private static ArrayList<Integer>[] arr;
	private static int[] indegree;
	private static int[] rst;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new ArrayList[n+1];
		indegree = new int[n+1];
		rst = new int[n+1];

		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
			rst[i] = 1;
		}

		int a, b;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			indegree[b]++;
		}

		topologicalSort(n);

		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			sb.append(rst[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

	private static void topologicalSort(int n) {
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1; i<=n; i++) {
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}

		while(!queue.isEmpty()) {
			int cur = queue.poll();

			for(int next:arr[cur]) {
				indegree[next]--;
				rst[next] = Math.max(rst[next], rst[cur] + 1);
				if(indegree[next] == 0) {
					queue.add(next);
				}
			}
		}
	}
}
