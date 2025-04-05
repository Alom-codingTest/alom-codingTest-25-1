import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yooonjeong {
	private static boolean[] visited;
	private static boolean[] rst;
	private static int[] arr;
	private static int start, n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		rst = new boolean[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=1; i<=n; i++) {
			if(rst[i]) continue;
			visited = new boolean[n+1];
			start=i;
			visited[i] = true;
			dfs(arr[i]);
		}
		int cnt=0;
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			if(rst[i]) {
				sb.append(i).append("\n");
				cnt++;
			}
		}
		sb.insert(0, cnt+"\n");
		System.out.println(sb.toString());
	}
	
	private static void dfs(int idx) {
		if(idx==start) {
			for(int i=1; i<=n; i++) {
				if(visited[i]) rst[i] = true;
			}
			return;
		}
		if(visited[idx]) {
			return;
		}
		visited[idx] = true;
		dfs(arr[idx]);
	}
}