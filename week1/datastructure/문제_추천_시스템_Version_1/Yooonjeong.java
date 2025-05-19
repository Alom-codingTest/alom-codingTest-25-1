
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Yooonjeong {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		TreeSet<Entry<Integer, Integer>> rec = new TreeSet<>((a, b)->{
			if(a.getValue()==b.getValue()) {
				return Integer.compare(a.getKey(), b.getKey());
			}
			return Integer.compare(a.getValue(), b.getValue());
		});
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int a, b;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			map.put(a, b);
			rec.add(new AbstractMap.SimpleEntry<>(a, b));
		}
		int m = Integer.parseInt(br.readLine());
		String order;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			order = st.nextToken();
			switch(order) {
			case "add":
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				map.put(a, b);
				rec.add(new AbstractMap.SimpleEntry<>(a, b));
				break;
			case "recommend":
				a = Integer.parseInt(st.nextToken());
				if(a==1) sb.append(rec.last().getKey()).append("\n");
				else if(a==-1) sb.append(rec.first().getKey()).append("\n");
				break;
			case "solved":
				a = Integer.parseInt(st.nextToken());
				b = map.remove(a);
				rec.remove(new AbstractMap.SimpleEntry<>(a, b));
				break;
			}
		}
		System.out.println(sb.toString());
	}

}
