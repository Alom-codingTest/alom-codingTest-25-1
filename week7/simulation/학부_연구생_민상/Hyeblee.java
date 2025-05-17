import java.util.*;
import java.io.*;

public class Hyeblee {

  public static int n, m;
  public static int[][] grid;
  public static boolean[][] visited;
  public static int[] fanX = new int[50];
  public static int[] fanY = new int[50];
  public static int fanCnt = 0;
  // 상 하 좌 우
  public static int[] dx = {-0, 0, -1, 1};
  public static int[] dy = {-1, 1, 0, 0};


  public static boolean isInRange(int x, int y) {
    return x >= 0 && x < m && y >= 0 && y < n;
  }

  public static void go(int x, int y, int dir) {

    visited[y][x] = true;
    x += dx[dir];
    y += dy[dir];
    if (!isInRange(x, y)) {
      return;
    }
    visited[y][x] = true;
    int cur = grid[y][x];
    // 다음칸 전진하기
    switch (cur) {
      case 0:
        go(x, y, dir);
        break;
      case 1: // 상하면 전진 가능
        if (dir == 0 || dir == 1) {
          go(x, y, dir);
        }
        break;
      case 2: // 좌우면 가능
        if (dir == 2 || dir == 3) {
          go(x, y, dir);
        }
        break;
      case 3: // 다 가능인데 방향 90도 꺽임
        if (dir == 0) // 상
        {
          dir = 3; // 우
        } else if (dir == 1) // 하
        {
          dir = 2; // 좌
        } else if (dir == 2) // 좌
        {
          dir = 1; // 하
        } else if (dir == 3) // 우
        {
          dir = 0; // 상
        }
        go(x, y, dir);
        break;
      case 4:
        if (dir == 0) // 상
        {
          dir = 2; // 좌
        } else if (dir == 1) // 하
        {
          dir = 3; // 우
        } else if (dir == 2) // 좌
        {
          dir = 0; // 상
        } else if (dir == 3) // 우
        {
          dir = 1; // 하
        }
        go(x, y, dir);
        break;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    grid = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j <m; j++) {
        grid[i][j] = Integer.parseInt(st.nextToken());
        if (grid[i][j] == 9) {
          fanX[fanCnt] = j;
          fanY[fanCnt++] = i;
        }
      }
    }

    for (int i = 0; i < fanCnt; i++) {
      visited[fanY[i]][fanX[i]] = true;
      go(fanX[i], fanY[i], 0);
      go(fanX[i], fanY[i], 1);
      go(fanX[i], fanY[i], 2);
      go(fanX[i], fanY[i], 3);
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (visited[i][j]) {
          result++;
        }
      }
    }

    System.out.println(result);
  }
}