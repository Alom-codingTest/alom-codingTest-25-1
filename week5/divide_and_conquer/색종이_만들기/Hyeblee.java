import java.util.Scanner;
import java.io.IOException;

public class Hyeblee {

  public static final int MAX_N = 128;
  public static int N;
  public static int[][] grid = new int[MAX_N][MAX_N];

  public static int blue = 0;
  public static int white = 0;

  public static void partition(int row, int col, int size) {
    // row, col 에서 시작하여 size만큼 같은 색깔로만 이루어져있는지 탐색
    if (!isAllSame(row, col, size)) {
      int newSize = size / 2;
      partition(row, col, newSize);
      partition(row + newSize, col, newSize);
      partition(row, col + newSize, newSize);
      partition(row + newSize, col + newSize, newSize);
      return;
    }
    if (grid[row][col] == 1) {
      blue++;
    } else {
      white++;
    }
  }

  public static boolean isAllSame(int row, int col, int size) {
    int first = grid[row][col];
    for (int i = row; i < row + size; i++) {
      for (int j = col; j < col + size; j++) {
        if (first != grid[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        grid[i][j] = sc.nextInt();
      }
    }

    partition(0, 0, N);
    System.out.println(white);
    System.out.println(blue);
  }
}