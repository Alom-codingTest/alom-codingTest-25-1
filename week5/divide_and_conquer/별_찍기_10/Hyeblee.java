import java.io.*;

public class Hyeblee {

  static char arr[][];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    // 27은 3의 세제곱
    arr = new char[N][N];

    makeStar(0, 0, N, false);

    // arr 배열 출력.
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        sb.append(arr[i][j]);
      }
      sb.append('\n');
    }
    System.out.println(sb);

  }

  static void makeStar(int x, int y, int N, boolean blank) {

    // 공백칸일 경우
    if (blank) {
      for (int i = x; i < x + N; i++) {
        for (int j = y; j < y + N; j++) {
          arr[i][j] = ' ';
        }
      }
      return;
    }

    // 더이상 쪼갤 수 없는 블록일 때
    // 27 -> 9 -> 3 -> 1로 와서 N이 1일때
    if (N == 1) {
      arr[x][y] = '*';
      return;
    }

    int size = N / 3;
    int count = 0;
    for (int i = x; i < x + N; i += size) {
      for (int j = y; j < y + N; j += size) {
        count++;

        if (count == 5) {
          makeStar(i, j, size, true);
        } else {
          makeStar(i, j, size, false);
        }
      }
    }


  }
}