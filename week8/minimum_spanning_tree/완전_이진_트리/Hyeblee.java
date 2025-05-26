import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Hyeblee {

  public static int k;
  public static int[] arr;
  public static List<ArrayList<Integer>> list; // depth별 노드를 저장할 list

  public static void search(int start, int end, int depth) {
    if (depth == k) {
      return;
    }

    int mid = (start + end) / 2;

    list.get(depth).add(arr[mid]);
    search(start, mid - 1, depth + 1); // 왼쪽 탐색
    search(mid + 1, end, depth + 1); // 오른쪽 탐색
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    k = Integer.parseInt(br.readLine());
    // 완전 이진트리의 노드 개수는 2^k -1 개
    arr = new int[(int) Math.pow(2, k) - 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    list = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      list.add(new ArrayList<>());
    }

    search(0, arr.length - 1, 0);

    for (int i = 0; i < k; i++) {
      for(int j : list.get(i)) {
        sb.append(j).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);

  }
}