import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yooonjeong {
	private static ArrayList<Integer>[] arr;
	private static int[] indegree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n+1];
		indegree = new int[n+1];
		for(int i=1; i<=n; i++){
			arr[i] = new ArrayList<>();
		}
		
		int cnt, prev, cur;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken());
			prev = Integer.parseInt(st.nextToken());
			
			for(int j=1; j<cnt; j++) {
				cur = Integer.parseInt(st.nextToken());
				arr[prev].add(cur);
				indegree[cur]++;
				prev = cur;
			}
		}
		System.out.println(topologicalSort(n));
	}
	public static String topologicalSort(int n) {
		Queue<Integer> queue = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			if(indegree[i]==0) {
				queue.offer(i);
			}
		}
		
		int cnt=0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			cnt++;
			sb.append(cur + "\n");
			for(int next:arr[cur]) {
				indegree[next]--;
				if(indegree[next]==0) {
					queue.offer(next);
				}
			}
		}
		if(cnt != n) return "0";
		return sb.toString();
	}

}
