//  봄버맨

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int r, c, n;
    static StringTokenizer st;
    static BufferedReader br;
    static char[][] map;
    static Queue<int[]> que = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 1) {
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        if (map[j][k] == 'O') {
                            que.add(new int[] {j, k});
                        }
                    }
                }
                for (char[] m : map) {
                    Arrays.fill(m, 'O');
                }
                bfs();
            }
        }

        if (n % 2 == 0) {
            for (char[] m : map) {
                Arrays.fill(m, 'O');
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    static void bfs() {
        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            int x = tmp[0];
            int y = tmp[1];
            map[x][y] = '.';
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (map[nx][ny] == 'O') {
                        map[nx][ny] = '.';
                    }
                }
            }
        }
    }
}
