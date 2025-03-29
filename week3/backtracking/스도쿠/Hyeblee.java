import java.util.*;
import java.io.*;

public class Hyeblee {   
	public static int[][] sudoku = new int[9][9];
	public static Position[] zeroPos = new Position[81];
	public static int zeroCnt = 0;
	public static boolean end = false;

	public static class Position {
		int x;
		int y;

		Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void horizontalSearch(int y, Set set) {
		for (int i = 0; i < 9; i++) {
			set.remove(sudoku[y][i]);
		}
	}

	public static void verticalSearch(int x, Set set) {
		for (int i = 0; i < 9; i++) {
			set.remove(sudoku[i][x]);
		}
	}

	public static void squareSearch(int y, int x, Set set) {
		y = y/3*3;
		x = x/3*3;
		for (int i = y; i < y + 3; i++) {
			for (int j = x; j < x + 3; j++) {
				set.remove(sudoku[i][j]);
			}
		}
	}

	public static void dfs(int depth) {
		if (depth == zeroCnt) {
			end = true;
			return;
		}

		int x = zeroPos[depth].x;
		int y = zeroPos[depth].y;

		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= 9; i++) {
			set.add(i);
		}

		horizontalSearch(y, set); // 가로 중복 제거
		verticalSearch(x, set); // 세로 중복 제거
		squareSearch(y, x, set); // 사격형 범위 중복 제거
		
		for (Integer val : set) {
			sudoku[y][x] = val;
			dfs(depth + 1);
			if (end)
				return;
			// 해당 케이스 실패이므로, 0으로 돌려놓고 다음 케이스로
			// 0으로 초기화 안할 시, 이전 depth로 돌아가서 탐색 시 영향
			sudoku[y][x] = 0; 
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
				if (sudoku[i][j] == 0) {
					Position pos = new Position(i, j);
					zeroPos[zeroCnt++] = pos;
				}
			}
		}

		dfs(0);
		for (int i = 0; i < 9; i++) {
			for (int val : sudoku[i]) {
				sb.append(val + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}