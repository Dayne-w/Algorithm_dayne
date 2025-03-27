import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int ROOT = 1;
    static int unused = 2;
    static int MX = 500 * 10000 + 5;
    static boolean[] check = new boolean[MX];
    static int[][] next = new int [MX][26];
    static int answer = 0;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        fillNext();

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            insert(str);
        }

        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            if(find(str)) answer++;
        }

        System.out.print(answer);

    }

    public static void insert(String s) {
        int cur = ROOT;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(next[cur][c2i(c)] == -1) {
                next[cur][c2i(c)] = unused++;
            }
            cur = next[cur][c2i(c)];
        }
        check[cur] = true;
    }

    public static boolean find(String s) {
        int cur = ROOT;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(next[cur][c2i(c)] == -1) {
                return false;
            }
            cur = next[cur][c2i(c)];
        }
        return check[cur];
    }

    public static void fillNext() {
        for(int i = 0; i < MX; i++) {
            Arrays.fill(next[i], -1);
        }
    }

    public static int c2i (char c) {
        return c - 'a';
    }

}