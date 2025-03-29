import java.util.*;
import java.io.*;

// 1~n의 숫자를 오름차순으로 push하는데, 이 스택을 중간에 pop하여 입력받은 수열 만들기



public class Hyeblee {
	public static int n;
	public static Deque<Integer> stack = new ArrayDeque<>();
	public static StringBuilder sb = new StringBuilder("");
	public static int element = 1;
	
	public static boolean makeSequence(int num) {
		// n이 아직 스택에 없다면, element 키우면서 스택에 넣어주기
		while(element <= num) {
			stack.push(element++);
			sb.append("+\n");
		}
		while(!stack.isEmpty()) {
			sb.append("-\n");
			if(stack.pop()==num) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			if(!makeSequence(num)) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println(sb);
	}
}