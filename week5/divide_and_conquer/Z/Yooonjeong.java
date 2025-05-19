import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yooonjeong {

	public static void main(String[] args) throws IOException {
		int n, r, c;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		System.out.println(divide(n, r, c));
	}
	
	public static int divide(int n, int r, int c) {
		if(n==0) return 0;
		int boxLen = (int) Math.pow(2, n-1);
		int boxSize = boxLen*boxLen;
		int sum = (r/boxLen*2)*boxSize;
		sum += (c/boxLen)*boxSize;
		return sum + divide(n-1, r%boxLen, c%boxLen);
	}
}
