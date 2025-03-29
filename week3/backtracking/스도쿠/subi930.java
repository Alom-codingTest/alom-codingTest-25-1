import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class subi930 {
    static List<int[]> indexs;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        board = new int[9][9];
        indexs = new ArrayList<>();

        for(int i = 0; i < 9; i++){
            String line = br.readLine();
            st = new StringTokenizer(line);
            for(int j = 0; j < 9; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0) indexs.add(new int[]{i, j});
            }
        }

        sdoku(0);

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static boolean sdoku(int idx) {
        if(idx == indexs.size()) return true;

        int x = indexs.get(idx)[0];
        int y = indexs.get(idx)[1];

        for(int num = 1; num <= 9; num++){
            if(checkElement(num, x, y)) {
                board[x][y] = num;
                // 다음 빈칸에 대해 탐색
                if(sdoku(idx+1)) return true;
                // 탐색 실패 시, 해당 빈칸 초기화 및 다음 숫자로 시도 (백트래킹)
                board[x][y] = 0;
            }
        }

        return false;
    }

    // 원소 중복 검사
    private static boolean checkElement(int num, int x, int y) {
        // 가로줄 검사
        for(int i = 0; i < 9; i++){
            if(board[x][i] == num){
                return false;
            }
        }

        // 세로줄 검사
        for(int i = 0; i < 9; i++){
            if(board[i][y] == num){
                return false;
            }
        }

        // 정사각형 검사
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for(int i = startX; i < startX + 3;i++){
            for(int j = startY; j < startY + 3; j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}