import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static Map<String, String> m = new HashMap<>();
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            m.put(st.nextToken(), st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            answerSB.append(m.get(str)).append('\n');
        }

        System.out.print(answerSB);
    }
}