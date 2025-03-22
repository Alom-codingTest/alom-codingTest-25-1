package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Num2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        List<Integer> input = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < n; j++) {
                input.add(Integer.parseInt(st.nextToken()));
            }
        }

        input.sort(Comparator.reverseOrder());
        System.out.println(input.get(n-1));

    }
}
//10min
