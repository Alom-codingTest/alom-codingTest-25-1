import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Yooonjeong {
	private static int[][] board = new int[9][9];
	private static Set<Integer>[] rows = new HashSet[9];
	private static Set<Integer>[] cols = new HashSet[9];
	private static Set<Integer>[] boxes = new HashSet[9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0; i<9; i++) {
			rows[i] = new HashSet<>();
			cols[i] = new HashSet<>();
			boxes[i] = new HashSet<>();
		}
		
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] != 0) {
					rows[i].add(board[i][j]);
					cols[j].add(board[i][j]);
					boxes[getBoxIdx(i, j)].add(board[i][j]);	
				}
			}
		}
		solve(0,0);
		print();
	}
	
	private static int getBoxIdx(int row, int col) {
		return (row/3)*3 + (col/3);
	}

	private static boolean solve(int row, int col) {
		if(row==9) return true;
		
		int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col == 8) ? 0 : col + 1;
        
        if (board[row][col] != 0) {
            return solve(nextRow, nextCol);
        }
		
        for(int num=1; num<=9; num++) {
			int boxIdx = getBoxIdx(row, col);
			if(!rows[row].contains(num) && !cols[col].contains(num) && !boxes[boxIdx].contains(num)) {
				board[row][col] = num;
				rows[row].add(num);
				cols[col].add(num);
				boxes[boxIdx].add(num);
				
				if (solve(nextRow, nextCol)) {
                    return true;
                }
				
				board[row][col] = 0;
                rows[row].remove(num);
                cols[col].remove(num);
                boxes[boxIdx].remove(num);
			}
		}
		return false;
	}
	
	private static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
