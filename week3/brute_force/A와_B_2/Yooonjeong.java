import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Yooonjeong {
   private static String S, T;
   private static int sLen;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      S = br.readLine();
      T = br.readLine();
      sLen = S.length();
      
      System.out.println(bfs()?"1":"0");
   }

   private static boolean bfs() {
	  Queue<StringBuilder> queue = new ArrayDeque<>();
	  queue.add(new StringBuilder(T));
	  while(!queue.isEmpty()) {
		  StringBuilder cur = queue.poll();
		  System.out.println(cur.toString());
		  if(S.equals(cur.toString())) return true;
		  int len = cur.length();
		  if(len<=sLen) continue;
		  if(cur.charAt(len-1)=='A') {
			  queue.add(new StringBuilder(cur.substring(0, len-1)));
		  }
		  if(cur.length()>0 && cur.charAt(0)=='B') {
			  queue.add(new StringBuilder(cur.substring(1)).reverse());
		  }
	  }
      return false;
   }
}
