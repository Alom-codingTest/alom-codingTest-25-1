package week1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Num21939 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());

        TreeMap<Integer, TreeSet<Integer>> levelMap = new TreeMap<>();
        HashMap<Integer, Integer> problemMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            problemMap.put(p, l);
            levelMap.putIfAbsent(l, new TreeSet<>());
            levelMap.get(l).add(p);
        }

        int m = Integer.parseInt(bf.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                problemMap.put(p, l);
                levelMap.putIfAbsent(l, new TreeSet<>());
                levelMap.get(l).add(p);

            } else if (command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    int maxLevel = levelMap.lastKey();
                    System.out.println(levelMap.get(maxLevel).last());
                } else {
                    int minLevel = levelMap.firstKey();
                    System.out.println(levelMap.get(minLevel).first());
                }

            } else if (command.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());
                if (problemMap.containsKey(p)) {
                    int l = problemMap.remove(p);
                    levelMap.get(l).remove(p);
                    if (levelMap.get(l).isEmpty()) {
                        levelMap.remove(l);
                    }
                }
            }
        }
    }
}//1h30min

