import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yooonjeong {
	private static int n, m;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		
		func(new StringBuilder(), 1, 0);
		System.out.println(sb.toString());
	}

	private static void func(StringBuilder tmp, int start, int cnt) {
		if(cnt>=m) {
			sb.append(tmp).append("\n");
			return;
		}
		for(int i=start; i<=n; i++) {
			int len = tmp.length();
			tmp.append(i).append(" ");
			func(tmp, i+1, cnt+1);
			tmp.setLength(len);
		}
	}
}
