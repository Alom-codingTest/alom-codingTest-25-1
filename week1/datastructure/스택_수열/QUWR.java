package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1874 {

    public static void main(String[] args) throws IOException {
        Deque<Integer> stack = new ArrayDeque<>();
        List<String> result = new ArrayList<>();

        // input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine()," ");
            arr[i] = Integer.parseInt(st.nextToken());
        }


        //logic
        int count = 0;      //pop 갯수
        int num = 1;        //1-n 오름차순
        int loc = 0;        //임의의 수열 위치
        while(count < n){
            if(num > n+1){
                System.out.println("NO");
                return;
            }
            if(stack.isEmpty()){
                stack.add(num++);
                result.add("+");
            }
            if(stack.peekLast() == arr[loc]){
                stack.pollLast();
                result.add("-");
                count++;
                loc++;
            } else{
                stack.add(num++);
                result.add("+");
            }

        }

        //ouput
        for (String s : result) {
            System.out.println(s);
        }


    }
}

//50min