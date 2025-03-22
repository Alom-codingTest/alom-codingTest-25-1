import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class subi930 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        List<Character> list = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0; i< N; i++) arr[i] = Integer.parseInt(br.readLine());

        int num = 1;

        for(int a : arr){
            if(stack.isEmpty() || stack.peek() < a){
                while(num <= a){
                    stack.push(num++);
                    list.add('+');
                }
                if(!stack.isEmpty()) {
                    stack.pop();
                    list.add('-');
                }
            }
            else if(stack.peek() > a) {
                System.out.println("NO");
                return;
            }
            else {
                stack.pop();
                list.add('-');
            }

        }
        for(Character e : list) System.out.println(e);
    }
}