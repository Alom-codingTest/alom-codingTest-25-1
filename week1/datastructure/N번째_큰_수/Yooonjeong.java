
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Yooonjeong {

	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue pq = new PriorityQueue<>(Collections.reverseOrder());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}
		for(int i=0; i<n-1; i++) {
			pq.poll();
		}
		System.out.println(pq.poll());
	}

}
