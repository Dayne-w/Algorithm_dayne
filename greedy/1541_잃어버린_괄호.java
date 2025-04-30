import java.util.*;
import java.io.*;

public class Main {

    static String expression;
    static int answer = 0;
    static StringBuilder numSB = new StringBuilder();
    static boolean minusCheck = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        expression = br.readLine();

        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '-' || ch == '+') {
                int tempNum = Integer.parseInt(numSB.toString());
                if(ch == '-' && !minusCheck) {
                    answer += tempNum;
                    minusCheck = true;
                }else {
                    if(minusCheck) {
                        answer -= tempNum;
                    }else {
                        answer += tempNum;
                    }
                }
                numSB.setLength(0);
            }else {
                numSB.append(ch);
            }
        }

        if(minusCheck) {
            answer -= Integer.parseInt(numSB.toString());
        }else {
            answer += Integer.parseInt(numSB.toString());;
        }

        System.out.println(answer);
    }
}