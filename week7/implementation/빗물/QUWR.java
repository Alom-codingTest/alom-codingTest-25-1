package arom.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num14719 {

    static boolean[][] block;
    static int h;
    static int w;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        h = Integer.parseInt(input[0]);
        w = Integer.parseInt(input[1]);

        block = new boolean[h][w];
        input = br.readLine().split(" ");
        for (int i = 0; i < w; i++) {
            int n = Integer.parseInt(input[i]);
            for (int j = 0; j < n; j++) {
                block[j][i] = true;
            }
        }

        for (int i = 0; i < h; i++) {
            int sum = 0;
            boolean start = false;
            for (int j = 0; j < w; j++) {
                if(block[i][j]){
                    if(start){
                        result+=sum;
                        sum = 0;
                    } else start = true;
                } else{
                    if(start) sum++;
                }
            }
        }

        System.out.println(result);

    }
}
//30min