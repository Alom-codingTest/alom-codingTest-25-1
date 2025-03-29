package arom.week3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Num2580 {

    static int[][] arr = new int[9][9];
    static List<Location> loc = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    loc.add(new Location(i, j));
                }
            }
        }
        solve();


    }

    static void solve() throws IOException {
        if (loc.isEmpty()) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(arr[i][j]+ " ");
                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
            System.exit(0);
        }
        Location cur = loc.remove(0);
        int x = cur.x;
        int y = cur.y;

        List<Integer> num = numList();

        for (int i = 0; i < 9; i++) {
            num.remove(Integer.valueOf(arr[x][i]));
            num.remove(Integer.valueOf(arr[i][y]));
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                num.remove(Integer.valueOf(arr[(x / 3) * 3 + i][(y / 3) * 3 + j]));
            }
        }
        while(!num.isEmpty()) {
            arr[x][y] = num.remove(0);
            solve();
        }
        arr[x][y] = 0;
        loc.add(0, cur);
    }

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<Integer> numList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        return list;
    }
}//40min
