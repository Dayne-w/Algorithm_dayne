import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] paper;
    static int whitePaper = 0, bluePaper = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0, N);

        System.out.println(whitePaper);
        System.out.println(bluePaper);
    }

    public static void recur(int x, int y, int size) {
        if(size == 0) return;

        if(!check(x, y, size)) {
            recur(x, y, size/2);
            recur(x + size/2, y, size/2);
            recur(x, y + size/2, size/2);
            recur(x + size/2, y + size/2, size/2);

        }else {
            if(paper[y][x] == 0) {
                whitePaper++;
            }else {
                bluePaper++;
            }
        }
    }

    public static boolean check(int x, int y, int size) {
        int val = paper[y][x];
        for(int i = y; i < y + size; i++) {
            for(int j = x; j < x + size; j++) {
                if(val != paper[i][j]) return false;
            }
        }
        return true;
    }
}