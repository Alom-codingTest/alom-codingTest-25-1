import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yooonjeong {
	private static int n, m;
	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;
	private static int max=0, curIdx;
	private static int[] rst;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n+1];
		visited = new boolean[n+1];
		rst = new int[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int a, b;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph[b].add(a);
		}
		
		for(int i=1; i<=n; i++) {
			visited = new boolean[n+1];
			curIdx=i;
			bfs(i);
			max = Math.max(rst[i], max);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			if(rst[i]==max) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb.toString());
	}
	
	private static void bfs(int idx) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(idx);
		visited[idx] = true;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			rst[curIdx]++;
			if(!graph[cur].isEmpty()) {
				for(int child:graph[cur]) {
					if(!visited[child]) {
						queue.add(child);
						visited[child] = true;
					}
				}
			}
		}
	}
}
