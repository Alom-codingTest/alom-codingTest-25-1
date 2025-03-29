import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class subi930 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        if(makeS(T,S)) System.out.println(1);
        else System.out.println(0);
    }

    private static boolean makeS(String line, String target) {
        if(line.length() == target.length()) {
            if(target.equals(line)) return true;
            return false;
        }

        if(line.endsWith("A")){
            if(makeS(line.substring(0,line.length()-1),target)) return true;
        }

        if(line.startsWith("B")){
            String reversed = new StringBuilder(line.substring(1)).reverse().toString();
            if (makeS(reversed, target)) return true;
        }
        return false;
    }
}