import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yooonjeong {
	private static int n, k, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		max = Math.min(100000, Math.max(n, k)*2);
		
		System.out.println(bfs());
	}
	
	private static boolean range(int x) {
		if(x>=0 && x<=max) return true;
		return false;
	}

	private static int bfs() {
		int rst=1000000;
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[100001];
		queue.add(new int[] {n, 0});
		visited[n] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curPos = cur[0];
			int curSec = cur[1];
			visited[curPos] = true;
			if(curPos==k) {
				rst = Math.min(rst, curSec);
			}
			if(range(curPos+1) && !visited[curPos+1]) {
				queue.add(new int[] {curPos+1, curSec+1});
			}
			if(range(curPos*2) && !visited[curPos*2]) {
				queue.add(new int[] {curPos*2, curSec});
			}
			if(range(curPos-1) && !visited[curPos-1]) {
				queue.add(new int[] {curPos-1, curSec+1});
			}
		}
		return rst;
	}
}
