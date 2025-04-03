import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int idx = 0;
    static LinkedList<Long> list = new LinkedList<>();
    static StringBuilder answerSb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        while(idx < N) {
            while(st.hasMoreElements()) {
                StringBuilder strBuilder = new StringBuilder(st.nextToken());
                strBuilder.reverse();
                list.add(Long.parseLong(String.valueOf(strBuilder)));
                idx++;
            }
            if(idx != N) {
                st = new StringTokenizer(br.readLine());
            }
        }

        list.sort(Comparator.naturalOrder());

        for(Long n : list) {
            answerSb.append(n).append('\n');
        }

        System.out.print(answerSb);
    }
}