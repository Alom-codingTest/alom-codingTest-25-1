package arom.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num12919 {

    static int min = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String t = st.nextToken();

        solve(s, t, 0);

        if(min != 100000){
            System.out.println("1");
        } else{
            System.out.println("0");
        }


    }

    private static void solve(String s, String t, int count) {
        if(s.equals(t)){
            min = count;
            return;
        }
        if(t.length() == s.length()) return;
        else{
            if(t.endsWith("A")){
                String t1 = t.substring(0, t.length()-1);
                solve(s, t1, count+1);
            }if(t.startsWith("B")){
                String t1 = t.substring(1);
                StringBuffer sb = new StringBuffer(t1);
                t1 = sb.reverse().toString();
                solve(s, t1, count +1);
            }
        }

    }
}
//20min