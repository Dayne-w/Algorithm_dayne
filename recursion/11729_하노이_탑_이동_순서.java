import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int answer = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        recur(N, 1, 3);

        System.out.print(answer + "\n" + sb);
    }

    public static void recur(int k, int s, int e) {
        if(k == 1) {
            sb.append(s).append(" ").append(e).append('\n');
            answer++;
            return;
        }
        recur(k-1, s, 6-s-e);
        sb.append(s).append(" ").append(e).append('\n');
        answer++;
        recur(k-1, 6-s-e, e);
    }
}