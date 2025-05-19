package arom.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class Num16954 {

    static boolean[][] maze = new boolean[8][8];
    static boolean[][][] visited = new boolean[8][8][9]; //

    static boolean result;
    static int[] moveX = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    static int[] moveY = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < 8; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                maze[i][j] = s.charAt(j) == '.';
            }
        }


        if (BFS()) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    static boolean BFS() {
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(7, 0, 0));
        visited[7][0][0] = true;


        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                Node poll = queue.poll();

                if (poll.x == 0 && poll.y == 7) return true;

                if (!maze[poll.x][poll.y]) continue;     //움직이고 벽이 이동후 확인

                for (int j = 0; j < 9; j++) {
                    int x = poll.x + moveX[j];
                    int y = poll.y + moveY[j];
                    int t = Math.min(poll.t+1, 8);
                    if (x < 0 || x > 7 || y < 0 || y > 7)
                        continue;
                    if (!maze[x][y])        //움직일때 확인
                        continue;
                    if (!visited[x][y][t]) {
                        queue.add(new Node(x, y, t));
                        visited[x][y][t] = true;
                    }

                }
            }

            moveMaze();
        }
        return false;
    }

    static void moveMaze() {
        for (int i = 7; i > 0; i--) {
            maze[i] = Arrays.copyOf(maze[i - 1], 8);
        }
        Arrays.fill(maze[0], true);
    }

    static class Node {
        int x;
        int y;
        int t;

        public Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;

        }
    }
}
//1h