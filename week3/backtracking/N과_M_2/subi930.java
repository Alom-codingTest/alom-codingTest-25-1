import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class subi930 {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        makeArr(1,0);

        System.out.println(sb.toString());

    }

    private static void makeArr(int num,int length) {
        if(length == M){
            for(int a: arr){
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }

        if(num > N) return;

        arr[length] = num;

        makeArr(num+1,length+1);
        makeArr(num+1,length);
    }

}