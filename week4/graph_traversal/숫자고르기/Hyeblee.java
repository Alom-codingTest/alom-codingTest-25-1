import java.io.*;
import java.util.*;

// 최단 경로는 bfs로

public class Hyeblee {
	public static int N;
	public static int[] line2;
	public static boolean[] visited;
	public static List<Integer> list = new ArrayList<>();
	
    // start~target 사이클이 만들어지면 가능한 원소 !
	public static void dfs(int start, int target) {
		if(line2[start]==target) {
			list.add(target);
			return;
		}
		start = line2[start];
		
		if(!visited[start]) {
			visited[start] = true;
			dfs(start,target);
			visited[start] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		line2 = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=1;i<=N;i++) {
			line2[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=1;i<=N;i++) {
			visited[i] = true;
			dfs(i, i);
			Arrays.fill(visited, false);
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int n: list) {
			System.out.println(n);
		}
	}
}
