package arom.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num15650 {

    static int n;
    static int m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        recursive(1, 0);

    }

    /**
     *
     * @param x 1부터 n까지의 정수
     * @param y arr loc
     */

    static public void recursive(int x, int y){
        if(x > n || y ==m){
            if(y == m){
                for (int i = 0; i < m; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
            return;
        }
        arr[y] = x;
        recursive(x+1, y+1);

        recursive(x+1, y);
    }
}
//10min