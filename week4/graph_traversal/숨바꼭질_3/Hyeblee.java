import java.io.*;
import java.util.*;

// 최단 경로는 bfs로

public class Hyeblee {
	public static int N, K;
	public static int[] result = new int[100001];

	public static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(N);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int curSecond = result[cur];
			
			int a = cur*2;
			int b = cur+1;
			int c = cur-1;
			
			if(a<100001&&result[a]>curSecond) { // 2배 연산
				result[a] = curSecond;
				queue.offer(a);
			}
			if(b<100001&&result[b]>curSecond+1) { // +1 연산
				result[b] = curSecond+1;
				queue.offer(b);
			}
			if(c>=0&&result[c]>curSecond+1) { // -1 연산
				result[c] = curSecond+1;
				queue.offer(c);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Arrays.fill(result, Integer.MAX_VALUE);
		result[N] = 0; // 0에서 시작
		bfs();
		System.out.println(result[K]);
	}
}
