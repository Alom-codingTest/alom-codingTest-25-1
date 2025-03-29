import java.util.*;
import java.io.*;

public class Hyeblee {
	public static int n;
	public static PriorityQueue pq;
	
	public static class myComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<Integer>(new myComparator());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int elem = Integer.parseInt(st.nextToken());
				pq.offer(elem);
			}
		}
		for(int i=0;i<n-1;i++) {
			pq.poll();
		}
		System.out.println(pq.poll());
	}
}