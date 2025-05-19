package arom.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num17829 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(arr);


    }

    static void solution(int[][] arr){
        if(arr.length == 1){
            System.out.println(arr[0][0]);
            return;
        }else{
            int n = arr.length;
            int[][] newArr = new int[n/2][n/2];
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    newArr[i][j] = findSecondMax(2*i, 2*i+2, 2*j, 2*j+2, arr);
                }
            }
            solution(newArr);
        }
    }

    static int findSecondMax(int widthStart, int widthEnd, int heightStart, int heightEnd, int[][]arr) {
        Integer max = null;
        Integer secondMax = null;

        for (int i = widthStart; i < widthEnd; i++) {
            for (int j = heightStart; j < heightEnd; j++) {
                if(max == null || arr[i][j] > max){
                    secondMax = max;
                    max = arr[i][j];
                } else if ((secondMax == null && arr[i][j] <= max) || (secondMax < arr[i][j] && arr[i][j] <= max)) {
                    secondMax = arr[i][j];
                }
            }
        }
        return secondMax;
    }
}
//20min