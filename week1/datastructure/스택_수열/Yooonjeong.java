
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Yooonjeong {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int in, top=0;
		StringBuilder sb = new StringBuilder();
		Deque<Integer> stack = new ArrayDeque<>();
		
		for(int i=0; i<n; i++) {
			in = Integer.parseInt(br.readLine());
			if(top<in) {
				for(int j=top+1; j<=in; j++) {
					stack.push(j);
					sb.append("+\n");
				}
				top = in;
			}
			else if(stack.peek()!=in) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append("-\n");
		}
		System.out.println(sb.toString());
	}
}
