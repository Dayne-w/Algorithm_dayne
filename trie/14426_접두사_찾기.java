import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int ROOT = 1;
    static int unused = 2;
    static int MAX = 10000 * 500 + 5;
    static int[][] nxt = new int[MAX][26];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // trie 배열 초기화
        for(int i = 0; i < MAX; i++) {
            Arrays.fill(nxt[i], -1);
        }

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            trieInsert(str);
        }

        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            if(trieFind(str)) answer++;
        }

        System.out.print(answer);
    }

    public static void trieInsert(String s) {
        int cur = ROOT;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(nxt[cur][c2i(c)] == -1) nxt[cur][c2i(c)] = unused++;
            cur = nxt[cur][c2i(c)];
        }
    }

    public static boolean trieFind(String s) {
        int cur = ROOT;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(nxt[cur][c2i(c)] == -1) return false;
            cur = nxt[cur][c2i(c)];
        }
        return true;
    }

    public static int c2i(char c) {
        return c - 'a';
    }
}