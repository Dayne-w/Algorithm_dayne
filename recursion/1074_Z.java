import java.io.*;
import java.util.*;

public class Main {
    static int N, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.print(recur(N, r, c));
    }

    public static int recur(int N, int r, int c) {
        if(N == 0) return 0;
        int half = (int) Math.pow(2, N-1);
        if(r < half && c < half) {
            return recur(N-1, r, c);
        }
        if(r < half) {
            return half*half + recur(N-1, r, c-half);
        }
        if(c < half) {
            return 2*half*half + recur(N-1, r-half, c);
        }
        return 3*half*half + recur(N-1, r-half, c-half);
    }
}