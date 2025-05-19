import java.util.Scanner;
import java.io.IOException;

public class Hyeblee {

  public static int N, r, c, cnt = 0;

  public static void find(int r, int c, int size) {
    if (size == 1) {
      return;
    }
    size /= 2;
    if (r < size && c < size) { // 1사분면
      find(r, c, size);
    } else if (r < size && c >= size) { // 2사분면
      find(r, c - size, size);
      cnt += size * size;
    } else if (r >= size && c < size) { // 3사분면
      find(r - size, c, size);
      cnt += size * size * 2;
    } else if (r >= size && c >= size) { // 4사분면
      find(r - size, c - size, size);
      cnt += size * size * 3;
    }
  }

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    r = sc.nextInt();
    c = sc.nextInt();

    find(r, c, (int) Math.pow(2, N));
    System.out.println(cnt);
  }

}