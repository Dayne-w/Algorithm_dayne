import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] paper;
    static int cntMinus = 0;
    static int cntZero = 0;
    static int cntPlus = 0;

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

        recursion(0, 0, N);
        System.out.println(cntMinus);
        System.out.println(cntZero);
        System.out.print(cntPlus);

    }

    public static void recursion(int x, int y, int size) {
        if(size == 0) return;

        int pre = paper[y][x];
        boolean check = false;
        for(int i = y; i < y + size; i++) {
            for(int j = x; j < x + size; j++) {
                if (pre != paper[i][j]) {
                    check = true;
                    break;
                }
            }
        }

        if(check) {
            int temp = size / 3;
            recursion(x,y,temp);
            recursion(x+temp, y, temp);
            recursion(x+(temp*2), y, temp);
            recursion(x,y+temp,temp);
            recursion(x+temp, y+temp, temp);
            recursion(x+(temp*2), y+temp, temp);
            recursion(x,y+(temp*2),temp);
            recursion(x+temp, y+(temp*2), temp);
            recursion(x+(temp*2), y+(temp*2), temp);
        }else {
            if(pre == -1) cntMinus++;
            if(pre == 0) cntZero++;
            if(pre == 1) cntPlus++;
        }
    }
}