import java.util.*;
import java.io.*;

public class Main {

    static int T;
    static int I;
    static int curX, curY;
    static int destX, destY;
    static int[][] board;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            I = Integer.parseInt(br.readLine());
            board = new int[I][I];

            for(int i = 0; i < I; i++) {
                Arrays.fill(board[i], -1);
            }

            st = new StringTokenizer(br.readLine());
            curX = Integer.parseInt(st.nextToken());
            curY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            destX = Integer.parseInt(st.nextToken());
            destY = Integer.parseInt(st.nextToken());

            BFS(curX, curY);

            answerSB.append(board[destY][destX]).append('\n');
        }

        System.out.print(answerSB.toString());
    }

    public static void BFS(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        board[y][x] = 0;
        while(!q.isEmpty()) {
            Pair cur = q.remove();
            for(int i = 0; i < 8; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if(nextX < 0 || nextX >= I || nextY < 0 || nextY >= I) continue;
                if(board[nextY][nextX] == -1 || board[nextY][nextX] > board[cur.y][cur.x] + 1) {
                    board[nextY][nextX] = board[cur.y][cur.x] + 1;
                    q.add(new Pair(nextX, nextY));
                }
            }
        }
    }

    public static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}