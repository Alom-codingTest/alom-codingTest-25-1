import java.util.*;
import java.io.*;

public class Hyeblee {
  public static int N, M;
  public static int[][] grid;
  public static int[][] horizontalSum;

  public static void horizontalCumulativeSum(){
    for(int i = 1; i <= N; i++){
      for(int j = 1; j <= N; j++){
        horizontalSum[i][j] = grid[i][j] + horizontalSum[i][j-1];
      }
    }
  }

  public static int getSum(int x1, int y1, int x2, int y2) {
    int result = 0;
    for(int i=y1; i<=y2; i++){
      result += horizontalSum[i][x2] - horizontalSum[i][x1-1];
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    grid = new int[N+1][N+1];
    horizontalSum = new int[N+1][N+1];

    for(int i=1;i<=N;i++){
      st = new StringTokenizer(br.readLine());
      for(int j=1;j<=N;j++){
        grid[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    horizontalCumulativeSum();
    for(int i=0;i<M;i++){
      st = new StringTokenizer(br.readLine());
      int y1 = Integer.parseInt(st.nextToken());
      int x1 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      System.out.println(getSum(x1,y1,x2,y2));
    }
  }
}