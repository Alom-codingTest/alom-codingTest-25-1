import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class State{
	boolean[][] board;
	int cnt;
	State(boolean[][] board, int cnt) {
        this.board = board;
        this.cnt = cnt;
    }
}

public class Yooonjeong {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=0; tc<t; tc++) {
			boolean[][] board = new boolean[3][3];
			 for (int i = 0; i < 3; i++) {
	                st = new StringTokenizer(br.readLine());
	                for (int j = 0; j < 3; j++) {
	                    String coin = st.nextToken();
	                    board[i][j] = coin.equals("H");
	                }
	            }
			sb.append(bfs(board)).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static String boardToString(boolean[][] board) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				sb.append(board[i][j]?"H":"T");
			}
		}
		return sb.toString();
	}
	private static int bfs(boolean[][] board) {
		Set<String> visited = new HashSet<>();
		Queue<State> queue = new ArrayDeque<>();
		
        if (isCompleted(board)) return 0;
		queue.offer(new State(board, 0));
		visited.add(boardToString(board));
		
		while(!queue.isEmpty()) {
			State cur = queue.poll();
		
			for(int order=0; order<8; order++) {
				boolean[][] nextBoard = copyBoard(cur.board);
                if (flip(nextBoard, order)) return cur.cnt+1;
                
                String nextStr = boardToString(nextBoard);
                if(!visited.contains(nextStr)) {
                	visited.add(nextStr);
                	queue.add(new State(nextBoard, cur.cnt+1));
                }
			}
		}
		return -1;
	}
	
	private static boolean[][] copyBoard(boolean[][] board) {
        boolean[][] newBoard = new boolean[3][3];
        for (int i=0; i<3; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, 3);
        }
        return newBoard;
    }
	
	private static boolean flip(boolean[][] board, int order) {
		// 행 기준
		if(order<3) {
			for(int col=0; col<3; col++) {
				board[order][col] = !board[order][col]; 
			}
		}
		// 열 기준
		else if(order<6) {
			int col = order-3;
			for(int row=0; row<3; row++) {
				board[row][col] = !board[row][col]; 
			}
		}
		// 대각선 1
		else if(order==6){
			for(int row=0, col=0; col<3; row++, col++) {
				board[row][col] = !board[row][col];
			}
		}
		// 대각선 2
		else {
			for(int row=0, col=2; col>=0; row++, col--) {
				board[row][col] = !board[row][col];
			}
		}
		return isCompleted(board);
	}
	private static boolean isCompleted(boolean[][] board) {
		boolean check = board[0][0];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(board[i][j]!=check) return false;
			}
		}
		return true;
	}
}
