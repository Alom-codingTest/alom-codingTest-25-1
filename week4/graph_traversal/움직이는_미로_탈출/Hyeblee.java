import java.io.*;
import java.util.*;


public class Hyeblee {
	public static final int SIZE = 8;
	// 제자리 + 8방향 (↑, ↗, →, ↘, ↓, ↙, ←, ↖) 순서대로 정의
	public static final int[] dx = { 0, 0, 1, 1, 1, 0, -1, -1, -1 };
	public static final int[] dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

	public static char[][] chess = new char[SIZE][SIZE];
	public static int second = 0;
	
	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int bfs() {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(0, 7));
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i=0;i<size;i++) { // 현재 시점(초)의 노드들 탐색
				Node cur = queue.poll();
				if (chess[cur.y][cur.x] == '#')
					continue;
				if (cur.x == 7 && cur.y == 0)
					return 1;
				for (int j = 0; j < 9; j++) { // cur에서 이동할 수 있는 점 큐에 넣기
					int x = cur.x + dx[j];
					int y = cur.y + dy[j];
					if (isInRange(x, y) && chess[y][x] != '#') {
						queue.offer(new Node(x, y));
					}
				}
			}
			
			// 다음 시점(초)로 이동 전에 벽 이동하기
			moveWall();
		}
		return 0;
	}

	public static void moveWall() {
		// 맨 아래부터 채워야 원하는 대로 미룰 수 있다.
		for (int i = SIZE - 1; i > 0; i--) {
			chess[i] = Arrays.copyOf(chess[i - 1], 8);
		}
		chess[0] = "********".toCharArray();

	}

	public static boolean isInRange(int x, int y) {
		return x >= 0 && x < 8 && y >= 0 && y < 8;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 8; i++) {
			String input = br.readLine();
			chess[i] = input.toCharArray();
		}
		System.out.println(bfs());
	}
}
