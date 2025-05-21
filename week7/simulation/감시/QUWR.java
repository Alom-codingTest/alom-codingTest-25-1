package arom.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Num15683 {

    static int n, m;
    static int[][] room;
    static List<int[]> cctvs = new ArrayList<>();
    static int minBlindSpot = 64;


    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][][] directions = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        room = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(input[j]);
                if (room[i][j] >= 1 && room[i][j] <= 5) {
                    cctvs.add(new int[]{i, j});
                }
            }
        }

        dfs(0, room);
        System.out.println(minBlindSpot);
    }

    static void dfs(int depth, int[][] map) {
        if (depth == cctvs.size()) {
            minBlindSpot = Math.min(minBlindSpot, countBlindSpots(map));
            return;
        }

        int[] cctv = cctvs.get(depth);
        int x = cctv[0];
        int y = cctv[1];
        int type = room[x][y];

        for (int[] dirs : directions[type]) {
            int[][] copied = copyMap(map);
            for (int dir : dirs) {
                watch(copied, x, y, dir);
            }
            dfs(depth + 1, copied);
        }
    }

    static void watch(int[][] map, int x, int y, int dir) {
        int nx = x;
        int ny = y;

        while (true) {
            nx += dx[dir];
            ny += dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 6) break;
            if (map[nx][ny] == 0) map[nx][ny] = 7;
        }
    }

    static int countBlindSpots(int[][] map) {
        int count = 0;
        for (int[] row : map) {
            for (int val : row) {
                if (val == 0) count++;
            }
        }
        return count;
    }

    static int[][] copyMap(int[][] original) {
        int[][] newMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            newMap[i] = original[i].clone();
        }
        return newMap;
    }

}
//60min
