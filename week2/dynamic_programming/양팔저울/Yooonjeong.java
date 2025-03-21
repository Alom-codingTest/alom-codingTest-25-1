import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Yooonjeong {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int in;
        Set<Integer> set = new HashSet<>();
        Set<Integer> temp;
        set.add(0);
        for(int i=0; i<n; i++) {
        	in = Integer.parseInt(st.nextToken());
        	temp = new HashSet<>();
        	for(int s:set) {
        		temp.add(s+in);
        		temp.add(Math.abs(s-in));
        	}
        	set.addAll(temp);
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            in = Integer.parseInt(st.nextToken());
            sb.append(set.contains(in) ? "Y " : "N ");
        }
        System.out.println(sb.toString());
    }
}
