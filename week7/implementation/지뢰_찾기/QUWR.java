package arom.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num4396 {

    static int n;
    static char[][] map;
    static char[][] play;
    static char[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        play = new char[n][n];
        result = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            play[i] = br.readLine().toCharArray();
        }

        findMine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void findMine() {
        boolean mineOpened = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (play[i][j] == 'x') {
                    if (map[i][j] == '*') {
                        mineOpened = true;
                    } else {
                        result[i][j] = (char)(mineCount(i, j) + '0');
                    }
                } else {
                    result[i][j] = '.';
                }
            }
        }

        if (mineOpened) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '*') {
                        result[i][j] = '*';
                    }
                }
            }
        }
    }

    static int mineCount(int x, int y) {
        int count = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int nx = x + dx;
                int ny = y + dy;

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] == '*') {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
//30min