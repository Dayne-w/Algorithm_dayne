import java.io.*;
import java.util.*;

public class Main {

    static int T, N, M, K;
    static int[][] ground = new int[51][51];
    static boolean[][] visited = new boolean[51][51];
    static ArrayList<Pair> locations = new ArrayList<>();
    static StringBuilder answerSB = new StringBuilder();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // locations 초기화
            locations.clear();

            // ground, visited 초기화
            for(int i = 0; i <= 50; i++) {
                Arrays.fill(ground[i], 0);
                Arrays.fill(visited[i], false);
            }

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                ground[y][x] = 1;
                locations.add(new Pair(y, x));
            }

            for(Pair p : locations) {
                if(!visited[p.y][p.x]) {
                    cnt++;
                    BFS(p.y, p.x);
                }
            }

            answerSB.append(cnt).append('\n');
        }

        System.out.print(answerSB.toString());
    }

    public static void BFS(int y, int x) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y, x));
        visited[y][x] = true;
        while(!q.isEmpty()) {
            Pair cur = q.remove();
            for(int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
                if(!visited[nextY][nextX] && ground[nextY][nextX] == 1) {
                    q.add(new Pair(nextY, nextX));
                    visited[nextY][nextX] = true;
                }
            }
        }
    }

    public static class Pair {
        public int y;
        public int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}