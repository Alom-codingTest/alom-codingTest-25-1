package arom.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2630 {

    static int whiteNum;
    static int blueNum;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check(0, n, 0, n);
        System.out.println(whiteNum);
        System.out.println(blueNum);

    }

    static void check(int widthStart, int widthEnd, int heightStart, int heightEnd){
        if(isBlue( widthStart,  widthEnd,  heightStart,  heightEnd)){
            blueNum++;
            return;
        } else if(isWhite(widthStart,  widthEnd,  heightStart,  heightEnd)){
            whiteNum++;
            return;
        } else{
            check(widthStart,  (widthEnd+widthStart)/2,  heightStart,  (heightEnd + heightStart)/2);
            check((widthEnd+widthStart)/2,  widthEnd,  (heightEnd + heightStart)/2,  heightEnd);
            check((widthEnd+widthStart)/2,  widthEnd,  heightStart,  (heightEnd + heightStart)/2);
            check(widthStart,  (widthEnd+widthStart)/2,  (heightEnd + heightStart)/2,  heightEnd);
        }
    }

    static boolean isBlue(int widthStart, int widthEnd, int heightStart, int heightEnd){
        for (int i = widthStart; i < widthEnd; i++) {
            for (int j = heightStart; j < heightEnd; j++) {
                if(arr[i][j] != 1) return false;
            }
        }
        return true;
    }
    static boolean isWhite(int widthStart, int widthEnd, int heightStart, int heightEnd){
        for (int i = widthStart; i < widthEnd; i++) {
            for (int j = heightStart; j < heightEnd; j++) {
                if(arr[i][j] != 0) return false;
            }
        }
        return true;
    }
}
//20min