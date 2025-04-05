import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class subi930 {
    static boolean[][] board = new boolean[8][8];
    static List<int[]> walls = new ArrayList<>();
    // 8방향 + 제자리 (총 9가지)
    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1, 0};
    static int[] dy = {0, 1, 0, -1, 1, -1, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                board[i][j] = line.charAt(j) == '.'; // 빈 칸: true, 벽: false
                if (!board[i][j]) walls.add(new int[]{i, j});
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{7, 0});

        while (!queue.isEmpty()) {
            boolean[][] visited = new boolean[8][8]; // 매 시간마다 방문 배열 새로 생성

            int qSize = queue.size();
            for (int k = 0; k < qSize; k++) {
                int[] current = queue.poll();
                int currentX = current[0];
                int currentY = current[1];

                if (!board[currentX][currentY]) continue; // 현재 위치에 벽이 내려왔으면 skip
                if (currentX == 0 && currentY == 7) return 1;

                for (int i = 0; i < 9; i++) {
                    int nextX = currentX + dx[i];
                    int nextY = currentY + dy[i];

                    if (nextX < 0 || nextX >= 8 || nextY < 0 || nextY >= 8 ||
                            !board[nextX][nextY] || visited[nextX][nextY]) continue;

                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }

            // 벽 내리기
            for (int i = walls.size() - 1; i >= 0; i--) {
                int x = walls.get(i)[0];
                int y = walls.get(i)[1];
                board[x][y] = true; // 기존 위치 비움

                if (x < 7) {
                    board[x + 1][y] = false; // 아래로 벽 이동
                    walls.get(i)[0]++; // 위치 갱신
                } else {
                    walls.remove(i); // 8번째 줄이면 제거
                }
            }
        }

        return 0;
    }
}
