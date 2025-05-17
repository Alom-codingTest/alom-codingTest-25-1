package arom.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Num21922 {

    static int n;
    static int m;
    static int[][] room;
    static boolean[][] result;
    static int count;
    static List<List<Integer>> aircon;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);
        room = new int[n][m];
        result = new boolean[n][m];
        aircon = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String[] object = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(object[j]);
                if(room[i][j] == 9){
                    aircon.add(new ArrayList<>());
                    aircon.get(aircon.size()-1).add(i);
                    aircon.get(aircon.size()-1).add(j);
                }
            }
        }
        if(aircon.isEmpty()){
            System.out.println(0);
        } else {
            CountSeat();
            System.out.println(count);
        }
    }

    static void CountSeat(){
        for (List<Integer> seats : aircon) {
            findPathLeft(seats.get(0), seats.get(1));
            findPathRight(seats.get(0), seats.get(1));
            findPathUp(seats.get(0), seats.get(1));
            findPathDown(seats.get(0), seats.get(1));
        }

    }

    static void findPathLeft(int x, int y){
        for (int i = y; i >= 0; i--) {
            if(room[x][i] == 1){
                if(!result[x][i]){
                    result[x][i] = true;
                    count++;
                }
                break;
            } else if(room[x][i] == 3){
                if(!result[x][i]){
                    result[x][i] = true;
                    count++;
                }
                if(x + 1 < n) findPathDown(x + 1, i);
                break;
            } else if(room[x][i] == 4){
                if(!result[x][i]){
                    result[x][i] = true;
                    count++;
                }
                if(x - 1 >= 0) findPathUp(x - 1, i);
                break;
            } else{
                if(!result[x][i]){
                    result[x][i] = true;
                    count++;
                }
            }
        }
    }
    static void findPathRight(int x, int y){
        for (int i = y; i < m; i++) {
            if(room[x][i] == 1){
                if(!result[x][i]){
                    result[x][i] = true;
                    count++;
                }
                break;
            } else if(room[x][i] == 3){
                if(!result[x][i]){
                    result[x][i] = true;
                    count++;
                }
                if(x - 1 >= 0) findPathUp(x - 1, i);
                break;
            } else if(room[x][i] == 4){
                if(!result[x][i]){
                    result[x][i] = true;
                    count++;
                }
                if(x + 1 < n) findPathDown(x + 1, i);
                break;
            } else{
                if(!result[x][i]){
                    result[x][i] = true;
                    count++;
                }
            }
        }
    }
    static void findPathDown(int x, int y){
        for (int i = x; i < n; i++) {
            if(room[i][y] == 2){
                if(!result[i][y]){
                    result[i][y] = true;
                    count++;
                }
                break;
            } else if(room[i][y] == 3){
                if(!result[i][y]){
                    result[i][y] = true;
                    count++;
                }
                if(y-1 >= 0) findPathLeft(i, y - 1);
                break;
            } else if(room[i][y] == 4){
                if(!result[i][y]){
                    result[i][y] = true;
                    count++;
                }
                if(y + 1< m) findPathRight(i, y + 1);
                break;
            } else{
                if(!result[i][y]){
                    result[i][y] = true;
                    count++;
                }
            }
        }
    }
    static void findPathUp(int x, int y){
        for (int i = x; i >= 0; i--) {
            if (room[i][y] == 2) {
                if(!result[i][y]){
                    result[i][y] = true;
                    count++;
                }
                break;
            } else if (room[i][y] == 3) {
                if(!result[i][y]) {
                    result[i][y] = true;
                    count++;
                }
                if(y + 1< m)findPathRight(i, y + 1);
                break;
            } else if (room[i][y] == 4) {
                if(!result[i][y]){
                    result[i][y] = true;
                    count++;
                }
                if(y-1 >= 0) findPathLeft(i, y - 1);
                break;
            } else {
                if (!result[i][y]) {
                    result[i][y] = true;
                    count++;
                }
            }
        }
    }
}
//40min