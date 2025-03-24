
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Yooonjeong {

	public static void main(String[] args) throws IOException {
		Deque<Character> stack = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		char at;
		int rst=0, tmp=1;
		for(int i=0; i<in.length(); i++) {
			at = in.charAt(i);
			if(at=='(') {
				tmp*=2;
				stack.push(at);
			}
			else if(at=='[') {
				tmp*=3;
				stack.push(at);
			}
			else if(at==')') {
				if(stack.isEmpty() || stack.peek()!='(') {
					System.out.println("0");
					return;
				}
				if(in.charAt(i-1)=='(') {
					rst+=tmp;
				}
				tmp/=2;
				stack.pop();
			}
			else if(at==']') {
				if(stack.isEmpty() || stack.peek()!='[') {
					System.out.println("0");
					return;
				}
				if(in.charAt(i-1)=='[') {
					rst+=tmp;
				}
				tmp/=3;
				stack.pop();
			}
		}
		if(!stack.isEmpty()) {
			System.out.println("0");
		}
		else {
			System.out.println(rst);
		}
	}

}
