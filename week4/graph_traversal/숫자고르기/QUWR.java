package arom.week4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Num2668 {

    static int n;
    static List<List<Integer>> graph = new ArrayList<>();
    static List<Integer> list;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>());
        result = new ArrayList<>();
        nList();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(0).add(i);
            graph.get(1).add(Integer.parseInt(st.nextToken()));
            list.remove(Integer.valueOf(graph.get(1).get(i-1)));
        }

        while(!list.isEmpty()){
            int remove = list.remove(0);
            if(!(graph.get(0).contains(Integer.valueOf(remove)) && graph.get(1).contains(Integer.valueOf(remove)))){
                int index = graph.get(0).indexOf(remove);
                if(index != -1) {
                    list.add(graph.get(1).remove(index));
                    graph.get(0).remove(index);
                }
            }
        }

        System.out.println(graph.get(0).size());
        for (int i = 0; i < graph.get(0).size(); i++) {
            System.out.println(graph.get(0).get(i));
        }

    }

    static void nList(){
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
    }
}//30min
