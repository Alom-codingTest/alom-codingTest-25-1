import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class subi930 {
    static int[][] flips = {
            {0, 0}, {0, 1}, {0, 2}, // 첫 번째 행
            {1, 0}, {1, 1}, {1, 2}, // 두 번째 행
            {2, 0}, {2, 1}, {2, 2}, // 세 번째 행
            {0, 0}, {1, 0}, {2, 0}, // 첫 번째 열
            {0, 1}, {1, 1}, {2, 1}, // 두 번째 열
            {0, 2}, {1, 2}, {2, 2}, // 세 번째 열
            {0, 0}, {1, 1}, {2, 2}, // 왼쪽 위 -> 오른쪽 아래로 가는 대각선
            {0, 2}, {1, 1}, {2, 0}  // 오른쪽 위 -> 왼쪽 아래로 가는 대각선
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            char[][] board = new char[3][3];
            for(int j = 0; j < 3; j++){
                String line = br.readLine();
                st = new StringTokenizer(line);
                for(int k = 0; k < 3; k++) {
                    board[j][k] = st.nextToken().charAt(0);
                }
            }
            int result = bfs(board);

            System.out.println(result);
        }

    }

    private static int bfs(char[][] board) {
        Queue<char[][]> queue = new LinkedList<>();
        Map<String, Integer> flipCnt = new HashMap<>();
        queue.offer(board);
        flipCnt.put(boardToString(board), 0);

        while(!queue.isEmpty()){
            char[][] current = queue.poll();

            if(isSame(current)){
                return flipCnt.get(boardToString(current));
            }

            for(int i = 0; i < flips.length; i+=3){
                char[][] next = new char[3][3];

                for(int r = 0; r < 3; r++){
                    for (int c = 0; c < 3 ; c++){
                        next[r][c] = current[r][c];
                    }
                }

                for (int j = 0; j < 3; j++) {
                    int x = flips[i + j][0];
                    int y = flips[i + j][1];
                    next[x][y] = flip(next[x][y]);
                }
                String nextState = boardToString(next);
                if (!flipCnt.containsKey(nextState)) { // 아직 방문하지 않은 상태
                    flipCnt.put(nextState, flipCnt.get(boardToString(current)) + 1); // 횟수 갱신 및 큐 추가
                    queue.offer(next);
                }
            }
        }
        return -1;
    }

    private static char flip(char c) {
        return (c == 'H') ? 'T' : 'H';
    }

    private static boolean isSame(char[][] current) {
        char coin = current[0][0];
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3 ; j++){
                if(current[i][j] != coin) return false;
            }
        }
        return true;
    }

    private static String boardToString(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <3; i++){
            for(int j = 0; j <3;j++){
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }
}