import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Hyeblee {

  // 상 방향부터 시계방향
  public static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
  public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

  public static int n;
  public static int[][] grid; // 지뢰 정보 저장 배열(지뢰 = 1)
  public static boolean[][] visited; // 열렸는지 확인하는 배열
  public static int[][] result; // 지뢰 주변 정보 결과 저장하는 메서드
  public static boolean isOpen = false;

  public static boolean isInRange(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < n;
  }

  public static void paintAroundArea(int x, int y) {
    for (int i = 0; i < 8; i++) {
      int curX = x + dx[i];
      int curY = y + dy[i];
      if (isInRange(curX, curY)) {
        result[curY][curX]++;
      }
    }
  }

  // 지뢰인데 isOpen=true이면 무조건 *
  // 지뢰인데 isOpen=false이면 .로
  public static void printResult() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1 && isOpen) {
          System.out.print("*");
        } else if (!visited[i][j]) {
          System.out.print(".");
        } else {
          System.out.print(result[i][j]);
        }
      }
      System.out.println();
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    grid = new int[n][n];
    visited = new boolean[n][n];
    result = new int[n][n];

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < n; j++) {
        grid[i][j] = str.charAt(j) == '*' ? 1 : 0;
        if (grid[i][j] == 1) {
          // 주변 칠하기
          paintAroundArea(j, i);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < n; j++) {
        visited[i][j] = str.charAt(j) == 'x' ? true : false;
        if (visited[i][j] && grid[i][j] == 1) {
          isOpen = true;
        }
      }
    }
    // 결과 출력하기
    printResult();

  }
}

