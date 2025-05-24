import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Hyeblee {

  public static int n, m;
  public static int[][] grid;
  public static boolean[][] visited;
  public static boolean[][] result;
  public static int[] dy = {-1, 1, 0, 0};
  public static int[] dx = {0, 0, -1, 1};
  public static List<Node> cctv5 = new ArrayList<>();
  public static List<Node> cctv4 = new ArrayList<>();
  public static List<Node> cctv3 = new ArrayList<>();
  public static List<Node> cctv2 = new ArrayList<>();
  public static List<Node> cctv1 = new ArrayList<>();

  public static class Node {

    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static boolean isInRange(int x, int y) {
    return x >= 0 && x < m && y >= 0 && y < n;
  }

  // 우선 각 방향 false가 아닌 갯수를 찾느다.
  // 색칠할 친구들만 색칠한다.

  public static int getCnt(int x, int y, int dir, int cnt) {
    if (!visited[y][x]) {
      cnt++;
    }
    x += dx[dir];
    y += dy[dir];
    if (isInRange(x, y)) {
      return getCnt(x, y, dir, cnt);
    }
    return cnt;
  }

  public static void go(int x, int y, int dir) {
    visited[y][x] = true;
    x += dx[dir];
    y += dy[dir];
    if (isInRange(x, y) && grid[y][x] == 0) {
      go(x, y, dir);
    }
  }


  public static void cctv5() {
    for (Node node : cctv5) {
      int curX = node.x;
      int curY = node.y;
      go(curX, curY, 0);
      go(curX, curY, 1);
      go(curX, curY, 2);
      go(curX, curY, 3);
    }
  }

  public static void cctv4() {
    for (Node node : cctv4) {
      int curX = node.x;
      int curY = node.y;
      int upCnt = getCnt(curX, curY, 0, 0);
      int downCnt = getCnt(curX, curY, 1, 0);
      int leftCnt = getCnt(curX, curY, 2, 0);
      int rightCnt = getCnt(curX, curY, 3, 0);
      int min = Math.min(Math.min(upCnt, rightCnt), Math.min(downCnt, leftCnt));
      if (min == upCnt) {
        go(curX, curY, 1);
        go(curX, curY, 2);
        go(curX, curY, 3);
      } else if (min == downCnt) {
        go(curX, curY, 0);
        go(curX, curY, 2);
        go(curX, curY, 3);
      } else if (min == leftCnt) {
        go(curX, curY, 0);
        go(curX, curY, 1);
        go(curX, curY, 3);
      } else if (min == rightCnt) {
        go(curX, curY, 0);
        go(curX, curY, 1);
        go(curX, curY, 2);
      }
    }
  }

  public static void cctv3() {
    for (Node node : cctv3) {
      int curX = node.x;
      int curY = node.y;
      int upCnt = getCnt(curX, curY, 0, 0);
      int downCnt = getCnt(curX, curY, 1, 0);
      int leftCnt = getCnt(curX, curY, 2, 0);
      int rightCnt = getCnt(curX, curY, 3, 0);

      int result1 = upCnt + rightCnt;
      int result2 = rightCnt + downCnt;
      int result3 = downCnt + leftCnt;
      int result4 = leftCnt + upCnt;

      int max = Math.max(Math.min(result1, result2), Math.min(result3, result4));
      if (max == result1) {
        go(curX, curY, 0);
        go(curX, curY, 3);
      } else if (max == result2) {
        go(curX, curY, 3);
        go(curX, curY, 1);
      } else if (max == result3) {
        go(curX, curY, 1);
        go(curX, curY, 2);
      } else if (max == result4) {
        go(curX, curY, 2);
        go(curX, curY, 0);
      }
    }
  }


  public static void cctv2() {
    for (Node node : cctv2) {
      int curX = node.x;
      int curY = node.y;
      int upCnt = getCnt(curX, curY, 0, 0);
      int downCnt = getCnt(curX, curY, 1, 0);
      int leftCnt = getCnt(curX, curY, 2, 0);
      int rightCnt = getCnt(curX, curY, 3, 0);

      int result1 = upCnt + downCnt;
      int result2 = rightCnt + leftCnt;

      int max = Math.max(result1, result2);
      if (max == result1) {
        go(curX, curY, 0);
        go(curX, curY, 1);
      } else if (max == result2) {
        go(curX, curY, 2);
        go(curX, curY, 3);
      }
    }
  }


  public static void cctv1() {
    for (Node node : cctv1) {
      int curX = node.x;
      int curY = node.y;
      int upCnt = getCnt(curX, curY, 0, 0);
      int downCnt = getCnt(curX, curY, 1, 0);
      int leftCnt = getCnt(curX, curY, 2, 0);
      int rightCnt = getCnt(curX, curY, 3, 0);

      int result1 = upCnt;
      int result2 = downCnt;
      int result3 = leftCnt;
      int result4 = rightCnt;

      int max = Math.max(Math.min(result1, result2), Math.min(result3, result4));
      if (max == result1) {
        go(curX, curY, 0);
      } else if (max == result2) {
        go(curX, curY, 1);
      } else if (max == result3) {
        go(curX, curY, 2);
      } else if (max == result4) {
        go(curX, curY, 3);
      }
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
      for (int j = 0; j < m; j++) {
        grid[i][j] = Integer.parseInt(st.nextToken());
        if (grid[i][j] != 0 && grid[i][j] != 6) {
          switch (grid[i][j]) {
            case 1:
              cctv1.add(new Node(j, i));
              break;
            case 2:
              cctv2.add(new Node(j, i));
              break;
            case 3:
              cctv3.add(new Node(j, i));
              break;
            case 4:
              cctv4.add(new Node(j, i));
              break;
            case 5:
              cctv5.add(new Node(j, i));
              break;
          }
        }
      }

    }
    cctv5();
    cctv4();
    cctv3();
    cctv2();
    cctv1();
    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if(visited[i][j]) {
          result++;
        }
      }
    }

    System.out.println(result);


  }
}